package com.imagelab.view.forms;

import com.imagelab.operator.imagecontours.ConvexHull;

import javafx.scene.layout.VBox;

public class ConvexHullPropertiesForm extends AbstractPropertiesForm{
   public ConvexHullPropertiesForm(ConvexHull operator) {
	     //Bounding Boxes for contours title container.
		
	     PropertiesFormTitleContainer ConvexHullTitleContainer;
	     ConvexHullTitleContainer = new PropertiesFormTitleContainer("Convex Hull");
	     
	     VBox contoursPropertiesContainer = new VBox();
	     contoursPropertiesContainer.setPrefSize(205, 47);
	     contoursPropertiesContainer.setSpacing(20);
	     contoursPropertiesContainer.setLayoutX(14);
	     contoursPropertiesContainer.setLayoutY(14);
	     contoursPropertiesContainer.getChildren().addAll(
	    	ConvexHullTitleContainer
	     );
	     getChildren().addAll(contoursPropertiesContainer);
   }
}
