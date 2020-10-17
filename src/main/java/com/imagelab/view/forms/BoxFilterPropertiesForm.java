package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyBoxFilter;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Applying box filter operation related
 * UI properties form.
 */
public class BoxFilterPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds BoxFilterPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public BoxFilterPropertiesForm(ApplyBoxFilter operator) {
        //Box Filter tittle container.
        PropertiesFormTitleContainer boxFilterTitleContainer;
        boxFilterTitleContainer = new PropertiesFormTitleContainer("Box Filter Properties");

        //Depth
        VBox depthSizeContainer = new VBox();
        depthSizeContainer.setPrefWidth(205.0);
        depthSizeContainer.setSpacing(10);
        Label lblDepthSize = new Label("Size: depth");
        TextField depthSizeTextField = new TextField(String.valueOf(50));
        depthSizeTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        depthSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setWidthSize(Double.parseDouble(newValue));
        });
        depthSizeContainer.getChildren().addAll(lblDepthSize, depthSizeTextField);

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
        TextField xPointTextField = new TextField(String.valueOf(-1));
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
        TextField yPointTextField = new TextField(String.valueOf(-1));
        yPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        yPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setPointY(Double.parseDouble(newValue));
        });
        yPointContainer.getChildren().addAll(lblYPoint, yPointTextField);

        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox boxFilterPropertiesContainer = new VBox();
        boxFilterPropertiesContainer.setPrefSize(205, 47);
        boxFilterPropertiesContainer.setSpacing(20);
        boxFilterPropertiesContainer.setLayoutX(14);
        boxFilterPropertiesContainer.setLayoutY(14);
        boxFilterPropertiesContainer.getChildren().addAll(
                boxFilterTitleContainer,
                depthSizeContainer,
                widthSizeContainer,
                heightSizeContainer,
                xPointContainer,
                yPointContainer,
                spaceContainer
        );
        getChildren().addAll(boxFilterPropertiesContainer);
    }
}
