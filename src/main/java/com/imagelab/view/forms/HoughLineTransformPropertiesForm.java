package com.imagelab.view.forms;

import com.imagelab.operator.miscellaneousoperators.HoughLineTransform;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class HoughLineTransformPropertiesForm extends AbstractPropertiesForm {
    public HoughLineTransformPropertiesForm(HoughLineTransform operator) {
    	// title container
	    PropertiesFormTitleContainer HoughLineTransformTitleContainer;
	    HoughLineTransformTitleContainer = new PropertiesFormTitleContainer("Hough Line Transform Properties");
	    
	    // Space container
	    VBox spaceContainer = new VBox();
	    spaceContainer.setPrefWidth(205.0);
	    spaceContainer.setSpacing(10);
	    Label lblSpaceOne = new Label("");
	    Label lblSpaceTwo = new Label("");
	    spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
	    
	    // Threshold
	    VBox thresholdSliderContainer = new VBox();
	    thresholdSliderContainer.setPrefWidth(205.0);
	    thresholdSliderContainer.setSpacing(10);
	    Label lblThresoldSlider = new Label("Thresold :");
	 
	    Slider thresoldSlider = new Slider();
	    thresoldSlider.setMin(0);
	    thresoldSlider.setMax(255);
	    thresoldSlider.setValue(100);
	    // enable TickLabels and Tick Marks
	    thresoldSlider.setShowTickLabels(true);
	    thresoldSlider.setShowTickMarks(true);
	    thresoldSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    thresoldSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblThresoldSlider.setText(String.format("Threshold : %d units", (int)newValue.doubleValue()));
				operator.setThreshold((int)newValue.doubleValue());
			}
	    	
		});
	    thresholdSliderContainer.getChildren().addAll(lblThresoldSlider, thresoldSlider);
	    
	    // Threshold high
	    VBox thetaSliderContainer = new VBox();
	    thetaSliderContainer.setPrefWidth(205.0);
	    thetaSliderContainer.setSpacing(10);
	    Label lblThetaSlider = new Label("Theta :");
	 
	    Slider thetaSlider = new Slider();
	    thetaSlider.setMin(0);
	    thetaSlider.setMax(4);
	    thetaSlider.setValue(1);
	    // enable TickLabels and Tick Marks
	    thetaSlider.setShowTickLabels(true);
	    thetaSlider.setShowTickMarks(true);
	    thetaSlider.setBlockIncrement(1);
	    // Adding Listener to value property.
	    thetaSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblThetaSlider.setText(String.format("Theta : %d units", (int)newValue.doubleValue()));
				operator.setTheta((int)newValue.doubleValue());
			}
	    	
		});
	    thetaSliderContainer.getChildren().addAll(lblThetaSlider, thetaSlider);
	    
	    VBox houghLineContainer = new VBox();
	    houghLineContainer.setPrefSize(205, 47);
	    houghLineContainer.setSpacing(20);
	    houghLineContainer.setLayoutX(14);
	    houghLineContainer.setLayoutY(14);
	    houghLineContainer.getChildren().addAll(
	    	HoughLineTransformTitleContainer,
	    	thresholdSliderContainer,
	    	thetaSliderContainer
	    );
	    getChildren().addAll(houghLineContainer);
	
    }
}
