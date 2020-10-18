package com.imagelab.view.forms;

import com.imagelab.operator.thresholding.ApplyBorder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Applying borders related
 * UI properties form.
 */
public class ApplyBordersPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds the ApplyBordersPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public ApplyBordersPropertiesForm(ApplyBorder operator) {
        setPrefSize(224.0, 523.0);
        //Simple blur tittle container.
        PropertiesFormTitleContainer applyBordersTitleContainer;
        applyBordersTitleContainer = new PropertiesFormTitleContainer("Border Properties");

        //Size - border top.
        VBox topBorderValueContainer = new VBox();
        topBorderValueContainer.setPrefWidth(205.0);
        topBorderValueContainer.setSpacing(10);
        Label lblTopBorderVal = new Label("Top Border");
        TextField topBorderTextField = new TextField(String.valueOf(20));
        topBorderTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        topBorderTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setBorderTop(Integer.parseInt(newValue));
        });
        topBorderValueContainer.getChildren().addAll(lblTopBorderVal, topBorderTextField);

        //Size - border bottom.
        VBox bottomBorderValueContainer = new VBox();
        bottomBorderValueContainer.setPrefWidth(205.0);
        bottomBorderValueContainer.setSpacing(10);
        Label lblBottomBorderVal = new Label("Top Border");
        TextField bottomBorderTextField = new TextField(String.valueOf(20));
        bottomBorderTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        bottomBorderTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setBorderTop(Integer.parseInt(newValue));
        });
        bottomBorderValueContainer.getChildren().addAll(lblBottomBorderVal, bottomBorderTextField);

        //Size - border left.
        VBox leftBorderValueContainer = new VBox();
        leftBorderValueContainer.setPrefWidth(205.0);
        leftBorderValueContainer.setSpacing(10);
        Label lblLeftBorderVal = new Label("Top Border");
        TextField leftBorderTextField = new TextField(String.valueOf(20));
        leftBorderTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        leftBorderTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setBorderTop(Integer.parseInt(newValue));
        });
        leftBorderValueContainer.getChildren().addAll(lblLeftBorderVal, leftBorderTextField);

        //Size - border right.
        VBox rightBorderValueContainer = new VBox();
        rightBorderValueContainer.setPrefWidth(205.0);
        rightBorderValueContainer.setSpacing(10);
        Label lblRightBorderVal = new Label("Top Border");
        TextField rightBorderTextField = new TextField(String.valueOf(20));
        rightBorderTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        rightBorderTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setBorderTop(Integer.parseInt(newValue));
        });
        rightBorderValueContainer.getChildren().addAll(lblRightBorderVal, rightBorderTextField);

        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox applyBordersPropertiesContainer = new VBox();
        applyBordersPropertiesContainer.setPrefSize(205, 47);
        applyBordersPropertiesContainer.setSpacing(20);
        applyBordersPropertiesContainer.setLayoutX(14);
        applyBordersPropertiesContainer.setLayoutY(14);
        applyBordersPropertiesContainer.getChildren().addAll(
                applyBordersTitleContainer,
                topBorderValueContainer,
                bottomBorderValueContainer,
                leftBorderValueContainer,
                rightBorderValueContainer,
                spaceContainer
        );
        getChildren().addAll(applyBordersPropertiesContainer);
    }
}
