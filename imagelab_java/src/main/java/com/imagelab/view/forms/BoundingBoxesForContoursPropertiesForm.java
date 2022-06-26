package com.imagelab.view.forms;

import com.imagelab.operator.imagecontours.BoundingBoxesForContours;

import javafx.scene.layout.VBox;

public class BoundingBoxesForContoursPropertiesForm extends AbstractPropertiesForm {
   public BoundingBoxesForContoursPropertiesForm(BoundingBoxesForContours operator) {
	   //Bounding Boxes for contours title container.
		
       PropertiesFormTitleContainer FindContoursContainer;
       FindContoursContainer = new PropertiesFormTitleContainer("Bounding Boxes for Contours");
       
       VBox contoursPropertiesContainer = new VBox();
       contoursPropertiesContainer.setPrefSize(205, 47);
       contoursPropertiesContainer.setSpacing(20);
       contoursPropertiesContainer.setLayoutX(14);
       contoursPropertiesContainer.setLayoutY(14);
       contoursPropertiesContainer.getChildren().addAll(
       	FindContoursContainer
       );
       getChildren().addAll(contoursPropertiesContainer);
	   
   }
}
