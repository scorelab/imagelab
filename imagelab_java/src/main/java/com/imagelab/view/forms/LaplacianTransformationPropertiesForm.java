package com.imagelab.view.forms;


import com.imagelab.operator.transformation.LaplacianTransformation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class LaplacianTransformationPropertiesForm extends AbstractPropertiesForm{
	public LaplacianTransformationPropertiesForm(LaplacianTransformation operator) {
		//Laplacian title container.
        PropertiesFormTitleContainer LaplacianTitleContainer;
        LaplacianTitleContainer = new PropertiesFormTitleContainer("Laplacian Transformation");
         
        //depth
	    VBox depthSliderContainer = new VBox();
	    depthSliderContainer.setPrefWidth(205.0);
	    depthSliderContainer.setSpacing(10);
	    Label lblDepthSlider = new Label("Depth :");
	 
	    Slider depthSlider = new Slider();
	    depthSlider.setMin(-20);
	    depthSlider.setMax(20);
	    depthSlider.setValue(10);
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
        
        VBox laplacianPropertiesContainer = new VBox();
        laplacianPropertiesContainer.setPrefSize(205, 47);
        laplacianPropertiesContainer.setSpacing(20);
        laplacianPropertiesContainer.setLayoutX(14);
        laplacianPropertiesContainer.setLayoutY(14);
        laplacianPropertiesContainer.getChildren().addAll(
        		LaplacianTitleContainer,
        		depthSliderContainer,
        		spaceContainer
               
        );
        getChildren().addAll(laplacianPropertiesContainer);
	}
}