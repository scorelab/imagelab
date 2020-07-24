package com.imagelab;

import com.imagelab.components.OperatorUIElement;
import com.imagelab.components.RGBChangeOpUIElement;
import com.imagelab.components.ReadImageOpUIElement;
import com.imagelab.components.ToGrayScaleOpUIElement;
import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import static com.imagelab.utils.Constants.ANY_NODE;

/**
 * The controller class of the dashboard
 */
public class DashboardController implements Initializable {

    @FXML
    private Pane buildPane;

    @FXML
    private VBox operationsVBox;

    @FXML
    private AnchorPane operationsPane;

    private OperatorUIElement<Node> currentlyApplyingOperator;

    private final Stack<OperatorUIElement<Node>> appliedOperators;

    public DashboardController() {
        this.appliedOperators = new Stack<>();
    }

    //To capture mouse position of the user
    private double dropX, dropY;

    @FXML
    public void onExecuteClicked(ActionEvent event) {
        appliedOperators.forEach((op) -> System.out.println(op.getUiOperatorID()));
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

        assert currentlyApplyingOperator != null : "currentlyApplyingOperator cannot be null here...";

        double relocateX = currentlyApplyingOperator.getWidth() / 2;
        double relocateY = currentlyApplyingOperator.getHeight() / 4;

        System.out.println("drop x :"+dropX + " | " +"drop Y :"+dropY);
        relocateX = dropX - relocateX;
        relocateY = dropY- relocateY;
        System.out.println("relocate x :"+relocateX + " | " +"relocate Y :"+relocateY);

        Dragboard dragboard = event.getDragboard();
        if (dragboard.hasContent(ANY_NODE)) {
            if (buildPane.getChildren().contains(currentlyApplyingOperator.getNode())) {
                currentlyApplyingOperator.getNode().relocate(relocateX, relocateY);
            } else {
                currentlyApplyingOperator.getNode().setLayoutX(relocateX);
                currentlyApplyingOperator.getNode().setLayoutY(relocateY);
                buildPane.getChildren().add(currentlyApplyingOperator.getNode());
            }
            if (!this.currentlyApplyingOperator.isAddedToOperationQueue()){
                this.appliedOperators.push(currentlyApplyingOperator);
                this.currentlyApplyingOperator.setIsAddedToOperationQueue(true);
                System.out.println(currentlyApplyingOperator.getUiOperatorName()+" has been added to the operation queue");
            }else{
                System.out.println("This operator is already in the queue");
            }

            event.setDropCompleted(true);
            event.consume();
        }
        System.out.println("Drop detected: " + currentlyApplyingOperator.getUiOperatorID()+"\n");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        final OnUIElementCloneCreated anyCloneCreated = (uiElement) -> {
            this.currentlyApplyingOperator = ((OperatorUIElement<Node>) uiElement);
        };

        final OnUIElementDragDone anyElementDragDone = (ignored) -> {
            this.currentlyApplyingOperator = null;
        };

        //Initiating read image operation related UI element
        ReadImageOpUIElement readImageOpUIElement = new ReadImageOpUIElement(
                anyCloneCreated,
                anyElementDragDone,
                "readImage",
                true,
                "imagelab.operator.readImageOpUIElement",
                "Read Image",
                false,
                100d,
                60d,
                true);

        //Initiating RGB conversions operation related UI element
        RGBChangeOpUIElement rgbChangeOpUIElement = new RGBChangeOpUIElement(
                anyCloneCreated,
                anyElementDragDone,
                "rgbConvert",
                true,
                "imagelab.operator.rgbChangeOpUIElement",
                "RGB Convert",
                false,
                100d,
                60d,
                true);

        //Initiating gray scale operation related UI element
        ToGrayScaleOpUIElement toGrayScaleOpUIElement = new ToGrayScaleOpUIElement(
                anyCloneCreated,
                anyElementDragDone,
                "toGrayScale",
                true,
                "imagelab.operator.toGrayScaleOpUIElement",
                "Grey Scale",
                false,
                100d,
                60d,
                true);

        operationsVBox.setSpacing(15);

        //Populating or adding created UI elements to left operators panel
        operationsVBox.getChildren().addAll(
                readImageOpUIElement.getNode(),
                rgbChangeOpUIElement.getNode(),
                toGrayScaleOpUIElement.getNode()
        );

    }
}
