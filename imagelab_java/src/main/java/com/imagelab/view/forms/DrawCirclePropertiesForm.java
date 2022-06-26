package com.imagelab.view.forms;

import com.imagelab.operator.drawing.DrawCircle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DrawCirclePropertiesForm extends AbstractPropertiesForm{
	public DrawCirclePropertiesForm(DrawCircle operator) {
	// title container
    PropertiesFormTitleContainer DrawCircleTitleContainer;
    DrawCircleTitleContainer = new PropertiesFormTitleContainer("Draw Circle Drawing Properties");
    
    //Space container
    VBox spaceContainer = new VBox();
    spaceContainer.setPrefWidth(205.0);
    spaceContainer.setSpacing(10);
    Label lblSpaceOne = new Label("");
    Label lblSpaceTwo = new Label("");
    spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
    
    //Radius
    VBox depthSliderContainer = new VBox();
    depthSliderContainer.setPrefWidth(205.0);
    depthSliderContainer.setSpacing(10);
    Label lblDepthSlider = new Label("Radius :");
 
    Slider depthSlider = new Slider();
    depthSlider.setMin(0);
    depthSlider.setMax(300);
    depthSlider.setValue(75);
    // enable TickLabels and Tick Marks
    depthSlider.setShowTickLabels(true);
    depthSlider.setShowTickMarks(true);
    depthSlider.setBlockIncrement(25);
    // Adding Listener to value property.
    depthSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblDepthSlider.setText(String.format("Radius : %d units", (int)newValue.doubleValue()));
			operator.setRadius((int)newValue.doubleValue());
		}
    	
	});
    depthSliderContainer.getChildren().addAll(lblDepthSlider, depthSlider);
    
    //Thickness
    VBox thicknessSliderContainer = new VBox();
    thicknessSliderContainer.setPrefWidth(205.0);
    thicknessSliderContainer.setSpacing(10);
    Label lblThicknessSlider = new Label("Thickness :");
 
    Slider thicknessSlider = new Slider();
    thicknessSlider.setMin(0);
    thicknessSlider.setMax(100);
    thicknessSlider.setValue(10);
    // enable TickLabels and Tick Marks
    thicknessSlider.setShowTickLabels(true);
    thicknessSlider.setShowTickMarks(true);
    thicknessSlider.setBlockIncrement(10);
    // Adding Listener to value property.
    thicknessSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblThicknessSlider.setText(String.format("Thickness : %d units", (int)newValue.doubleValue()));
			operator.setThickness((int)newValue.doubleValue());
		}
    	
	});
    thicknessSliderContainer.getChildren().addAll(lblThicknessSlider, thicknessSlider);
    
    //Red 
    VBox RedSliderContainer = new VBox();
    RedSliderContainer.setPrefWidth(205.0);
    RedSliderContainer.setSpacing(10);
    Label lblRedSlider = new Label("Red :");
 
    Slider redSlider = new Slider();
    redSlider.setMin(0);
    redSlider.setMax(255);
    redSlider.setValue(10);
    // enable TickLabels and Tick Marks
    redSlider.setShowTickLabels(true);
    redSlider.setShowTickMarks(true);
    redSlider.setBlockIncrement(10);
    // Adding Listener to value property.
    redSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblRedSlider.setText(String.format("Red : %d units", (int)newValue.doubleValue()));
			operator.setR((int)newValue.doubleValue());
		}
    	
	});
    RedSliderContainer.getChildren().addAll(lblRedSlider, redSlider);
    
    //Green
    VBox GreenSliderContainer = new VBox();
    GreenSliderContainer.setPrefWidth(205.0);
    GreenSliderContainer.setSpacing(10);
    Label lblGreenSlider = new Label("Green :");
 
    Slider greenSlider = new Slider();
    greenSlider.setMin(0);
    greenSlider.setMax(255);
    greenSlider.setValue(10);
    // enable TickLabels and Tick Marks
    greenSlider.setShowTickLabels(true);
    greenSlider.setShowTickMarks(true);
    greenSlider.setBlockIncrement(10);
    // Adding Listener to value property.
    greenSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblGreenSlider.setText(String.format("Green : %d units", (int)newValue.doubleValue()));
			operator.setG((int)newValue.doubleValue());
		}
    	
	});
    GreenSliderContainer.getChildren().addAll(lblGreenSlider, greenSlider);
    
    //Blue
    VBox BlueSliderContainer = new VBox();
    BlueSliderContainer.setPrefWidth(205.0);
    BlueSliderContainer.setSpacing(10);
    Label lblBlueSlider = new Label("Blue :");
 
    Slider blueSlider = new Slider();
    blueSlider.setMin(0);
    blueSlider.setMax(255);
    blueSlider.setValue(10);
    // enable TickLabels and Tick Marks
    blueSlider.setShowTickLabels(true);
    blueSlider.setShowTickMarks(true);
    blueSlider.setBlockIncrement(10);
    // Adding Listener to value property.
    blueSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblBlueSlider.setText(String.format("Blue : %d units", (int)newValue.doubleValue()));
			operator.setB((int)newValue.doubleValue());
		}
    	
	});
    BlueSliderContainer.getChildren().addAll(lblBlueSlider, blueSlider);
    
    //Point - x.
    VBox xPointContainer = new VBox();
    xPointContainer.setPrefWidth(205.0);
    xPointContainer.setSpacing(10);
    Label lblXPoint = new Label("Point: X");
    
    // set the color of the text
    Slider xPointSlider = new Slider();
    xPointSlider.setMin(-400);
    xPointSlider.setMax(400);
    xPointSlider.setValue(230);
    // enable TickLabels and Tick Marks
    xPointSlider.setShowTickLabels(true);
    xPointSlider.setShowTickMarks(true);
    xPointSlider.setBlockIncrement(50);
    // Adding Listener to value property.
    xPointSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblXPoint.setText(String.format("Point X : %.2f units", newValue.doubleValue()));
			operator.setPointX(newValue.doubleValue());
		}
    	
	});
    xPointContainer.getChildren().addAll(lblXPoint, xPointSlider);

    //Point - y.
    VBox yPointContainer = new VBox();
    yPointContainer.setPrefWidth(205.0);
    yPointContainer.setSpacing(10);
    Label lblYPoint = new Label("Point: Y");
    
    // set the color of the text
    Slider yPointSlider = new Slider();
    yPointSlider.setMin(-400);
    yPointSlider.setMax(400);
    yPointSlider.setValue(160);
    // enable TickLabels and Tick Marks
    yPointSlider.setShowTickLabels(true);
    yPointSlider.setShowTickMarks(true);
    yPointSlider.setBlockIncrement(50);
    // Adding Listener to value property.
    yPointSlider.valueProperty().addListener(new ChangeListener<Number>() {

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			// TODO Auto-generated method stub
			lblYPoint.setText(String.format("Point Y : %.2f units", newValue.doubleValue()));
			operator.setPointY(newValue.doubleValue());
		}
    	
	});
    yPointContainer.getChildren().addAll(lblYPoint, yPointSlider);

    
    VBox drawCircleTitleContainer = new VBox();
    drawCircleTitleContainer.setPrefSize(205, 47);
    drawCircleTitleContainer.setSpacing(20);
    drawCircleTitleContainer.setLayoutX(14);
    drawCircleTitleContainer.setLayoutY(14);
    drawCircleTitleContainer.getChildren().addAll(
    		DrawCircleTitleContainer,
    		depthSliderContainer,
    		thicknessSliderContainer,
    		RedSliderContainer,
    		GreenSliderContainer,
    		BlueSliderContainer,
    		xPointContainer,
            yPointContainer,
            spaceContainer
    );
    getChildren().addAll(drawCircleTitleContainer);
	
	}
}