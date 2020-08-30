package com.imagelab.view.forms;

import com.imagelab.operator.imageconversion.GrayscaleToBinary;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Converting grayscale image to binary
 * operation related UI properties form.
 */
public class GrayscaleToBinaryPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds the GrayscaleToBinaryPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public GrayscaleToBinaryPropertiesForm(GrayscaleToBinary operator) {
        setPrefSize(224.0, 523.0);
        //Colored to binary image conversion Properties Title.
        PropertiesFormTitleContainer grayToBinaryTitleContainer;
        grayToBinaryTitleContainer = new PropertiesFormTitleContainer(""
                + "Image Conversion Properties");
        //Threshold Value container.
        VBox threshValueContainer = new VBox();
        threshValueContainer.setPrefWidth(0.0);
        threshValueContainer.setSpacing(10);

        Label lblThreshVal = new Label("Set Threshold Value");

        TextField threshValTextField = new TextField(String.valueOf(200.0));
        threshValTextField.setPrefSize(205.0, 27.0);
        //Listener to capture thresh value text change.
        threshValTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setThresholdValue(Double.parseDouble(newValue));
        });
        threshValueContainer.getChildren().addAll(lblThreshVal, threshValTextField);

        //Max value container.
        VBox maxValContainer = new VBox();
        maxValContainer.setPrefWidth(205.0);
        maxValContainer.setSpacing(10);

        Label lblMaxVal = new Label("Max Value");

        TextField maxValTextField = new TextField(String.valueOf(500.0));
        maxValTextField.setPrefSize(205, 27);
        //Listener to capture scale value change.
        maxValTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setMaxValue(Double.parseDouble(newValue));
        });
        maxValContainer.getChildren().addAll(lblMaxVal, maxValTextField);

        VBox grayToBinaryImagePropertiesContainer = new VBox();
        grayToBinaryImagePropertiesContainer.setPrefSize(205, 47);
        grayToBinaryImagePropertiesContainer.setSpacing(20);
        grayToBinaryImagePropertiesContainer.setLayoutX(14);
        grayToBinaryImagePropertiesContainer.setLayoutY(14);
        grayToBinaryImagePropertiesContainer.getChildren().addAll(
                grayToBinaryTitleContainer,
                threshValueContainer,
                maxValContainer
        );
        getChildren().addAll(grayToBinaryImagePropertiesContainer);
    }
}
