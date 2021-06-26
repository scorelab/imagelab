package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyMorphological;
import com.imagelab.view.forms.AbstractPropertiesForm;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class MorphologicalPropertiesForm extends AbstractPropertiesForm {
	public MorphologicalPropertiesForm(ApplyMorphological operator){
		//Color Maps title container.
        PropertiesFormTitleContainer  MorphologicalTitleContainer;
        MorphologicalTitleContainer = new PropertiesFormTitleContainer("Morphological Operators");
        
        //Morphological operator container
        VBox morphologicalContainer = new VBox();
        morphologicalContainer.setPrefWidth(205.0);
        morphologicalContainer.setSpacing(10);
        //Different Operator Choices.
        ToggleGroup morphological_oplist = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("TOPHAT");
        RadioButton r2 = new RadioButton("CLOSE");
        RadioButton r3 = new RadioButton("CROSS");
        RadioButton r4 = new RadioButton("GRADIENT");
        RadioButton r5 = new RadioButton("RECT");
        RadioButton r6 = new RadioButton("BLACKHAT");
        RadioButton r7 = new RadioButton("OPEN");
        
        r1.setToggleGroup(morphological_oplist);
        r2.setToggleGroup(morphological_oplist);
        r3.setToggleGroup(morphological_oplist);
        r4.setToggleGroup(morphological_oplist);
        r5.setToggleGroup(morphological_oplist);
        r6.setToggleGroup(morphological_oplist);
        r7.setToggleGroup(morphological_oplist);
        
        // color map container1
        VBox morphologicalOplist = new VBox(r1,r2,r3,r4,r5,r6,r7);
        morphologicalOplist.setPrefWidth(205.0);
        morphologicalOplist.setSpacing(7);
        
        r3.setSelected(true);
        
        morphological_oplist.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "TOPHAT" : operator.setType(1);break;
            	case "CLOSE" : operator.setType(2);break;
            	case "CROSS" : operator.setType(3);break;
            	case "GRADIENT" : operator.setType(4);break;
            	case "RECT" : operator.setType(5);break;
            	case "BLACKHAT" : operator.setType(6);break;
            	case "OPEN" : operator.setType(7);break;
            }
        });
                
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox MorphologicalPropertiesContainer = new VBox();
        MorphologicalPropertiesContainer.setPrefSize(205, 47);
        MorphologicalPropertiesContainer.setSpacing(20);
        MorphologicalPropertiesContainer.setLayoutX(14);
        MorphologicalPropertiesContainer.setLayoutY(14);
        MorphologicalPropertiesContainer.getChildren().addAll(
        		MorphologicalTitleContainer,
        		morphologicalContainer,
        		morphologicalOplist,
        		spaceContainer
               
        );
        getChildren().addAll(MorphologicalPropertiesContainer);
	}
}
