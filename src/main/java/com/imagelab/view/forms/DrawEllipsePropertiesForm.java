package com.imagelab.view.forms;

import com.imagelab.operator.drawing.DrawEllipse;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DrawEllipsePropertiesForm extends AbstractPropertiesForm {
	public DrawEllipsePropertiesForm(DrawEllipse operator) {
		//Title container
	    PropertiesFormTitleContainer DrawEllipseTitleContainer;
	    DrawEllipseTitleContainer = new PropertiesFormTitleContainer("Draw Ellipse Properties");
	    
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
	    redSlider.setValue(255);
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
	    
	    //Point - X.
	    VBox xPointContainer = new VBox();
        xPointContainer.setPrefWidth(205.0);
        Label lblXPoint = new Label("Point: X");
        TextField xPointTextField = new TextField(String.valueOf(1));
        xPointTextField.setPrefSize(205.0, 27.0);
        
        // set the color of the text
        Slider xPointSlider = new Slider();
        xPointSlider.setMin(-100);
        xPointSlider.setMax(500);
        xPointSlider.setValue(200);
        // enable TickLabels and Tick Marks
        xPointSlider.setShowTickLabels(true);
        xPointSlider.setShowTickMarks(true);
        xPointSlider.setBlockIncrement(25);
        // Adding Listener to value property.
        xPointSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblXPoint.setText(String.format("Point: X : %.2f units", newValue.doubleValue()));
				xPointTextField.setText(newValue.toString());
				operator.setPointX1(newValue.doubleValue());
			}
        	
		});
        xPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        	xPointSlider.setValue(Double.parseDouble(newValue));
            operator.setPointX1(Double.parseDouble(newValue));
        });
        xPointContainer.getChildren().addAll(lblXPoint, xPointSlider, xPointTextField);

	    //Point - Y.
        VBox yPointContainer = new VBox();
        yPointContainer.setPrefWidth(205.0);
        Label lblYPoint = new Label("Point: Y");
        TextField yPointTextField = new TextField(String.valueOf(1));
        yPointTextField.setPrefSize(205.0, 27.0);
        
        // set the color of the text
        Slider yPointSlider = new Slider();
        yPointSlider.setMin(-100);
        yPointSlider.setMax(500);
        yPointSlider.setValue(150);
        // enable TickLabels and Tick Marks
        yPointSlider.setShowTickLabels(true);
        yPointSlider.setShowTickMarks(true);
        yPointSlider.setBlockIncrement(25);
        // Adding Listener to value property.
        yPointSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblYPoint.setText(String.format("Point: Y : %.2f units", newValue.doubleValue()));
				yPointTextField.setText(newValue.toString());
				operator.setPointY1(newValue.doubleValue());
			}
        	
		});
        yPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        	yPointSlider.setValue(Double.parseDouble(newValue));
        	operator.setPointY1(Double.parseDouble(newValue));
        });
        yPointContainer.getChildren().addAll(lblYPoint, yPointSlider, yPointTextField);
        
        // Double - a
        VBox aContainer = new VBox();
        aContainer.setPrefWidth(205.0);
        Label lblA = new Label("Center A : ");
        TextField aTextField = new TextField(String.valueOf(180));
        aTextField.setPrefSize(205.0, 27.0);
        aTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        	lblA.setText(String.format("Center: %.2s units", newValue));
        	operator.setA(Double.parseDouble(newValue));
        });
        aContainer.getChildren().addAll(lblA, aTextField);
        
	    //Size Properties
	    // width
	    VBox widthContainer = new VBox();
	    widthContainer.setPrefWidth(205.0);
	    widthContainer.setSpacing(10);
	    Label lblWidth = new Label("Width: ");
	    
	    // set the color of the text
	    Slider widthSlider = new Slider();
	    widthSlider.setMin(0);
	    widthSlider.setMax(400);
	    widthSlider.setValue(230);
	    // enable TickLabels and Tick Marks
	    widthSlider.setShowTickLabels(true);
	    widthSlider.setShowTickMarks(true);
	    widthSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    widthSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblWidth.setText(String.format("Width: %.2f units", newValue.doubleValue()));
				operator.setWidth(newValue.doubleValue());
			}
	    	
		});
	    widthContainer.getChildren().addAll(lblWidth, widthSlider);

	    //height
	    VBox heightContainer = new VBox();
	    heightContainer.setPrefWidth(205.0);
	    heightContainer.setSpacing(10);
	    Label lblHeight = new Label("Height: ");
	    
	    // set the color of the text
	    Slider heightSlider = new Slider();
	    heightSlider.setMin(0);
	    heightSlider.setMax(400);
	    heightSlider.setValue(160);
	    // enable TickLabels and Tick Marks
	    heightSlider.setShowTickLabels(true);
	    heightSlider.setShowTickMarks(true);
	    heightSlider.setBlockIncrement(50);
	    // Adding Listener to value property.
	    heightSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblHeight.setText(String.format("Height : %.2f units", newValue.doubleValue()));
				operator.setHeight(newValue.doubleValue());
			}
	    	
		});
	    heightContainer.getChildren().addAll(lblHeight, heightSlider);

	    
	    VBox drawEllipseContainer = new VBox();
	    drawEllipseContainer.setPrefSize(205, 47);
	    drawEllipseContainer.setSpacing(20);
	    drawEllipseContainer.setLayoutX(14);
	    drawEllipseContainer.setLayoutY(14);
	    drawEllipseContainer.getChildren().addAll(
	    		DrawEllipseTitleContainer,
	    		thicknessSliderContainer,
	    		xPointContainer,
	            yPointContainer,
	            widthContainer,
	            heightContainer,
	            aContainer,
	            RedSliderContainer,
	    		GreenSliderContainer,
	    		BlueSliderContainer
	    );
	    getChildren().addAll(drawEllipseContainer);
		
		}
}