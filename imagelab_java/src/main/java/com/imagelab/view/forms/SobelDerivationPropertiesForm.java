package com.imagelab.view.forms;

import com.imagelab.operator.sobelderivation.SobelOperator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class SobelDerivationPropertiesForm extends AbstractPropertiesForm{
	public SobelDerivationPropertiesForm(SobelOperator operator) {
		//Color Maps title container.
        PropertiesFormTitleContainer ColorMapsTitleContainer;
        ColorMapsTitleContainer = new PropertiesFormTitleContainer("Sobel Dervation");
        
        // color map container
        VBox typeContainer = new VBox();
        typeContainer.setPrefWidth(205.0);
        typeContainer.setSpacing(10);
        //Different ColorMaps Choices.
        ToggleGroup sobel_type = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("HORIZONTAL");
        RadioButton r2 = new RadioButton("VERTICAL");
        RadioButton r3 = new RadioButton("BOTH");
        
        r1.setToggleGroup(sobel_type);
        r2.setToggleGroup(sobel_type);
        r3.setToggleGroup(sobel_type);
        
        // color map container1
        VBox typeContainer1 = new VBox(r1,r2,r3);
        typeContainer1.setPrefWidth(205.0);
        typeContainer1.setSpacing(7);
        
        r1.setSelected(true);
        
        sobel_type.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "HORIZONTAL" : operator.setType(1);break;
            	case "VERTICAL" : operator.setType(2);break;
            	case "BOTH" : operator.setType(3);break;
            	
            }
        });
         
        //Thickness
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
        
        VBox sobelPropertiesContainer = new VBox();
        sobelPropertiesContainer.setPrefSize(205, 47);
        sobelPropertiesContainer.setSpacing(20);
        sobelPropertiesContainer.setLayoutX(14);
        sobelPropertiesContainer.setLayoutY(14);
        sobelPropertiesContainer.getChildren().addAll(
        		ColorMapsTitleContainer,
        		typeContainer,
        		typeContainer1,
        		depthSliderContainer,
        		spaceContainer
               
        );
        getChildren().addAll(sobelPropertiesContainer);
	}
}