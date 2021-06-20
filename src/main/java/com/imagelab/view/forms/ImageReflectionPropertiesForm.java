package com.imagelab.view.forms;

import com.imagelab.operator.geotransformation.ImageReflection;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ImageReflectionPropertiesForm extends AbstractPropertiesForm{
	
	public ImageReflectionPropertiesForm(ImageReflection operator) {
		//Box Filter title container.
        PropertiesFormTitleContainer imageReflectionTitleContainer;
        imageReflectionTitleContainer = new PropertiesFormTitleContainer("Image Refection Properties");
        
        // image reflection container
        VBox colorContainer = new VBox();
        colorContainer.setPrefWidth(205.0);
        colorContainer.setSpacing(10);
        //Different Reflection Choices.
        ToggleGroup refection_set = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("DIRECTION-Y");
        RadioButton r2 = new RadioButton("DIRECTION-X");
        RadioButton r3 = new RadioButton("DIRECTION-Both");
        RadioButton r4 = new RadioButton("NONE");
        
        r1.setToggleGroup(refection_set);
        r2.setToggleGroup(refection_set);
        r3.setToggleGroup(refection_set);
        r4.setToggleGroup(refection_set);
        
        // color map container1
        VBox colorContainer1 = new VBox(r1,r2,r3,r4);
        colorContainer1.setPrefWidth(205.0);
        colorContainer1.setSpacing(7);
        
        r3.setSelected(true);
        
        refection_set.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "DIRECTION-Y" : operator.setType(1);break;
            	case "DIRECTION-X" : operator.setType(2);break;
            	case "DIRECTION-Both" : operator.setType(3);break;
            	case "NONE" : operator.setType(4);break;
            }
        });
                
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox imageReflectionPropertiesContainer = new VBox();
        imageReflectionPropertiesContainer.setPrefSize(205, 47);
        imageReflectionPropertiesContainer.setSpacing(20);
        imageReflectionPropertiesContainer.setLayoutX(14);
        imageReflectionPropertiesContainer.setLayoutY(14);
        imageReflectionPropertiesContainer.getChildren().addAll(
        		imageReflectionTitleContainer,
        		colorContainer,
        		colorContainer1,
        		spaceContainer
               
        );
        getChildren().addAll(imageReflectionPropertiesContainer);
	}
	
}
