package com.imagelab.view.forms;

import com.imagelab.operator.thresholding.ApplyAdaptiveThreshold;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Applying adaptive threshold operation related
 * UI properties form.
 */
public class AdaptiveThresholdPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds the AdaptiveThresholdPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public AdaptiveThresholdPropertiesForm(ApplyAdaptiveThreshold operator) {
        setPrefSize(224.0, 523.0);
        //Simple blur tittle container.
        PropertiesFormTitleContainer adaptiveThresholdTitleContainer;
        adaptiveThresholdTitleContainer = new PropertiesFormTitleContainer("Threshold Properties");

        //Value - max.
        VBox maxValueContainer = new VBox();
        maxValueContainer.setPrefWidth(205.0);
        maxValueContainer.setSpacing(10);
        Label lblMaxVal = new Label("Max Value");
        TextField maxValTextField = new TextField(String.valueOf(125.0));
        maxValTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        maxValTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setMaxValue(Double.parseDouble(newValue));
        });
        maxValueContainer.getChildren().addAll(lblMaxVal, maxValTextField);

        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox adaptiveThresholdPropertiesContainer = new VBox();
        adaptiveThresholdPropertiesContainer.setPrefSize(205, 47);
        adaptiveThresholdPropertiesContainer.setSpacing(20);
        adaptiveThresholdPropertiesContainer.setLayoutX(14);
        adaptiveThresholdPropertiesContainer.setLayoutY(14);
        adaptiveThresholdPropertiesContainer.getChildren().addAll(
                adaptiveThresholdTitleContainer,
                maxValueContainer,
                spaceContainer
        );
        getChildren().addAll(adaptiveThresholdPropertiesContainer);
    }
}
