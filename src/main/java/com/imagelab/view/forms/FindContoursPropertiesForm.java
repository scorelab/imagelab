package com.imagelab.view.forms;

import com.imagelab.operator.imagecontours.FindContours;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FindContoursPropertiesForm extends AbstractPropertiesForm{
   public FindContoursPropertiesForm(FindContours operator) {
	   //Find Contours title container.
		
       PropertiesFormTitleContainer FindContoursContainer;
       FindContoursContainer = new PropertiesFormTitleContainer("Find & Draw Contours");
       
       // canny threshold value
       VBox thresholdSliderContainer = new VBox();
       thresholdSliderContainer.setPrefWidth(205.0);
       thresholdSliderContainer.setSpacing(10);
       Label lblthresholdSlider = new Label("Canny Threshold :");
       TextField boxthresholdTextField = new TextField(String.valueOf(100));
       boxthresholdTextField.setPrefSize(205.0, 27.0);
       
       Slider thresholdSlider = new Slider();
       thresholdSlider.setMin(0);
       thresholdSlider.setMax(255);
       thresholdSlider.setValue(100);
       // enable TickLabels and Tick Marks
       thresholdSlider.setShowTickLabels(true);
       thresholdSlider.setShowTickMarks(true);
       thresholdSlider.setBlockIncrement(25);
       // Adding Listener to value property.
       thresholdSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				lblthresholdSlider.setText(String.format("threshold : %d units", (int)newValue.doubleValue()));
				operator.setThreshold((int)newValue.doubleValue());
			}
			
		});
       boxthresholdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
       	thresholdSlider.setValue(Integer.parseInt(newValue));
           operator.setThreshold(Integer.parseInt(newValue));
       });
       
       thresholdSliderContainer.getChildren().addAll(lblthresholdSlider, thresholdSlider, boxthresholdTextField);

       
       VBox contoursPropertiesContainer = new VBox();
       contoursPropertiesContainer.setPrefSize(205, 47);
       contoursPropertiesContainer.setSpacing(20);
       contoursPropertiesContainer.setLayoutX(14);
       contoursPropertiesContainer.setLayoutY(14);
       contoursPropertiesContainer.getChildren().addAll(
       	FindContoursContainer,
       	thresholdSliderContainer
       );
       getChildren().addAll(contoursPropertiesContainer);
   }
}
