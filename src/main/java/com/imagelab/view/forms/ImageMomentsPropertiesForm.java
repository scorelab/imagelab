package com.imagelab.view.forms;

import com.imagelab.operator.imagecontours.ImageMoments;

import javafx.scene.layout.VBox;

public class ImageMomentsPropertiesForm extends AbstractPropertiesForm {
 public ImageMomentsPropertiesForm(ImageMoments operator) {
	 //Bounding Boxes for contours title container.
		
     PropertiesFormTitleContainer ImageMomentTitleContainer;
     ImageMomentTitleContainer = new PropertiesFormTitleContainer("Image Moments");
     
     VBox contoursPropertiesContainer = new VBox();
     contoursPropertiesContainer.setPrefSize(205, 47);
     contoursPropertiesContainer.setSpacing(20);
     contoursPropertiesContainer.setLayoutX(14);
     contoursPropertiesContainer.setLayoutY(14);
     contoursPropertiesContainer.getChildren().addAll(
     	ImageMomentTitleContainer
     );
     getChildren().addAll(contoursPropertiesContainer);
	   
 }
}
