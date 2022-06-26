package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyFilter2D;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Filter2DPropertiesForm extends AbstractPropertiesForm {
	public Filter2DPropertiesForm(ApplyFilter2D operator) {
		//Filter2D title container.
        PropertiesFormTitleContainer filter2DTitleContainer;
        filter2DTitleContainer = new PropertiesFormTitleContainer("Filter 2D Properties");
        
        //Depth
        VBox depthContainer = new VBox();
        depthContainer.setPrefWidth(205.0);
        depthContainer.setSpacing(10);
        Label lblDepth = new Label("Depth : ");
        TextField depthTextField = new TextField(String.valueOf(1));
        depthTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        depthTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setDepth(Integer.parseInt(newValue));
        });
        depthContainer.getChildren().addAll(lblDepth, depthTextField);
        
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox filter2DPropertiesContainer = new VBox();
        filter2DPropertiesContainer.setPrefSize(205, 47);
        filter2DPropertiesContainer.setSpacing(20);
        filter2DPropertiesContainer.setLayoutX(14);
        filter2DPropertiesContainer.setLayoutY(14);
        filter2DPropertiesContainer.getChildren().addAll(
        		filter2DTitleContainer,
        		depthContainer,
        		spaceContainer
               
        );
        getChildren().addAll(filter2DPropertiesContainer);
	}
}
