package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyDilation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DilationFilterPropertiesForm extends AbstractPropertiesForm{
	public DilationFilterPropertiesForm(ApplyDilation operator) {
		//Box Filter title container.
        PropertiesFormTitleContainer imageDilationTitleContainer;
        imageDilationTitleContainer = new PropertiesFormTitleContainer("Dilation Filter Properties");
        
        
        //Dilation.
        VBox iterationContainer = new VBox();
        iterationContainer.setPrefWidth(205.0);
        iterationContainer.setSpacing(10);
        Label lblDilation = new Label("Iteration : ");
        TextField dilationTextField = new TextField(String.valueOf(1));
        dilationTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        dilationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setIteration(Integer.parseInt(newValue));
        });
        iterationContainer.getChildren().addAll(lblDilation, dilationTextField);
        
        
        //Point - x.
        VBox xPointContainer = new VBox();
        xPointContainer.setPrefWidth(205.0);
        xPointContainer.setSpacing(10);
        Label lblXPoint = new Label("Point: X");
        TextField xPointTextField = new TextField(String.valueOf(-1));
        xPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        xPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setPointX(Double.parseDouble(newValue));
        });
        xPointContainer.getChildren().addAll(lblXPoint, xPointTextField);

        //Point - y.
        VBox yPointContainer = new VBox();
        yPointContainer.setPrefWidth(205.0);
        yPointContainer.setSpacing(10);
        Label lblYPoint = new Label("Point: Y");
        TextField yPointTextField = new TextField(String.valueOf(-1));
        yPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        yPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setPointY(Double.parseDouble(newValue));
        });
        yPointContainer.getChildren().addAll(lblYPoint, yPointTextField);
        
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox imageDilationPropertiesContainer = new VBox();
        imageDilationPropertiesContainer.setPrefSize(205, 47);
        imageDilationPropertiesContainer.setSpacing(20);
        imageDilationPropertiesContainer.setLayoutX(14);
        imageDilationPropertiesContainer.setLayoutY(14);
        imageDilationPropertiesContainer.getChildren().addAll(
        		imageDilationTitleContainer,
        		iterationContainer,
        		xPointContainer,
        		yPointContainer,
        		spaceContainer
               
        );
        getChildren().addAll(imageDilationPropertiesContainer);
	}
}