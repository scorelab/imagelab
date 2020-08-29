package com.imagelab.views.forms;

import com.imagelab.operators.geotransformation.RotateImage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Rotate image properties form view.
 */
public class RotateImgPropertiesForm extends AbstractPropertiesFormUI {
    /**
     * Builds the RotateImgPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public RotateImgPropertiesForm(RotateImage operator) {
        setPrefSize(224.0, 523.0);
        //Rotation Properties Title.
        PropertiesFormTitleContainer rotationTitleContainer;
        rotationTitleContainer = new PropertiesFormTitleContainer("Rotate Image Properties");
        //Rotation Angle.
        VBox rotationAngleContainer = new VBox();
        rotationAngleContainer.setPrefWidth(205.0);
        rotationAngleContainer.setSpacing(10);

        Label lblRotationAngle = new Label("Rotation Angle");

        TextField angleTextField = new TextField(String.valueOf(0.0));
        angleTextField.setPrefSize(205.0, 27.0);
        //Listener to capture angle value text change.
        angleTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setAngle(Double.parseDouble(newValue));
        });
        rotationAngleContainer.getChildren().addAll(lblRotationAngle, angleTextField);

        //Rotation Scale.
        VBox rotationScaleContainer = new VBox();
        rotationScaleContainer.setPrefWidth(205.0);
        rotationScaleContainer.setSpacing(10);

        Label lblRotationScale = new Label("Rotation Scale");

        TextField scaleTextField = new TextField(String.valueOf(0.0));
        scaleTextField.setPrefSize(205, 27);
        //Listener to capture scale value change.
        scaleTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setScale(Double.parseDouble(newValue));
        });
        rotationScaleContainer.getChildren().addAll(lblRotationScale, scaleTextField);

        VBox rotationPropertiesContainer = new VBox();
        rotationPropertiesContainer.setPrefSize(205, 47);
        rotationPropertiesContainer.setSpacing(20);
        rotationPropertiesContainer.setLayoutX(14);
        rotationPropertiesContainer.setLayoutY(14);
        rotationPropertiesContainer.getChildren().addAll(
                rotationTitleContainer,
                rotationAngleContainer,
                rotationScaleContainer
        );
        getChildren().addAll(rotationPropertiesContainer);
    }
}
