package com.imagelab.view.forms;

import com.imagelab.operator.sobelderivation.ScharrOperator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ScharrDerivationPropertiesForm extends AbstractPropertiesForm{
	public ScharrDerivationPropertiesForm(ScharrOperator operator) {
		//Scharr title container.
        PropertiesFormTitleContainer ScharrTitleContainer;
        ScharrTitleContainer = new PropertiesFormTitleContainer("Scharr Dervation");
        
        //Scharr Container
        VBox typeContainer = new VBox();
        typeContainer.setPrefWidth(205.0);
        typeContainer.setSpacing(10);
        //Different ColorMaps Choices.
        ToggleGroup scharr_type = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("HORIZONTAL");
        RadioButton r2 = new RadioButton("VERTICAL");
        
        r1.setToggleGroup(scharr_type);
        r2.setToggleGroup(scharr_type);
        
        // scharr container1
        VBox typeContainer1 = new VBox(r1,r2);
        typeContainer1.setPrefWidth(205.0);
        typeContainer1.setSpacing(7);
        
        r1.setSelected(true);
        
        scharr_type.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "HORIZONTAL" : operator.setType(1);break;
            	case "VERTICAL" : operator.setType(2);break;
            }
        });
         
        //depth
	    VBox depthSliderContainer = new VBox();
	    depthSliderContainer.setPrefWidth(205.0);
	    depthSliderContainer.setSpacing(10);
	    Label lblDepthSlider = new Label("Depth :");
	 
	    Slider depthSlider = new Slider();
	    depthSlider.setMin(-10);
	    depthSlider.setMax(10);
	    depthSlider.setValue(-1);
	    // enable TickLabels and Tick Marks
	    depthSlider.setShowTickLabels(true);
	    depthSlider.setShowTickMarks(true);
	    depthSlider.setBlockIncrement(1);
	    // Adding Listener to value property.
	    depthSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblDepthSlider.setText(String.format("Depth : %d units", (int)newValue.doubleValue()));
				operator.setDepth((int)newValue.doubleValue());
			}
	    	
		});
	    depthSliderContainer.getChildren().addAll(lblDepthSlider, depthSlider);
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox scharrPropertiesContainer = new VBox();
        scharrPropertiesContainer.setPrefSize(205, 47);
        scharrPropertiesContainer.setSpacing(20);
        scharrPropertiesContainer.setLayoutX(14);
        scharrPropertiesContainer.setLayoutY(14);
        scharrPropertiesContainer.getChildren().addAll(
        		ScharrTitleContainer,
        		typeContainer,
        		typeContainer1,
        		depthSliderContainer,
        		spaceContainer
               
        );
        getChildren().addAll(scharrPropertiesContainer);
	}
}