package com.imagelab;

import com.imagelab.components.OperatorUIElement;
import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.geotransformation.RotateImage;
import com.imagelab.operators.imagebluring.ApplyBlurEffect;
import com.imagelab.operators.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operators.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operators.imageconversion.ColoredImageToBinary;
import com.imagelab.operators.imageconversion.ConvertToGrayscale;
import com.imagelab.operators.imageconversion.GrayscaleToBinary;
import com.imagelab.utils.Utilities;
import com.imagelab.views.AbstractInformationUI;
import com.imagelab.views.InformationContainerView;
import com.imagelab.views.ProcessedImageView;
import com.imagelab.views.forms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
 * The controller class of the dashboard.
 */
public class DashboardController implements Initializable {
    /**
     * Stack which holds all the UI elements
     * dragged and dropped into the playground.
     */
    private final Stack<OperatorUIElement> appliedOperators;

    /**
     * To capture the latest applied operator
     * to the playground.
     */
    private OperatorUIElement curApplyingOpUIElement;

    /**
     * To capture mouse position of the user.
     * dropX - X drag position.
     */
    private double dropX;
    /**
     * To capture mouse position of the user.
     * dropY - Y drag position.
     */
    private double dropY;

    /**
     * playground: : the pane where users build the pipeline by
     * dragging and dropping operator ui elements.
     */
    @FXML
    private Pane playground;

    /**
     * basicOperatorsContainer contains,
     * ReadImage
     * WriteImage.
     */
    @FXML
    private VBox basicOperatorsContainer;

    /**
     * geoTransformationOperatorsContainer contains,
     * RotateImage,
     * Affine Transformation.
     */
    @FXML
    private VBox geoTransformationOperatorsContainer;

    /**
     * imageConversionsOperatorsContainer contains,
     * ConvertToGrayscale,
     * ColoredToBinary,
     * GrayScaleToBinary.
     */
    @FXML
    private VBox imageConversionsOperatorsContainer;

    /**
     * blurringOperatorsContainer contains,
     * simpleBlurring,
     * gaussianBlurring,
     * medianBlurring.
     */
    @FXML
    private VBox blurringOperatorsContainer;

    /**
     * previewPane which outputs the
     * processed preview.
     */
    @FXML
    private AnchorPane previewPane;

    /**
     * uiElementPropertiesPane which contains
     * the each element related properties.
     */
    @FXML
    private ScrollPane uiElementPropertiesPane;

    /**
     * informationScrollPane which shows the
     * information related to the operators dragged
     * to the playground.
     */
    @FXML
    private ScrollPane informationScrollPane;

    /**
     * Controller constructor.
     */
    public DashboardController() {
        this.appliedOperators = new Stack<>();
    }

    /**
     * Method which executes the operation order ones
     * the user clicked on the run button related to the playground.
     *
     * @param event - onClick Mouse Event.
     * @throws IOException - if the event was not captured.
     */
    @FXML
    public void onExecuteClicked(ActionEvent event) throws IOException {
        Mat image = null;
        for (OperatorUIElement op : appliedOperators) {
            image = op.operator.compute(image);
        }
        //Displaying the processed image in the preview pane
        WritableImage writableImage;
        writableImage = Utilities.loadImage(image, ".jpg");
        ProcessedImageView processedImage;
        processedImage = new ProcessedImageView(writableImage);
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
        System.out.println(curApplyingOpUIElement.operatorName);
        // if this was the initial move then no need to validate.
        // just move on to the next step.
        if (appliedOperators.size() == 0
                && curApplyingOpUIElement.operator instanceof ReadImage) {
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
            OpenCVOperator operator = appliedOperators.peek().operator;
            boolean isValid;
            isValid = curApplyingOpUIElement.operator.validate(operator);
            if (!isValid) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Error");
                alert.setContentText("You are trying to apply an"
                        + " invalid operator on top of "
                        + curApplyingOpUIElement.operatorName);
                alert.showAndWait();
                System.err.println("cannot drag this element on top of : "
                        + curApplyingOpUIElement.operatorName);
                return;
            }
            proceedToMoveOperator(event);
        }
    }

    /**
     * This method handles the the logic related to moving and UI element and
     * relocating it in a new position.
     *
     * @param event - dragEvent
     */
    private void proceedToMoveOperator(DragEvent event) {

        assert curApplyingOpUIElement != null : "currentlyApplyingOperator"
                + " cannot be null here...";

        double relocateX = dropX - (OperatorUIElement.WIDTH / 2);
        double relocateY = dropY - (OperatorUIElement.HEIGHT / 4);

        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasContent(ANY_NODE)) {
            if (playground.getChildren().contains(curApplyingOpUIElement.element)) {
                curApplyingOpUIElement.element.relocate(relocateX, relocateY);
            } else {
                curApplyingOpUIElement.element.setLayoutX(relocateX);
                curApplyingOpUIElement.element.setLayoutY(relocateY);
                playground.getChildren().add(curApplyingOpUIElement.element);
            }
            if (!this.curApplyingOpUIElement.addedToOperatorsStack) {
                this.appliedOperators.push(curApplyingOpUIElement);
                this.curApplyingOpUIElement.addedToOperatorsStack = true;
                System.out.println(curApplyingOpUIElement.operatorName
                        + " has been added to the operation stack");
            } else {
                System.out.println("This operator is already in the queue");
            }

            event.setDropCompleted(true);
            event.consume();
        }
        System.out.println("Drop detected: " + curApplyingOpUIElement.operatorName + "\n");
    }

    /**
     * Method which builds the UI elements
     * and add them to the side operators bar.
     * Moreover, this handles the UI dragDone event
     * related cloning.
     *
     * @param url            - URL.
     * @param resourceBundle - ResourceBundle.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OperatorUIElement.onDragDone = (element) -> {
            if (element == null) {
                this.uiElementPropertiesPane.setContent(null);
                this.informationScrollPane.setContent(null);
            } else {
                this.uiElementPropertiesPane.setContent(element.buildPropertiesFormUI());
                this.informationScrollPane.setContent(element.buildInformationUI());
            }
            this.curApplyingOpUIElement = null;
        };
        OperatorUIElement.onCloneCreated = (element) -> {
            this.curApplyingOpUIElement = element;
        };

        OperatorUIElement.propertiesPane = uiElementPropertiesPane;
        OperatorUIElement.informationPane = informationScrollPane;

        //ReadImage UI element.
        OperatorUIElement readImage = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ReadImage
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new ReadImgPropertiesForm((ReadImage) this.operator);
            }
        };
        readImage.operator = new ReadImage();
        readImage.operatorId = ReadImage.class.getCanonicalName();
        readImage.operatorName = "READ_IMAGE";
        readImage.elementStyleId = "readImage";
        readImage.buildElement();

        //WriteImage UI element.
        OperatorUIElement writeImage = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(WriteImage
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new WriteImgPropertiesForm((WriteImage) this.operator);
            }
        };
        writeImage.operator = new WriteImage();
        writeImage.operatorId = WriteImage.class.getCanonicalName();
        writeImage.operatorName = "WRITE_IMAGE";
        writeImage.elementStyleId = "writeImage";
        writeImage.buildElement();

        //RotateImage UI element.
        OperatorUIElement rotateImage = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(RotateImage
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new RotateImgPropertiesForm((RotateImage) this.operator);
            }
        };
        rotateImage.operator = new RotateImage();
        rotateImage.operatorId = RotateImage.class.getCanonicalName();
        rotateImage.operatorName = "ROTATE_IMAGE";
        rotateImage.elementStyleId = "rotateImage";
        rotateImage.buildElement();

        //ConvertGrayscale UI element.
        OperatorUIElement convertToGrayScaleImage = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ConvertToGrayscale
                        .Information.OPERATOR_INFO.toString());
            }
        };
        convertToGrayScaleImage.operator = new ConvertToGrayscale();
        convertToGrayScaleImage.operatorId = ConvertToGrayscale.class.getCanonicalName();
        convertToGrayScaleImage.operatorName = "GRAY_IMAGE";
        convertToGrayScaleImage.elementStyleId = "grayscaleImage";
        convertToGrayScaleImage.buildElement();

        //convertColoredImageToBinary UI element.
        OperatorUIElement convertColoredImageToBinary = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ColoredImageToBinary
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new ColoredToBinaryPropertiesForm((ColoredImageToBinary) this.operator);
            }
        };
        convertColoredImageToBinary.operator = new ColoredImageToBinary();
        convertColoredImageToBinary.operatorId = ColoredImageToBinary.class.getCanonicalName();
        convertColoredImageToBinary.operatorName = "COLOR-TO-BINARY";
        convertColoredImageToBinary.elementStyleId = "coloredToBinary";
        convertColoredImageToBinary.buildElement();

        //convertGrayImageToBinary UI element.
        OperatorUIElement convertGrayImageToBinary = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(GrayscaleToBinary
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new GrayscaleToBinaryPropertiesForm((GrayscaleToBinary) this.operator);
            }
        };
        convertGrayImageToBinary.operator = new GrayscaleToBinary();
        convertGrayImageToBinary.operatorId = GrayscaleToBinary.class.getCanonicalName();
        convertGrayImageToBinary.operatorName = "GRAY-TO-BINARY";
        convertGrayImageToBinary.elementStyleId = "grayToBinary";
        convertGrayImageToBinary.buildElement();

        //applyBlurEffect UI element.
        OperatorUIElement applyBlurEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyBlurEffect
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new SimpleBlurPropertiesFormUI((ApplyBlurEffect) this.operator);
            }
        };
        applyBlurEffect.operator = new ApplyBlurEffect();
        applyBlurEffect.operatorId = ApplyBlurEffect.class.getCanonicalName();
        applyBlurEffect.operatorName = "APPLY-BLUR";
        applyBlurEffect.elementStyleId = "applyBlur";
        applyBlurEffect.buildElement();

        //applyGaussianBlurEffect UI element.
        OperatorUIElement applyGaussianBlurEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyGaussianBlurEffect
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new GaussianBlurPropertiesFormUI((ApplyGaussianBlurEffect) this.operator);
            }
        };
        applyGaussianBlurEffect.operator = new ApplyGaussianBlurEffect();
        applyGaussianBlurEffect.operatorId = ApplyGaussianBlurEffect.class.getCanonicalName();
        applyGaussianBlurEffect.operatorName = "APPLY-GAUSSIAN-BLUR";
        applyGaussianBlurEffect.elementStyleId = "applyGaussianBlur";
        applyGaussianBlurEffect.buildElement();

        //applyMedianBlurEffect UI element.
        OperatorUIElement applyMedianBlurEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyMedianBlurEffect
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesFormUI buildPropertiesFormUI() {
                return new MedianBlurPropertiesFormUI((ApplyMedianBlurEffect) this.operator);
            }
        };
        applyMedianBlurEffect.operator = new ApplyMedianBlurEffect();
        applyMedianBlurEffect.operatorId = ApplyMedianBlurEffect.class.getCanonicalName();
        applyMedianBlurEffect.operatorName = "APPLY-MEDIAN-BLUR";
        applyMedianBlurEffect.elementStyleId = "applyMedianBlur";
        applyMedianBlurEffect.buildElement();

        // basicOperatorsContainer.
        basicOperatorsContainer.setSpacing(15d);
        basicOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        basicOperatorsContainer.setLayoutY(20d);
        basicOperatorsContainer.getChildren().addAll(
                // Populating basicOperatorsContainer.
                readImage.element,
                writeImage.element
        );
        geoTransformationOperatorsContainer.setSpacing(15d);
        geoTransformationOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        geoTransformationOperatorsContainer.setLayoutY(20d);
        geoTransformationOperatorsContainer.getChildren().addAll(
                // Populating geoTransformationOperatorsContainer.
                rotateImage.element
        );
        imageConversionsOperatorsContainer.setSpacing(15d);
        imageConversionsOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        imageConversionsOperatorsContainer.setLayoutY(20d);
        imageConversionsOperatorsContainer.getChildren().addAll(
                // Populating imageConversionsOperatorsContainer.
                convertToGrayScaleImage.element,
                convertColoredImageToBinary.element,
                convertGrayImageToBinary.element
        );
        blurringOperatorsContainer.setSpacing(15d);
        blurringOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        blurringOperatorsContainer.setLayoutY(20d);
        blurringOperatorsContainer.getChildren().addAll(
                // Populating blurringOperatorsContainer.
                applyBlurEffect.element,
                applyGaussianBlurEffect.element,
                applyMedianBlurEffect.element
        );

    }
}
