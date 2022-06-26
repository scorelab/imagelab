package com.imagelab.view.forms;

import com.imagelab.operator.geotransformation.ColorMaps;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class ColorMapsPropertiesForm extends AbstractPropertiesForm{
	public ColorMapsPropertiesForm(ColorMaps operator) {
		//Color Maps title container.
        PropertiesFormTitleContainer ColorMapsTitleContainer;
        ColorMapsTitleContainer = new PropertiesFormTitleContainer("Color Maps Properties");
        
        
        // color map container
        VBox colorContainer = new VBox();
        colorContainer.setPrefWidth(205.0);
        colorContainer.setSpacing(10);
        //Different ColorMaps Choices.
        ToggleGroup color_maps = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("HOT");
        RadioButton r2 = new RadioButton("AUTUMN");
        RadioButton r3 = new RadioButton("BONE");
        RadioButton r4 = new RadioButton("COOL");
        RadioButton r5 = new RadioButton("HSV");
        RadioButton r6 = new RadioButton("JET");
        RadioButton r7 = new RadioButton("OCEAN");
        RadioButton r8 = new RadioButton("PARULA");
        RadioButton r9 = new RadioButton("PINK");
        RadioButton r10 = new RadioButton("RAINBOW");
        RadioButton r11 = new RadioButton("SPRING");
        RadioButton r12 = new RadioButton("SUMMER");
        RadioButton r13 = new RadioButton("WINTER");
        
        r1.setToggleGroup(color_maps);
        r2.setToggleGroup(color_maps);
        r3.setToggleGroup(color_maps);
        r4.setToggleGroup(color_maps);
        r5.setToggleGroup(color_maps);
        r6.setToggleGroup(color_maps);
        r7.setToggleGroup(color_maps);
        r8.setToggleGroup(color_maps);
        r9.setToggleGroup(color_maps);
        r10.setToggleGroup(color_maps);
        r11.setToggleGroup(color_maps);
        r12.setToggleGroup(color_maps);
        r13.setToggleGroup(color_maps);
        
        // color map container1
        VBox colorContainer1 = new VBox(r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13);
        colorContainer1.setPrefWidth(205.0);
        colorContainer1.setSpacing(7);
        
        r3.setSelected(true);
        
        /*
         * switch for the selection of the color maps operation
        */
        color_maps.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "HOT" : operator.setType(1);break;
            	case "AUTUMN" : operator.setType(2);break;
            	case "BONE" : operator.setType(3);break;
            	case "COOL" : operator.setType(4);break;
            	case "RAINBOW" : operator.setType(5);break;
            	case "HSV" : operator.setType(6);break;
            	case "JET" : operator.setType(7);break;
            	case "OCEAN" : operator.setType(8);break;
            	case "PARULA" : operator.setType(9);break;
            	case "PINK" : operator.setType(10);break;
            	case "SPRING" : operator.setType(11);break;
            	case "SUMMER" : operator.setType(12);break;
            	case "WINTER" : operator.setType(13);break;
            }
        });
                
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox colorMapsPropertiesContainer = new VBox();
        colorMapsPropertiesContainer.setPrefSize(205, 47);
        colorMapsPropertiesContainer.setSpacing(20);
        colorMapsPropertiesContainer.setLayoutX(14);
        colorMapsPropertiesContainer.setLayoutY(14);
        colorMapsPropertiesContainer.getChildren().addAll(
        		ColorMapsTitleContainer,
        		colorContainer,
        		colorContainer1,
        		spaceContainer
               
        );
        getChildren().addAll(colorMapsPropertiesContainer);
	}
}