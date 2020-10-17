package com.imagelab.view.forms;

import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Applying blur effects operation related
 * UI properties form.
 */
public class SimpleBlurPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds the SimpleBlurPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public SimpleBlurPropertiesForm(ApplyBlurEffect operator) {
        setPrefSize(224.0, 523.0);
        //Simple blur tittle container.
        PropertiesFormTitleContainer simpleBlurTitleContainer;
        simpleBlurTitleContainer = new PropertiesFormTitleContainer("Simple Blur Properties");

        //Size - width.
        VBox widthSizeContainer = new VBox();
        widthSizeContainer.setPrefWidth(205.0);
        widthSizeContainer.setSpacing(10);
        Label lblWidthSize = new Label("Size: width");
        TextField widthSizeTextField = new TextField(String.valueOf(45.0));
        widthSizeTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        widthSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setWidthSize(Double.parseDouble(newValue));
        });
        widthSizeContainer.getChildren().addAll(lblWidthSize, widthSizeTextField);

        //Size - height.
        VBox heightSizeContainer = new VBox();
        heightSizeContainer.setPrefWidth(205.0);
        heightSizeContainer.setSpacing(10);
        Label lblHeightSize = new Label("Size height");
        TextField heightSizeTextField = new TextField(String.valueOf(45.0));
        heightSizeTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        heightSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setHeightSize(Double.parseDouble(newValue));
        });
        heightSizeContainer.getChildren().addAll(lblHeightSize, heightSizeTextField);

        //Point - x.
        VBox xPointContainer = new VBox();
        xPointContainer.setPrefWidth(205.0);
        xPointContainer.setSpacing(10);
        Label lblXPoint = new Label("Point: X");
        TextField xPointTextField = new TextField(String.valueOf(20.0));
        xPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        xPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setPointX(Double.parseDouble(newValue));
        });
        xPointContainer.getChildren().addAll(lblXPoint, xPointTextField);

        //Point - y.
        VBox yPointContainer = new VBox();
        yPointContainer.setPrefWidth(205.0);
        yPointContainer.setSpacing(10);
        Label lblYPoint = new Label("Point: Y");
        TextField yPointTextField = new TextField(String.valueOf(30.0));
        yPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        yPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setPointY(Double.parseDouble(newValue));
        });
        yPointContainer.getChildren().addAll(lblYPoint, yPointTextField);

        VBox simpleBlurPropertiesContainer = new VBox();
        simpleBlurPropertiesContainer.setPrefSize(205, 47);
        simpleBlurPropertiesContainer.setSpacing(20);
        simpleBlurPropertiesContainer.setLayoutX(14);
        simpleBlurPropertiesContainer.setLayoutY(14);
        simpleBlurPropertiesContainer.getChildren().addAll(
                simpleBlurTitleContainer,
                widthSizeContainer,
                heightSizeContainer,
                xPointContainer,
                yPointContainer
        );
        getChildren().addAll(simpleBlurPropertiesContainer);
    }
}

