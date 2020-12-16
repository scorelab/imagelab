package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyErosionFilter;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ErosionFilterPropertiesForm extends AbstractPropertiesForm{
	public ErosionFilterPropertiesForm(ApplyErosionFilter operator) {
		//Box Filter title container.
        PropertiesFormTitleContainer applyErosionTitleContainer;
        applyErosionTitleContainer = new PropertiesFormTitleContainer("Erosion Filter Properties");
        
        //Iteration
        VBox iterationContainer = new VBox();
        iterationContainer.setPrefWidth(205.0);
        iterationContainer.setSpacing(10);
        Label lblErosion = new Label("Iteration : ");
        TextField erosionTextField = new TextField(String.valueOf(1));
        erosionTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        erosionTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setIteration(Integer.parseInt(newValue));
        });
        iterationContainer.getChildren().addAll(lblErosion, erosionTextField);
        
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
        
        VBox applyErosionPropertiesContainer = new VBox();
        applyErosionPropertiesContainer.setPrefSize(205, 47);
        applyErosionPropertiesContainer.setSpacing(20);
        applyErosionPropertiesContainer.setLayoutX(14);
        applyErosionPropertiesContainer.setLayoutY(14);
        applyErosionPropertiesContainer.getChildren().addAll(
        		applyErosionTitleContainer,
        		iterationContainer,
        		xPointContainer,
        		yPointContainer,
        		spaceContainer
               
        );
        getChildren().addAll(applyErosionPropertiesContainer);
	}
}