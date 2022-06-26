package com.imagelab.view.forms;

import com.imagelab.operator.miscellaneousoperators.HistogramEqualization;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HistogramEqualizationPropertiesForm extends AbstractPropertiesForm{
	public HistogramEqualizationPropertiesForm(HistogramEqualization operator){
		//Histogram Equalization title container.
        PropertiesFormTitleContainer  HistogramEqualizationTitleContainer;
        HistogramEqualizationTitleContainer = new PropertiesFormTitleContainer("Histogram Equalization");
        
        // Histogram space
        VBox morphologicalContainer = new VBox();
        morphologicalContainer.setPrefWidth(205.0);
        morphologicalContainer.setSpacing(10);
       
                
        // Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox HistogramPropertiesContainer = new VBox();
        HistogramPropertiesContainer.setPrefSize(205, 47);
        HistogramPropertiesContainer.setSpacing(20);
        HistogramPropertiesContainer.setLayoutX(14);
        HistogramPropertiesContainer.setLayoutY(14);
        HistogramPropertiesContainer.getChildren().addAll(
        		HistogramEqualizationTitleContainer,
        		morphologicalContainer,
        		spaceContainer
               
        );
        getChildren().addAll(HistogramPropertiesContainer);
	}
}
