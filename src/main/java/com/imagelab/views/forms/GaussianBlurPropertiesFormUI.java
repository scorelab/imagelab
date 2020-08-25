package com.imagelab.views.forms;

import com.imagelab.operators.imagebluring.ApplyGaussianBlurEffect;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GaussianBlurPropertiesFormUI extends AbstractPropertiesFormUI {
    public GaussianBlurPropertiesFormUI(ApplyGaussianBlurEffect operator) {
        setPrefSize(224.0, 523.0);
        //Simple blur tittle container.
        PropertiesFormTitleContainer simpleBlurTitleContainer = new PropertiesFormTitleContainer("Gaussian Blur Properties");

        //Size - width.
        VBox widthSizeContainer = new VBox();
        widthSizeContainer.setPrefWidth(205.0);
        widthSizeContainer.setSpacing(10);
        Label lblWidthSize = new Label("Size: width");
        TextField widthSizeTextField = new TextField(String.valueOf(45.0));
        widthSizeTextField.setPrefSize(205.0, 27.0);
        Label lblErrWidth = new Label("Error");
        lblErrWidth.setTextFill(Color.web("#f20028"));
        lblErrWidth.setVisible(false);
        //Listener to capture text change.
        widthSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            double newVal;
            if ("".equals(newValue)) {
                newVal = 0.0;
                lblErrWidth.setVisible(true);
                lblErrWidth.setText("Enter an odd value");
            } else {
                newVal = Double.parseDouble(newValue);
                lblErrWidth.setVisible(false);
                if (newVal % 2 == 1) {
                    operator.setWidthSize(newVal);
                } else {
                    lblErrWidth.setVisible(true);
                    lblErrWidth.setText("Enter an odd value");
                }
            }
        });
        widthSizeContainer.getChildren().addAll(lblWidthSize, widthSizeTextField, lblErrWidth);

        //Size - height.
        VBox heightSizeContainer = new VBox();
        heightSizeContainer.setPrefWidth(205.0);
        heightSizeContainer.setSpacing(10);
        Label lblHeightSize = new Label("Size height");
        TextField heightSizeTextField = new TextField(String.valueOf(45.0));
        heightSizeTextField.setPrefSize(205.0, 27.0);
        Label lblErrHeight = new Label("Error");
        lblErrHeight.setTextFill(Color.web("#f20028"));
        lblErrHeight.setVisible(false);
        //Listener to capture text change.
        heightSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            double newVal;
            if ("".equals(newValue)) {
                newVal = 0.0;
                lblErrHeight.setVisible(true);
                lblErrHeight.setText("Enter an odd value");
            } else {
                newVal = Double.parseDouble(newValue);
                lblErrHeight.setVisible(false);
                if (newVal % 2 == 1) {
                    operator.setHeightSize(newVal);
                } else {
                    lblErrHeight.setVisible(true);
                    lblErrHeight.setText("Enter an odd value");
                }
            }
        });
        widthSizeContainer.getChildren().addAll(lblHeightSize, heightSizeTextField, lblErrHeight);

        VBox simpleBlurPropertiesContainer = new VBox();
        simpleBlurPropertiesContainer.setPrefSize(205, 47);
        simpleBlurPropertiesContainer.setSpacing(20);
        simpleBlurPropertiesContainer.setLayoutX(14);
        simpleBlurPropertiesContainer.setLayoutY(14);
        simpleBlurPropertiesContainer.getChildren().addAll(
                simpleBlurTitleContainer,
                widthSizeContainer,
                heightSizeContainer
        );
        getChildren().addAll(simpleBlurPropertiesContainer);
    }
}
