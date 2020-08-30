package com.imagelab.view.forms;

import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Color to binary image conversion operation related
 * UI properties form.
 */
public class ColoredToBinaryPropertiesForm extends AbstractPropertiesFormUI {
    /**
     * Builds the ColoredToBinaryPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public ColoredToBinaryPropertiesForm(ColoredImageToBinary operator) {
        setPrefSize(224.0, 523.0);
        //Colored to binary image conversion Properties Title.
        PropertiesFormTitleContainer clrToBinaryTitleContainer;
        clrToBinaryTitleContainer = new PropertiesFormTitleContainer("Image Conversion Properties");
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

        //Thresh type container: dropbox.
        VBox threshTypeContainer = new VBox();
        threshTypeContainer.setPrefWidth(205.0);
        threshTypeContainer.setSpacing(10);
        Label lblThreshType = new Label("Thresh Type");
        ComboBox<String> threshTypeComboBox = new ComboBox<String>();
        threshTypeComboBox.setPrefSize(205, 27);
        threshTypeComboBox.getItems().addAll(
                "THRESH_BINARY",
                "THRESH_BINARY_INV"
        );
        threshTypeComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                operator.setThresholdType(newValue);
            }
        });
        threshTypeContainer.getChildren().addAll(lblThreshType, threshTypeComboBox);

        VBox clrToBinaryImagePropertiesContainer = new VBox();
        clrToBinaryImagePropertiesContainer.setPrefSize(205, 47);
        clrToBinaryImagePropertiesContainer.setSpacing(20);
        clrToBinaryImagePropertiesContainer.setLayoutX(14);
        clrToBinaryImagePropertiesContainer.setLayoutY(14);
        clrToBinaryImagePropertiesContainer.getChildren().addAll(
                clrToBinaryTitleContainer,
                threshValueContainer,
                maxValContainer,
                threshTypeContainer
        );
        getChildren().addAll(clrToBinaryImagePropertiesContainer);
    }
}
