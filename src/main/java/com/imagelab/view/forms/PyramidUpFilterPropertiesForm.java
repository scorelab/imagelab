package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyImagePyramid;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PyramidUpFilterPropertiesForm extends AbstractPropertiesForm{
	public PyramidUpFilterPropertiesForm(ApplyImagePyramid operator) {
		// title container
        PropertiesFormTitleContainer ImagePyramidUpFilterTitleContainer;
        ImagePyramidUpFilterTitleContainer = new PropertiesFormTitleContainer("Pyramid Up Filter Properties");
        

        //Size - width.
        VBox widthSizeContainer = new VBox();
        widthSizeContainer.setPrefWidth(205.0);
        widthSizeContainer.setSpacing(10);
        Label lblWidthSize = new Label("Image Up Sampled by Double");
        //listener
        widthSizeContainer.getChildren().addAll(lblWidthSize);
        
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox imagePyramidUpFilterTitleContainer = new VBox();
        imagePyramidUpFilterTitleContainer.setPrefSize(205, 47);
        imagePyramidUpFilterTitleContainer.setSpacing(20);
        imagePyramidUpFilterTitleContainer.setLayoutX(14);
        imagePyramidUpFilterTitleContainer.setLayoutY(14);
        imagePyramidUpFilterTitleContainer.getChildren().addAll(
        		ImagePyramidUpFilterTitleContainer,
                widthSizeContainer,            
                spaceContainer
        );
        getChildren().addAll(imagePyramidUpFilterTitleContainer);
		
	}
}