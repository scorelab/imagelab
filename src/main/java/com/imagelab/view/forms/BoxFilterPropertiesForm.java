package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyBoxFilter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Applying box filter operation related
 * UI properties form.
 */
public class BoxFilterPropertiesForm extends AbstractPropertiesForm {
    /**
     * Builds BoxFilterPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public BoxFilterPropertiesForm(ApplyBoxFilter operator) {
        //Box Filter title container.
        PropertiesFormTitleContainer boxFilterTitleContainer;
        boxFilterTitleContainer = new PropertiesFormTitleContainer("Box Filter Properties");

        //Depth
        VBox depthSliderContainer = new VBox();
        depthSliderContainer.setPrefWidth(205.0);
        depthSliderContainer.setSpacing(10);
        Label lblDepthSlider = new Label("Depth :");
     
        Slider depthSlider = new Slider();
        depthSlider.setMin(0);
        depthSlider.setMax(100);
        depthSlider.setValue(50);
        // enable TickLabels and Tick Marks
        depthSlider.setShowTickLabels(true);
        depthSlider.setShowTickMarks(true);
        depthSlider.setBlockIncrement(10);
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

        //Size - width.
        VBox widthSizeContainer = new VBox();
        widthSizeContainer.setPrefWidth(205.0);
        widthSizeContainer.setSpacing(5);
        Label lblWidthSize = new Label("Width :");
        
        Slider widthSlider = new Slider();
        widthSlider.setMin(0);
        widthSlider.setMax(255);
        widthSlider.setValue(45);
        // enable TickLabels and Tick Marks
        widthSlider.setShowTickLabels(true);
        widthSlider.setShowTickMarks(true);
        widthSlider.setBlockIncrement(10);
        // Adding Listener to value property.
        widthSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblWidthSize.setText(String.format("Width : %.2f units", newValue.doubleValue()));
				operator.setWidthSize(newValue.doubleValue());
			}
        	
		});
        widthSizeContainer.getChildren().addAll(lblWidthSize, widthSlider);

        //Size - height.
        VBox heightSizeContainer = new VBox();
        heightSizeContainer.setPrefWidth(205.0);
        heightSizeContainer.setSpacing(5);
        Label lblHeightSize = new Label("Height :");
        
        Slider heightSlider = new Slider();
        heightSlider.setMin(0);
        heightSlider.setMax(255);
        heightSlider.setValue(45);
        // enable TickLabels and Tick Marks
        heightSlider.setShowTickLabels(true);
        heightSlider.setShowTickMarks(true);
        heightSlider.setBlockIncrement(10);
        // Adding Listener to value property.
        heightSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblHeightSize.setText(String.format("Height : %.2f units", newValue.doubleValue()));
				operator.setHeightSize(newValue.doubleValue());
			}
        	
		});
        heightSizeContainer.getChildren().addAll(lblHeightSize, heightSlider);

        //Point - x.
        VBox xPointContainer = new VBox();
        xPointContainer.setPrefWidth(205.0);
        xPointContainer.setSpacing(10);
        Label lblXPoint = new Label("Point: X");
        Label lblxPointDisplay = new Label(" ");
        
        // set the color of the text
        lblxPointDisplay.setTextFill(Color.BLACK);
        Slider xPointSlider = new Slider();
        xPointSlider.setMin(-10);
        xPointSlider.setMax(10);
        xPointSlider.setValue(-1);
        // enable TickLabels and Tick Marks
        xPointSlider.setShowTickLabels(true);
        xPointSlider.setShowTickMarks(true);
        xPointSlider.setBlockIncrement(10);
        // Adding Listener to value property.
        xPointSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblxPointDisplay.setText(String.format("%.2f units", newValue.doubleValue()));
				operator.setPointX(newValue.doubleValue());
			}
        	
		});
        xPointContainer.getChildren().addAll(lblXPoint, lblxPointDisplay, xPointSlider);

        //Point - y.
        VBox yPointContainer = new VBox();
        yPointContainer.setPrefWidth(205.0);
        yPointContainer.setSpacing(10);
        Label lblYPoint = new Label("Point: Y");
        Label lblYPointDisplay = new Label(" ");
        
        // set the color of the text
        lblYPointDisplay.setTextFill(Color.BLACK);
        Slider yPointSlider = new Slider();
        yPointSlider.setMin(-10);
        yPointSlider.setMax(10);
        yPointSlider.setValue(-1);
        // enable TickLabels and Tick Marks
        yPointSlider.setShowTickLabels(true);
        yPointSlider.setShowTickMarks(true);
        yPointSlider.setBlockIncrement(10);
        // Adding Listener to value property.
        yPointSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblYPointDisplay.setText(String.format("%.2f units", newValue.doubleValue()));
				operator.setPointY(newValue.doubleValue());
			}
        	
		});
        yPointContainer.getChildren().addAll(lblYPoint, lblYPointDisplay, yPointSlider);

        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);

        VBox boxFilterPropertiesContainer = new VBox();
        boxFilterPropertiesContainer.setPrefSize(205, 47);
        boxFilterPropertiesContainer.setSpacing(20);
        boxFilterPropertiesContainer.setLayoutX(14);
        boxFilterPropertiesContainer.setLayoutY(14);
        boxFilterPropertiesContainer.getChildren().addAll(
                boxFilterTitleContainer,
                depthSliderContainer,
                widthSizeContainer,
                heightSizeContainer,
                xPointContainer,
                yPointContainer,
                spaceContainer
        );
        getChildren().addAll(boxFilterPropertiesContainer);
    }
}
