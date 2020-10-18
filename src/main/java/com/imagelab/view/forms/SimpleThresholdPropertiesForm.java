package com.imagelab.view.forms;

import com.imagelab.operator.thresholding.ApplySimpleThreshold;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Applying simple threshold operation related
 * UI properties form.
 */
public class SimpleThresholdPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds the SimpleThresholdPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public SimpleThresholdPropertiesForm(ApplySimpleThreshold operator) {
        setPrefSize(224.0, 523.0);
        //Simple blur tittle container.
        PropertiesFormTitleContainer simpleThresholdTitleContainer;
        simpleThresholdTitleContainer = new PropertiesFormTitleContainer("Threshold Properties");

        //Value - threshold.
        VBox thresholdValueContainer = new VBox();
        thresholdValueContainer.setPrefWidth(205.0);
        thresholdValueContainer.setSpacing(10);
        Label lblThresholdVal = new Label("Threshold Value");
        TextField thresholdValTextField = new TextField(String.valueOf(50.0));
        thresholdValTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        thresholdValTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setThresholdValue(Double.parseDouble(newValue));
        });
        thresholdValueContainer.getChildren().addAll(lblThresholdVal, thresholdValTextField);

        //Value - max.
        VBox maxValueContainer = new VBox();
        maxValueContainer.setPrefWidth(205.0);
        maxValueContainer.setSpacing(10);
        Label lblMaxVal = new Label("Max Value");
        TextField maxValTextField = new TextField(String.valueOf(255.0));
        maxValTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        maxValTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setThresholdValue(Double.parseDouble(newValue));
        });
        maxValueContainer.getChildren().addAll(lblMaxVal, maxValTextField);

        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox simpleThresholdPropertiesContainer = new VBox();
        simpleThresholdPropertiesContainer.setPrefSize(205, 47);
        simpleThresholdPropertiesContainer.setSpacing(20);
        simpleThresholdPropertiesContainer.setLayoutX(14);
        simpleThresholdPropertiesContainer.setLayoutY(14);
        simpleThresholdPropertiesContainer.getChildren().addAll(
                simpleThresholdTitleContainer,
                thresholdValueContainer,
                maxValueContainer,
                spaceContainer
        );
        getChildren().addAll(simpleThresholdPropertiesContainer);
    }
}
