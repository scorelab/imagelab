package com.imagelab.views.forms;

import com.imagelab.operators.imagebluring.ApplyMedianBlurEffect;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Applying median blur effects operation related
 * UI properties form.
 */
public class MedianBlurPropertiesFormUI extends AbstractPropertiesFormUI {
    public MedianBlurPropertiesFormUI(ApplyMedianBlurEffect operator) {
        setPrefSize(224.0, 523.0);
        //Simple blur tittle container.
        PropertiesFormTitleContainer medianBlurTitleContainer = new PropertiesFormTitleContainer("Median Blur Properties");

        //Size - width.
        VBox kernelSizeContainer = new VBox();
        kernelSizeContainer.setPrefWidth(205.0);
        kernelSizeContainer.setSpacing(10);
        Label lblKernelSize = new Label("Kernel Size");
        TextField kernelSizeTextField = new TextField(String.valueOf(15));
        kernelSizeTextField.setPrefSize(205.0, 27.0);
        Label lblErrKernelSize = new Label("Error");
        lblErrKernelSize.setTextFill(Color.web("#f20028"));
        lblErrKernelSize.setVisible(false);
        //Listener to capture text change.
        kernelSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            int newVal;
            if ("".equals(newValue)) {
                newVal = 0;
                lblErrKernelSize.setVisible(true);
                lblErrKernelSize.setText("Enter an odd value");
            } else {
                newVal = Integer.parseInt(newValue);
                lblErrKernelSize.setVisible(false);
                if (newVal % 2 == 1) {
                    operator.setKernelSize(newVal);
                } else {
                    lblErrKernelSize.setVisible(true);
                    lblErrKernelSize.setText("Enter an odd value");
                }
            }
        });
        kernelSizeContainer.getChildren().addAll(lblKernelSize, kernelSizeTextField, lblErrKernelSize);

        VBox gaussianBlurPropertiesContainer = new VBox();
        gaussianBlurPropertiesContainer.setPrefSize(205, 47);
        gaussianBlurPropertiesContainer.setSpacing(20);
        gaussianBlurPropertiesContainer.setLayoutX(14);
        gaussianBlurPropertiesContainer.setLayoutY(14);
        gaussianBlurPropertiesContainer.getChildren().addAll(
                medianBlurTitleContainer,
                kernelSizeContainer
        );
        getChildren().addAll(gaussianBlurPropertiesContainer);
    }
}
