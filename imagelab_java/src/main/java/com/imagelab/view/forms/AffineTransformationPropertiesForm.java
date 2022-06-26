package com.imagelab.view.forms;

import com.imagelab.operator.geotransformation.ImageAffine;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AffineTransformationPropertiesForm extends AbstractPropertiesForm{
	
	public AffineTransformationPropertiesForm(ImageAffine operator) {
		
		//Affine title container.
	    PropertiesFormTitleContainer affineTransformationTitleContainer;
	    affineTransformationTitleContainer = new PropertiesFormTitleContainer("Affine Image Properties");
	    
	    //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox affineTransformationPropertiesContainer = new VBox();
        affineTransformationPropertiesContainer.setPrefSize(205, 47);
        affineTransformationPropertiesContainer.setSpacing(20);
        affineTransformationPropertiesContainer.setLayoutX(14);
        affineTransformationPropertiesContainer.setLayoutY(14);
        affineTransformationPropertiesContainer.getChildren().addAll(
        		affineTransformationTitleContainer,
        		spaceContainer
        		
        );
        getChildren().addAll(affineTransformationPropertiesContainer);
	}
	
}
