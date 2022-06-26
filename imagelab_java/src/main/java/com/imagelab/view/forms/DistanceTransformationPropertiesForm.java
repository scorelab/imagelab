package com.imagelab.view.forms;

import com.imagelab.operator.transformation.DistanceTransformation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class DistanceTransformationPropertiesForm extends AbstractPropertiesForm{
	public DistanceTransformationPropertiesForm(DistanceTransformation operator) {
		// Distance title container.
        PropertiesFormTitleContainer DistanceTitleContainer;
        DistanceTitleContainer = new PropertiesFormTitleContainer("Distance Transformation");
        
        // Distance container
        VBox typeContainer = new VBox();
        typeContainer.setPrefWidth(205.0);
        typeContainer.setSpacing(10);
        //Different ColorMaps Choices.
        ToggleGroup distance_type = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("DIST_C");
        RadioButton r2 = new RadioButton("DIST_L1");
        RadioButton r3 = new RadioButton("DIST_L2");
        RadioButton r4 = new RadioButton("DIST_LABEL_PIXEL");
        RadioButton r5 = new RadioButton("DIST_MASK_3");
        
        r1.setToggleGroup(distance_type);
        r2.setToggleGroup(distance_type);
        r3.setToggleGroup(distance_type);
        r4.setToggleGroup(distance_type);
        r5.setToggleGroup(distance_type);
        
        // distance container1
        Label lblType = new Label("Transformation Type Selection");
        VBox typeContainer1 = new VBox(lblType,r1,r2,r3,r4,r5);
        typeContainer1.setPrefWidth(205.0);
        typeContainer1.setSpacing(7);
        
        r1.setSelected(true);
        
        distance_type.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "DIST_C"  : operator.setType(1);break;
            	case "DIST_L1" : operator.setType(2);break;
            	case "DIST_L2" : operator.setType(3);break;
            	case "DIST_LABEL_PIXEL" : operator.setType(4);break;
            	case "DIST_MASK_3" : operator.setType(5);break;
            }
        });
         
        // Thickness
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
        
        VBox distancePropertiesContainer = new VBox();
        distancePropertiesContainer.setPrefSize(205, 47);
        distancePropertiesContainer.setSpacing(20);
        distancePropertiesContainer.setLayoutX(14);
        distancePropertiesContainer.setLayoutY(14);
        distancePropertiesContainer.getChildren().addAll(
        		DistanceTitleContainer,
        		typeContainer,
        		typeContainer1,
        		depthSliderContainer,
        		spaceContainer
               
        );
        getChildren().addAll(distancePropertiesContainer);
	}
}