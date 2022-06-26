package com.imagelab.view.forms;

import com.imagelab.operator.miscellaneousoperators.CannyEdgeDetection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class CannyEdgeDetectionPropertiesForm extends AbstractPropertiesForm {
	public CannyEdgeDetectionPropertiesForm(CannyEdgeDetection operator) {
		// title container
	    PropertiesFormTitleContainer CannyEdgeTitleContainer;
	    CannyEdgeTitleContainer = new PropertiesFormTitleContainer("Canny Edge Properties");
	    
	    // Space container
	    VBox spaceContainer = new VBox();
	    spaceContainer.setPrefWidth(205.0);
	    spaceContainer.setSpacing(10);
	    Label lblSpaceOne = new Label("");
	    Label lblSpaceTwo = new Label("");
	    spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
	    
	    // Thresold low
	    VBox lowThresholdSliderContainer = new VBox();
	    lowThresholdSliderContainer.setPrefWidth(205.0);
	    lowThresholdSliderContainer.setSpacing(10);
	    Label lblLowThresoldSlider = new Label("Low Thresold :");
	 
	    Slider lowThresoldSlider = new Slider();
	    lowThresoldSlider.setMin(0);
	    lowThresoldSlider.setMax(300);
	    lowThresoldSlider.setValue(60);
	    // enable TickLabels and Tick Marks
	    lowThresoldSlider.setShowTickLabels(true);
	    lowThresoldSlider.setShowTickMarks(true);
	    lowThresoldSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    lowThresoldSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblLowThresoldSlider.setText(String.format("Low Thresold : %d units", (int)newValue.doubleValue()));
				operator.setLowThreshold((int)newValue.doubleValue());
			}
	    	
		});
	    lowThresholdSliderContainer.getChildren().addAll(lblLowThresoldSlider, lowThresoldSlider);
	    
	    // Thresold high
	    VBox highThresholdSliderContainer = new VBox();
	    highThresholdSliderContainer.setPrefWidth(205.0);
	    highThresholdSliderContainer.setSpacing(10);
	    Label lblHighThresoldSlider = new Label("High Thresold :");
	 
	    Slider highThresoldSlider = new Slider();
	    highThresoldSlider.setMin(0);
	    highThresoldSlider.setMax(300);
	    highThresoldSlider.setValue(60);
	    // enable TickLabels and Tick Marks
	    highThresoldSlider.setShowTickLabels(true);
	    highThresoldSlider.setShowTickMarks(true);
	    highThresoldSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    highThresoldSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblHighThresoldSlider.setText(String.format("High Thresold : %d units", (int)newValue.doubleValue()));
				operator.setHighThresold((int)newValue.doubleValue());
			}
	    	
		});
	    highThresholdSliderContainer.getChildren().addAll(lblHighThresoldSlider, highThresoldSlider);
	    
	    VBox cannyEdgeContainer = new VBox();
	    cannyEdgeContainer.setPrefSize(205, 47);
	    cannyEdgeContainer.setSpacing(20);
	    cannyEdgeContainer.setLayoutX(14);
	    cannyEdgeContainer.setLayoutY(14);
	    cannyEdgeContainer.getChildren().addAll(
	    	CannyEdgeTitleContainer,
	    	lowThresholdSliderContainer,
	    	highThresholdSliderContainer
	    );
	    getChildren().addAll(cannyEdgeContainer);
		
	}
}
