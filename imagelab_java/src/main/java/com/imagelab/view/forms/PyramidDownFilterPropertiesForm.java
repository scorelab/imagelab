package com.imagelab.view.forms;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PyramidDownFilterPropertiesForm extends AbstractPropertiesForm{
	public PyramidDownFilterPropertiesForm(ApplyImagePyramidDown operator) {
		// title container
        PropertiesFormTitleContainer ImagePyramidDownFilterTitleContainer;
        ImagePyramidDownFilterTitleContainer = new PropertiesFormTitleContainer("Pyramid Down Filter Properties");
        

        //Size - width.
        VBox widthSizeContainer = new VBox();
        widthSizeContainer.setPrefWidth(205.0);
        widthSizeContainer.setSpacing(10);
        Label lblWidthSize = new Label("Image Down Sampled by Half");
        //listener
        widthSizeContainer.getChildren().addAll(lblWidthSize);
        
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox imagePyramidDownFilterTitleContainer = new VBox();
        imagePyramidDownFilterTitleContainer.setPrefSize(205, 47);
        imagePyramidDownFilterTitleContainer.setSpacing(20);
        imagePyramidDownFilterTitleContainer.setLayoutX(14);
        imagePyramidDownFilterTitleContainer.setLayoutY(14);
        imagePyramidDownFilterTitleContainer.getChildren().addAll(
        		ImagePyramidDownFilterTitleContainer,
                widthSizeContainer,            
                spaceContainer
        );
        getChildren().addAll(imagePyramidDownFilterTitleContainer);
		
	}
}