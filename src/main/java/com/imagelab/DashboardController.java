package com.imagelab;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.controllers.*;
import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.util.Constants;
import com.imagelab.util.Utilities;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.InitialPreviewPaneView;
import com.imagelab.view.ProcessedImageView;
import com.imagelab.view.forms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.opencv.core.Mat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import static com.imagelab.util.Constants.ANY_NODE;

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
     * Label which indicates the
     * playground area.
     */
    @FXML
    private Label playgroundAreaLabel;

    /**
     * playgroundOpContainer: : the HBox container where
     * users build the pipeline by
     * dragging and dropping operator ui elements.
     */
    @FXML
    private HBox playgroundOpContainer;

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
     * drawingOperatorsContainer contains,
     * DrawCircle,
     * DrawSquare,
     * Draw Polygone
     */
    @FXML
    private VBox drawingOperatorsContainer;
    
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
     * filteringOperatorsContainer contains,
     * boxFilter.
     */
    @FXML
    private VBox filteringOperatorsContainer;

    /**
     * thresholdingOperatorsContainer,
     * simpleThresholding.
     */
    @FXML
    private VBox thresholdingOperatorsContainer;
    /**
     * sobel Opeartor
     * scharr Opeartor
     */
    @FXML
    private VBox sobelDOperatorsContainer;
    /**
     * laplacian transformation
     * distance transformation
     */
    @FXML
    private VBox transformationOperatorsContainer;
    /**
     * Canny Edge Detection
     * Hough Line Transform
     * Histogram Equalization
     */
    @FXML
    private VBox miscellaneousOperatorsContainer;
    /**
     * Find and Draw Contours
     * Draw Bounding Boxes for contours
     */
    @FXML
    private VBox contourOperationContainer;
    /**
     * Histogram Calculation
     */
    @FXML
    private VBox histogramOperationContainer;
    
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
     * information related to the operator dragged
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
        if (!appliedOperators.empty()) {
            for (OperatorUIElement op : appliedOperators) {
                image = op.operator.compute(image);
            }
            //Displaying the processed image in the preview pane
            WritableImage writableImage;
            writableImage = Utilities.loadImage(image, ".jpg");
            ProcessedImageView processedImage;
            processedImage = new ProcessedImageView(writableImage);
            previewPane.getChildren().addAll(processedImage);
        } else {
            Utilities.showAlert(
                    "Invalid Operation",
                    "Empty pipeline detected",
                    "Cannot execute an empty"
                            + " pipeline",
                    Alert.AlertType.WARNING
            );
            System.err.println("ERROR: empty pipeline, execution failed.");
        }
    }

    /**
     * Method which generates a report based
     * on the pipeline user has been developed by
     * dragging and dropping OpenCV operators
     * to the playground area.
     *
     * @param event - Mouse click even.
     * @throws IOException - if the event was not captured.
     */
    @FXML
    public void onExportClicked(ActionEvent event) throws IOException {
        if (!appliedOperators.empty()) {
            Utilities.generate(appliedOperators);
            Utilities.showAlert(
                    "Report Generation",
                    "Report generation successful.",
                    "Report saved to\n"
                            + "resources/com/imagelab/reports/ImageLabReport.txt",
                    Alert.AlertType.INFORMATION
            );
        } else {
            Utilities.showAlert(
                    "Invalid Operation",
                    "Empty pipeline detected",
                    "Cannot export an empty"
                            + " pipeline",
                    Alert.AlertType.WARNING
            );
            System.err.println("ERROR: empty pipeline, report"
                    + " generation failed,");
        }
    }

    /**
     * Method which reset the playground ones user
     * pressed on the refresh.
     *
     * @param event - onClick Mouse Event.
     * @throws IOException - if the event was not captured.
     */
    @FXML
    public void onResetClicked(ActionEvent event) throws IOException {
        if (!appliedOperators.empty()) {
            String reply = Utilities.showAlert(
                    "Resetting Dashboard",
                    "Do you want to reset dashboard?",
                    "please confirm your action",
                    Alert.AlertType.CONFIRMATION
            );
            if (reply.equals("OK")) {
                // Removing all the elements from appliedOperators.
                this.appliedOperators.clear();
                // Removing rendered output images.
                this.previewPane.getChildren().clear();
                // Removing elements from the operators container.
                this.playgroundOpContainer.getChildren().clear();
                // Clearing the content of properties pane
                this.uiElementPropertiesPane.setContent(null);
                // Setting the dashboard to initial state.
                setDashboardToInitialState();
                System.out.println("Pipeline and dashboard"
                        + " has been cleared.");
            } else if (reply.equals("CANCEL")) {
                System.out.println("Aborting reset");
            } else {
                System.err.println("ERROR: not identified"
                        + " reset type executed.");
            }
        } else {
            Utilities.showAlert(
                    "Invalid Operation",
                    "Empty pipeline detected",
                    "Cannot reset an empty"
                            + " pipeline",
                    Alert.AlertType.WARNING
            );
            System.err.println("ERROR: empty pipeline,"
                    + " nothing to be cleared.");
        }
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
        // Hiding playground area indicator.
        playgroundAreaLabel.setVisible(false);
        System.out.println(curApplyingOpUIElement.operatorName);
        /*
         * if this was the initial move then no need to validate,
         *  just move on to the next step.
         */
        if (appliedOperators.size() == 0
                && curApplyingOpUIElement.operator instanceof ReadImage) {
            proceedLocateOperator(event);
        } else {
            if (appliedOperators.size() == 0) {
                Utilities.showAlert(
                        "Invalid Operation",
                        "Invalid initial operator",
                        "This operator is not valid "
                                + "as an initial operator\n"
                                + "Try ReadImage operator.",
                        Alert.AlertType.ERROR
                );
                setDashboardToInitialState();
                System.err.println("ERROR: Invalid initial operator"
                        + curApplyingOpUIElement.operatorName);
                return;
            }
            OpenCVOperator operator = appliedOperators.peek().operator;
            boolean isValid;
            isValid = curApplyingOpUIElement.operator.validate(operator);
            if (!isValid) {
                Utilities.showAlert(
                        "Invalid Operation",
                        "Operator mismatching error",
                        "Cannot apply this operator. "
                                + "Please try another combination.",
                        Alert.AlertType.ERROR
                );
                System.err.println("ERROR: Cannot apply this operator"
                        + curApplyingOpUIElement.operatorName);
                return;
            }
            proceedLocateOperator(event);
        }
    }

    /**
     * This method handles the the logic related to locating
     * a UI element automatically one after the other.
     *
     * @param event - dragEvent
     */
    private void proceedLocateOperator(DragEvent event) {

        assert curApplyingOpUIElement != null : "currentlyApplyingOperator"
                + " cannot be null here...";
        Dragboard dragboard = event.getDragboard();

        if (dragboard.hasContent(ANY_NODE)) {
            if (playgroundOpContainer.getChildren().contains(curApplyingOpUIElement.element)) {
                System.out.println(curApplyingOpUIElement.operatorName
                        + " Operator has been placed already");
            } else {
                playgroundOpContainer.getChildren().add(curApplyingOpUIElement.element);
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
     * and add them to the side operator bar.
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

        // Container Controllers
       
        // basicOperatorsContainer.
        basicOperatorsContainer.setSpacing(15d);
        basicOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        basicOperatorsContainer.setLayoutY(20d);
        basicOperatorsContainer.getChildren().addAll(
        		// Populating basicOperatorsContainer.
        		BasicOperatorController.readImageElement().element,
                BasicOperatorController.writeImageElement().element
        );
        geoTransformationOperatorsContainer.setSpacing(15d);
        geoTransformationOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        geoTransformationOperatorsContainer.setLayoutY(20d);
        geoTransformationOperatorsContainer.getChildren().addAll(
        		// Populating geoTransformationOperatorsContainer.
        		GeoTransformationOperatorController.reflectionTransformationElement().element,
                GeoTransformationOperatorController.rotateImageElement().element,
                GeoTransformationOperatorController.colorMapsElement().element,
                GeoTransformationOperatorController.affineTransformationElement().element,
                GeoTransformationOperatorController.scaleImageElement().element
                
        );
        drawingOperatorsContainer.setSpacing(15d);
        drawingOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        drawingOperatorsContainer.setLayoutY(20d);
        drawingOperatorsContainer.getChildren().addAll(
        		//Populating drawingOperators
        		DrawingOperatorController.drawLineEffectElement().element,
        		DrawingOperatorController.drawArrowedLineEffectElement().element,
        		DrawingOperatorController.drawCircleEffectElement().element,
        		DrawingOperatorController.drawEllipseEffectElement().element,
        		DrawingOperatorController.drawRectangleEffectElement().element,
        		DrawingOperatorController.drawTextEffectElement().element
        		
        );
        imageConversionsOperatorsContainer.setSpacing(15d);
        imageConversionsOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        imageConversionsOperatorsContainer.setLayoutY(20d);
        imageConversionsOperatorsContainer.getChildren().addAll(
        		 // Populating imageConversionsOperatorsContainer.
                ImageConversionOperatorController.convertToGrayScaleImageElement().element,
                ImageConversionOperatorController.convertColoredImageToBinaryElement().element,
                ImageConversionOperatorController.convertGrayImageToBinaryElement().element
        );
        blurringOperatorsContainer.setSpacing(15d);
        blurringOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        blurringOperatorsContainer.setLayoutY(20d);
        blurringOperatorsContainer.getChildren().addAll(
        		// Populating blurringOperatorsContainer.
                BlurringOperatorController.applyBlurEffectElement().element,
                BlurringOperatorController.applyGaussianEffectElement().element,
                BlurringOperatorController.applyMedainBlurEffectElement().element
        );

        filteringOperatorsContainer.setSpacing(15d);
        filteringOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        filteringOperatorsContainer.setLayoutY(20d);
        filteringOperatorsContainer.getChildren().addAll(
        		// Populating filteringOperatorsContainer.
                FilterOperatorController.boxFilerEffectElement().element,
                FilterOperatorController.imageDilationEffectElement().element,
                FilterOperatorController.erosionFilterEffectElement().element,
                FilterOperatorController.bilateralFilterEffectElement().element,
                FilterOperatorController.filter2DOperatorEffectElement().element,
                FilterOperatorController.sqrBoxFilterEffectElement().element,
                FilterOperatorController.pyramidsUpFilterEffectElement().element,
                FilterOperatorController.pyramidsDownFilterEffectElement().element,
                FilterOperatorController.morphologicalOperatorEffectElement().element
        );

        thresholdingOperatorsContainer.setSpacing(15d);
        thresholdingOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        thresholdingOperatorsContainer.setLayoutY(20d);
        thresholdingOperatorsContainer.getChildren().addAll(
        		// Populating thresholdingOperatorsContainer.
        		ThresholdingOperatorController.applyBorderThresholdEffectElement().element,
                ThresholdingOperatorController.applyAdaptiveThresholdEffectElement().element,
                ThresholdingOperatorController.applySimpleThresholdEffectElement().element
        );
        sobelDOperatorsContainer.setSpacing(15d);
        sobelDOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        sobelDOperatorsContainer.setLayoutY(20d);
        sobelDOperatorsContainer.getChildren().addAll(
        	    // Populating sobelDerivationContainer
        		SobelDerivationController.sobelOpeartorElement().element,
        		SobelDerivationController.scharrOpeartorElement().element
        );
        transformationOperatorsContainer.setSpacing(15d);
        transformationOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        transformationOperatorsContainer.setLayoutY(20d);
        transformationOperatorsContainer.getChildren().addAll(
        	    // Populating sobelDerivationContainer
        		TransformationOperatorController.laplacianTransformationElement().element,
        		TransformationOperatorController.distanceTransformationElement().element
        );
        miscellaneousOperatorsContainer.setSpacing(15d);
        miscellaneousOperatorsContainer.setAlignment(Pos.TOP_CENTER);
        miscellaneousOperatorsContainer.setLayoutY(20d);
        miscellaneousOperatorsContainer.getChildren().addAll(
        	    // Populating sobelDerivationContainer
        		MiscellaneousOperatorController.cannyEdgeDetectionElement().element,
        		MiscellaneousOperatorController.houghLineTransformElement().element,
        		MiscellaneousOperatorController.histogramEqualizationElement().element
        );
        contourOperationContainer.setSpacing(15d);
        contourOperationContainer.setAlignment(Pos.TOP_CENTER);
        contourOperationContainer.setLayoutY(20d);
        contourOperationContainer.getChildren().addAll(
        	   // Populating contourOperationsContainer
        	   ImageContoursController.findContoursElement().element,
        	   ImageContoursController.boundingBoxesForContoursElement().element,
        	   ImageContoursController.imageMomentsElement().element,
        	   ImageContoursController.convexHullElement().element
        );
        histogramOperationContainer.setSpacing(15d);
        histogramOperationContainer.setAlignment(Pos.TOP_CENTER);
        histogramOperationContainer.setLayoutY(20d);
        histogramOperationContainer.getChildren().addAll(
        	    // Populating Histogram operators
        		HistogramController.histogramCalculationElement().element,
        		HistogramController.templateMatchingElement().element
        );
        setDashboardToInitialState();
    }

    /**
     * Method which setup the initial dashboard
     * when the dashboard UI renders.
     */
    private void setDashboardToInitialState() {
        // To set spacing between stacked operators.
        playgroundOpContainer.setSpacing(0);
        /*
         * Setup the initial information pane
         * and information to be populated to
         * introduce the dashboard to the user.
         */
        InformationContainerView initialInformationContainerView;
        initialInformationContainerView = new InformationContainerView(
                Constants.HOW_TO_USE_INFO);
        this.informationScrollPane.setContent(initialInformationContainerView);
        /*
         * Setup initial properties pane with
         * a area indication label.
         */
        InitialPropertiesFrom initialPropertiesFrom;
        initialPropertiesFrom = new InitialPropertiesFrom();
        this.uiElementPropertiesPane.setContent(initialPropertiesFrom);
        /*
         * Setup initial preview pane with
         * a area indication label.
         */
        InitialPreviewPaneView initialPreviewPaneView;
        initialPreviewPaneView = new InitialPreviewPaneView();
        this.previewPane.getChildren().addAll(initialPreviewPaneView);
        /*
         * Enable playground area indicator Label.
         */
        playgroundAreaLabel.setVisible(true);
    }
}
