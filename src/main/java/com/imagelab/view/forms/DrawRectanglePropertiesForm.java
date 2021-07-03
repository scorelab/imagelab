package com.imagelab.view.forms;

import com.imagelab.operator.drawing.DrawRectangle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class DrawRectanglePropertiesForm extends AbstractPropertiesForm {
	public DrawRectanglePropertiesForm(DrawRectangle operator) {
		// title container
	    PropertiesFormTitleContainer DrawRectangleTitleContainer;
	    DrawRectangleTitleContainer = new PropertiesFormTitleContainer("Draw Rectangle Properties");
	    
	    //Space container
	    VBox spaceContainer = new VBox();
	    spaceContainer.setPrefWidth(205.0);
	    spaceContainer.setSpacing(10);
	    Label lblSpaceOne = new Label("");
	    Label lblSpaceTwo = new Label("");
	    spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
	    
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
	    
	    //Point - x1.
	    VBox xPointContainer = new VBox();
	    xPointContainer.setPrefWidth(205.0);
	    xPointContainer.setSpacing(10);
	    Label lblXPoint = new Label("Point: X1");
	    
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
				lblXPoint.setText(String.format("Point X1 : %.2f units", newValue.doubleValue()));
				operator.setPointX1(newValue.doubleValue());
			}
	    	
		});
	    xPointContainer.getChildren().addAll(lblXPoint, xPointSlider);

	    //Point - y1.
	    VBox yPointContainer = new VBox();
	    yPointContainer.setPrefWidth(205.0);
	    yPointContainer.setSpacing(10);
	    Label lblYPoint = new Label("Point: Y1");
	    
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
				lblYPoint.setText(String.format("Point Y1 : %.2f units", newValue.doubleValue()));
				operator.setPointY1(newValue.doubleValue());
			}
	    	
		});
	    yPointContainer.getChildren().addAll(lblYPoint, yPointSlider);
	    
	    //Point Two
	    
	    //Point - x1.
	    VBox x2PointContainer = new VBox();
	    x2PointContainer.setPrefWidth(205.0);
	    x2PointContainer.setSpacing(10);
	    Label lblX2Point = new Label("Point: X2");
	    
	    // set the color of the text
	    Slider x2PointSlider = new Slider();
	    x2PointSlider.setMin(-400);
	    x2PointSlider.setMax(400);
	    x2PointSlider.setValue(230);
	    // enable TickLabels and Tick Marks
	    x2PointSlider.setShowTickLabels(true);
	    x2PointSlider.setShowTickMarks(true);
	    x2PointSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    x2PointSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblX2Point.setText(String.format("Point X2 : %.2f units", newValue.doubleValue()));
				operator.setPointX2(newValue.doubleValue());
			}
	    	
		});
	    x2PointContainer.getChildren().addAll(lblX2Point, x2PointSlider);

	    //Point - y1.
	    VBox y2PointContainer = new VBox();
	    y2PointContainer.setPrefWidth(205.0);
	    y2PointContainer.setSpacing(10);
	    Label lblY2Point = new Label("Point: Y2");
	    
	    // set the color of the text
	    Slider y2PointSlider = new Slider();
	    y2PointSlider.setMin(-400);
	    y2PointSlider.setMax(400);
	    y2PointSlider.setValue(160);
	    // enable TickLabels and Tick Marks
	    y2PointSlider.setShowTickLabels(true);
	    y2PointSlider.setShowTickMarks(true);
	    y2PointSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    y2PointSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblY2Point.setText(String.format("Point Y2 : %.2f units", newValue.doubleValue()));
				operator.setPointY2(newValue.doubleValue());
			}
	    	
		});
	    y2PointContainer.getChildren().addAll(lblY2Point, y2PointSlider);

	    
	    VBox drawRectangleContainer = new VBox();
	    drawRectangleContainer.setPrefSize(205, 47);
	    drawRectangleContainer.setSpacing(20);
	    drawRectangleContainer.setLayoutX(14);
	    drawRectangleContainer.setLayoutY(14);
	    drawRectangleContainer.getChildren().addAll(
	    		DrawRectangleTitleContainer,
	    		thicknessSliderContainer,
	    		RedSliderContainer,
	    		GreenSliderContainer,
	    		BlueSliderContainer,
	    		xPointContainer,
	            yPointContainer,
	            x2PointContainer,
	            y2PointContainer
	    );
	    getChildren().addAll(drawRectangleContainer);
		
		}
}