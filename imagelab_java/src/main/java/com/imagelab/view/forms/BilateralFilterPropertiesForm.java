package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplyBilateralFilter;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BilateralFilterPropertiesForm extends AbstractPropertiesForm{
	public BilateralFilterPropertiesForm(ApplyBilateralFilter operator) {
		//Box Filter title container.
        PropertiesFormTitleContainer imageBilateralTitleContainer;
        imageBilateralTitleContainer = new PropertiesFormTitleContainer("Bilateral Filter Properties");
        
        //Bilateral Filter
        VBox filtersizeContainer = new VBox();
        filtersizeContainer.setPrefWidth(205.0);
        filtersizeContainer.setSpacing(10);
        Label lblFilterSize = new Label("Filter Size : ");
        TextField filtersizeTextField = new TextField(String.valueOf(5));
        filtersizeTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        filtersizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setFilterSize(Integer.parseInt(newValue));
        });
        filtersizeContainer.getChildren().addAll(lblFilterSize, filtersizeTextField);
        
        
        //Point - x.
        VBox xPointContainer = new VBox();
        xPointContainer.setPrefWidth(205.0);
        xPointContainer.setSpacing(10);
        Label lblXPoint = new Label("Sigma Color: ");
        TextField xPointTextField = new TextField(String.valueOf(75));
        xPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        xPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setSigmaColor(Double.parseDouble(newValue));
        });
        xPointContainer.getChildren().addAll(lblXPoint, xPointTextField);

        //Point - y.
        VBox yPointContainer = new VBox();
        yPointContainer.setPrefWidth(205.0);
        yPointContainer.setSpacing(10);
        Label lblYPoint = new Label("Sigma Space: ");
        TextField yPointTextField = new TextField(String.valueOf(75));
        yPointTextField.setPrefSize(205.0, 27.0);
        //Listener to capture text change.
        yPointTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            operator.setSigmaSpace(Double.parseDouble(newValue));
        });
        yPointContainer.getChildren().addAll(lblYPoint, yPointTextField);
        
        //Space container
        VBox spaceContainer = new VBox();
        spaceContainer.setPrefWidth(205.0);
        spaceContainer.setSpacing(10);
        Label lblSpaceOne = new Label("");
        Label lblSpaceTwo = new Label("");
        spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
        
        VBox bilateralFilterPropertiesContainer = new VBox();
        bilateralFilterPropertiesContainer.setPrefSize(205, 47);
        bilateralFilterPropertiesContainer.setSpacing(20);
        bilateralFilterPropertiesContainer.setLayoutX(14);
        bilateralFilterPropertiesContainer.setLayoutY(14);
        bilateralFilterPropertiesContainer.getChildren().addAll(
        		imageBilateralTitleContainer,
        		filtersizeContainer,
        		xPointContainer,
        		yPointContainer,
        		spaceContainer
               
        );
        getChildren().addAll(bilateralFilterPropertiesContainer);
	}
}