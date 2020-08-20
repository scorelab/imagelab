package com.imagelab;

import com.imagelab.components.*;
import com.imagelab.components.basic.ReadImageOpUIElement;
import com.imagelab.components.basic.WriteImageOpUIElement;
import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import com.imagelab.components.geotransformation.RotateImageOpUIElement;
import com.imagelab.components.imageconversion.ConvertToGrayOpUIElement;
import com.imagelab.components.miscellaneous.CannyEdgeDetectOpUIElement;
import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.utils.Utilities;
import com.imagelab.views.ProcessedImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.opencv.core.Mat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import static com.imagelab.utils.Constants.ANY_NODE;

/**
 * The controller class of the dashboard
 */
public class DashboardController implements Initializable {


    private final Stack<OperatorUIElement<Node, Node, Node>> appliedOperators; //Stack which holds all the UI elements dragged and dropped into the playground.
    private OperatorUIElement<Node, Node, Node> curApplyingOpUIElement; //To capture the latest applied operator to the playground.
    private double dropX, dropY; //To capture mouse position of the user.

    /**
     * playground: : the pane where users build the pipeline by
     * dragging and dropping operator ui elements.
     */
    @FXML
    private Pane playground;

    /**
     * Operator Containers
     * <p>
     * basicOperatorsContainer - contains - ReadImage, WriteImage.
     * geoTransformationOperatorsContainer contains - RotateImage, Affine Transformation, Scaling, Color Maps.
     * imageConversionsOperatorsContainer - contains - ConvertToGrayscale, ColoredToBinary, GrayScaleToBinary.
     * drawingOperatorsContainer - contains - DrawLine, DrawCircle, DrawRectangle, DrawEllipse, DrawPolyline.
     * miscellaneousOperatorsContainer - contains - CannyEdgeDetection
     */
    @FXML
    private VBox basicOperatorsContainer;
    @FXML
    private VBox geoTransformationOperatorsContainer;
    @FXML
    private VBox imageConversionsOperatorsContainer;
    @FXML
    private VBox drawingOperatorsContainer;
    @FXML
    private VBox miscellaneousOperatorsContainer;


    @FXML
    private AnchorPane previewPane;


    @FXML
    private ScrollPane uiElementPropertiesPane;

    @FXML
    private ScrollPane informationScrollPane;

    public DashboardController() {
        this.appliedOperators = new Stack<>();
    }

    @FXML
    public void onExecuteClicked(ActionEvent event) throws IOException {

        Mat image = null;

        for (OperatorUIElement<Node, Node, Node> op : appliedOperators) {
            image = op.getOperator().compute(image);
        }

        //Displaying the processed image in the preview pane
        WritableImage writableImage = Utilities.loadImage(image, ".jpg");
        ProcessedImageView processedImage = new ProcessedImageView(writableImage);
        previewPane.getChildren().addAll(processedImage);
    }

    /**
     * To handle when users initial drag event.
     *
     * @param event Triggered Drag event.
     *              When user tried to drag something and
     *              move over to another area
     *              this function will be invoked.
     */
    @FXML
    private void handleDragOver(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        if (dragboard.hasContent(ANY_NODE)) {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        dropX = event.getX();
        dropY = event.getY();
    }

    /**
     * To handle when users initial drag event.
     *
     * @param event Triggered Drop event.
     *              When user dropped the dragged
     *              element this function will
     *              trigger.
     */
    @FXML
    private void handleDrop(DragEvent event) {

        // if this was the initial move then no need to validate. just move on to the next step.
        if (appliedOperators.size() == 0 && curApplyingOpUIElement.getOperator() instanceof ReadImage) {
            proceedToMoveOperator(event);
        } else {
            if (appliedOperators.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Error");
                alert.setContentText("Invalid initial operator!");
                alert.showAndWait();
                return;
            }
            OpenCVOperator operator = appliedOperators.peek().getOperator();
            boolean isValid = curApplyingOpUIElement.getOperator().validate(operator);
            if (!isValid) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Error");
                alert.setContentText("You are trying to apply an invalid operator on top of " + curApplyingOpUIElement.getOperatorName());
                alert.showAndWait();
                System.err.println("cannot drag this element on top of : " + curApplyingOpUIElement.getOperatorName());
                return;
            }
            proceedToMoveOperator(event);
        }

    }

    private void proceedToMoveOperator(DragEvent event) {

        assert curApplyingOpUIElement != null : "currentlyApplyingOperator cannot be null here...";

        double relocateX = dropX - (curApplyingOpUIElement.getWidth() / 2);
        double relocateY = dropY - (curApplyingOpUIElement.getHeight() / 4);

        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasContent(ANY_NODE)) {
            if (playground.getChildren().contains(curApplyingOpUIElement.getNode())) {
                curApplyingOpUIElement.getNode().relocate(relocateX, relocateY);
            } else {
                curApplyingOpUIElement.getNode().setLayoutX(relocateX);
                curApplyingOpUIElement.getNode().setLayoutY(relocateY);
                playground.getChildren().add(curApplyingOpUIElement.getNode());
            }
            if (!this.curApplyingOpUIElement.isAddedToOperatorsStack()) {
                this.appliedOperators.push(curApplyingOpUIElement);
                this.curApplyingOpUIElement.setAddedToOperatorsStack(true);
                System.out.println(curApplyingOpUIElement.getOperatorName() + " has been added to the operation stack");
            } else {
                System.out.println("This operator is already in the queue");
            }

            event.setDropCompleted(true);
            event.consume();
        }
        System.out.println("Drop detected: " + curApplyingOpUIElement.getOperatorName() + "\n");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        final OnUIElementCloneCreated anyCloneCreated = (uiElement) -> {
            //noinspection unchecked
            this.curApplyingOpUIElement = ((OperatorUIElement<Node, Node, Node>) uiElement);
        };

        final OnUIElementDragDone anyElementDragDone = (opUiEl) -> {
            if (opUiEl == null) {
                this.uiElementPropertiesPane.setContent(null);
                this.informationScrollPane.setContent(null);
            } else {
                this.uiElementPropertiesPane.setContent(opUiEl.getForm());
                this.informationScrollPane.setContent(opUiEl.getInformation());
            }
            this.curApplyingOpUIElement = null;
        };

        // basicOperatorsContainer
        basicOperatorsContainer.setSpacing(15);
        // basicOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        basicOperatorsContainer.setLayoutY(20);
        basicOperatorsContainer.setLayoutX(20);

        ReadImageOpUIElement readImageOpUIElement = new ReadImageOpUIElement( // Initiating readImageOpUIElement
                anyCloneCreated,
                anyElementDragDone,
                uiElementPropertiesPane,
                informationScrollPane
        );
        WriteImageOpUIElement writeImageOpUIElement = new WriteImageOpUIElement( // Initiating writeImageOpUIElement
                anyCloneCreated,
                anyElementDragDone,
                uiElementPropertiesPane,
                informationScrollPane
        );
        readImageOpUIElement.buildNode();
        writeImageOpUIElement.buildNode();

        basicOperatorsContainer.getChildren().addAll(  // Populating basicOperatorsContainer
                readImageOpUIElement.getNode(),
                writeImageOpUIElement.getNode()
        );

        // geoTransformationOperatorsContainer
        geoTransformationOperatorsContainer.setSpacing(15);
        // imageConversionsOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        geoTransformationOperatorsContainer.setLayoutY(20);
        geoTransformationOperatorsContainer.setLayoutX(20);

        RotateImageOpUIElement rotateImageOpUIElement = new RotateImageOpUIElement( // Initiating rotateImageOpUIElement
                anyCloneCreated,
                anyElementDragDone,
                uiElementPropertiesPane,
                informationScrollPane
        );
        rotateImageOpUIElement.buildNode();

        geoTransformationOperatorsContainer.getChildren().addAll( // Populating geoTransformationOperatorsContainer
                rotateImageOpUIElement.getNode()
        );

        // imageConversionsOperatorsContainer
        imageConversionsOperatorsContainer.setSpacing(15);
        // imageConversionsOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        imageConversionsOperatorsContainer.setLayoutY(20);
        imageConversionsOperatorsContainer.setLayoutX(20);

        ConvertToGrayOpUIElement convertToGrayOpUIElement = new ConvertToGrayOpUIElement( // Initiating convertToGrayOpUIElement
                anyCloneCreated,
                anyElementDragDone,
                uiElementPropertiesPane,
                informationScrollPane
        );
        convertToGrayOpUIElement.buildNode();

        imageConversionsOperatorsContainer.getChildren().addAll( // Populating imageConversionsOperatorsContainer
                convertToGrayOpUIElement.getNode()
        );

        // miscellaneousOperatorsContainer
        miscellaneousOperatorsContainer.setSpacing(15);
        // imageConversionsOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        miscellaneousOperatorsContainer.setLayoutY(20);
        miscellaneousOperatorsContainer.setLayoutX(20);

        CannyEdgeDetectOpUIElement cannyEdgeDetectOpUIElement = new CannyEdgeDetectOpUIElement( // Initiating cannyEdgeDetectOpUIElement
                anyCloneCreated,
                anyElementDragDone,
                uiElementPropertiesPane,
                informationScrollPane
        );
        cannyEdgeDetectOpUIElement.buildNode();

        miscellaneousOperatorsContainer.getChildren().addAll( // Populating miscellaneousOperatorsContainer
                cannyEdgeDetectOpUIElement.getNode()
        );

    }

}
