package com.imagelab.view.forms;

import com.imagelab.operator.geotransformation.ScaleImage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ImageScalePropertiesForm extends AbstractPropertiesForm {
	public ImageScalePropertiesForm(ScaleImage operator) {
		//Box Filter title container.
        PropertiesFormTitleContainer imageScaleTitleContainer;
        imageScaleTitleContainer = new PropertiesFormTitleContainer("Image Scale Properties");
        
        
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        //Point - x.
        VBox xPointContainer = new VBox();
        xPointContainer.setPrefWidth(205.0);
        xPointContainer.setSpacing(10);
        Label lblXPoint = new Label("Scale: X");
        TextField xPointTextField = new TextField(String.valueOf(0.5d));
        xPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        xPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setX(Double.parseDouble(newValue));
        });
        xPointContainer.getChildren().addAll(lblXPoint, xPointTextField);

        //Point - y.
        VBox yPointContainer = new VBox();
        yPointContainer.setPrefWidth(205.0);
        yPointContainer.setSpacing(10);
        Label lblYPoint = new Label("Scale: Y");
        TextField yPointTextField = new TextField(String.valueOf(0.5d));
        yPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        yPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setY(Double.parseDouble(newValue));
        });
        yPointContainer.getChildren().addAll(lblYPoint, yPointTextField);
        
        VBox imageScalePropertiesContainer = new VBox();
        imageScalePropertiesContainer.setPrefSize(205, 47);
        imageScalePropertiesContainer.setSpacing(20);
        imageScalePropertiesContainer.setLayoutX(14);
        imageScalePropertiesContainer.setLayoutY(14);
        imageScalePropertiesContainer.getChildren().addAll(
        		imageScaleTitleContainer,
        		xPointContainer,
        		yPointContainer,
        		spaceContainer
               
        );
        getChildren().addAll(imageScalePropertiesContainer);
	}
}
