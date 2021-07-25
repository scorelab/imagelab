package com.imagelab.view.forms;

import com.imagelab.operator.filtering.ApplySQRBoxFilter;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SQRBoxFilterPropertiesForm extends AbstractPropertiesForm{
  public SQRBoxFilterPropertiesForm(ApplySQRBoxFilter operator) {
	  //SQRBox title container.
      PropertiesFormTitleContainer sqrBoxFilterTitleContainer;
      sqrBoxFilterTitleContainer = new PropertiesFormTitleContainer("SQRBox Filter Properties");
      
      //Depth
      VBox depthContainer = new VBox();
      depthContainer.setPrefWidth(205.0);
      depthContainer.setSpacing(10);
      Label lblDepth = new Label("Depth : ");
      TextField depthTextField = new TextField(String.valueOf(1));
      depthTextField.setPrefSize(205.0, 27.0);
      //Listener to capture text change.
      depthTextField.textProperty().addListener((observable, oldValue, newValue) -> {
          operator.setDepth(Integer.parseInt(newValue));
      });
      depthContainer.getChildren().addAll(lblDepth, depthTextField);
      
      //Size - X
      VBox xContainer = new VBox();
      xContainer.setPrefWidth(205.0);
      xContainer.setSpacing(10);
      Label lblSizeX = new Label("Size - X : ");
      TextField xTextField = new TextField(String.valueOf(1));
      xTextField.setPrefSize(205.0, 27.0);
      //Listener to capture text change.
      xTextField.textProperty().addListener((observable, oldValue, newValue) -> {
          operator.setX(Integer.parseInt(newValue));
      });
      xContainer.getChildren().addAll(lblSizeX, xTextField);
      
      //Size - Y
      VBox yContainer = new VBox();
      yContainer.setPrefWidth(205.0);
      yContainer.setSpacing(10);
      Label lblSizeY = new Label("Size - Y : ");
      TextField yTextField = new TextField(String.valueOf(1));
      yTextField.setPrefSize(205.0, 27.0);
      //Listener to capture text change.
      yTextField.textProperty().addListener((observable, oldValue, newValue) -> {
          operator.setY(Integer.parseInt(newValue));
      });
      yContainer.getChildren().addAll(lblSizeY, yTextField);
      
      //Space container
      VBox spaceContainer = new VBox();
      spaceContainer.setPrefWidth(205.0);
      spaceContainer.setSpacing(10);
      Label lblSpaceOne = new Label("");
      Label lblSpaceTwo = new Label("");
      spaceContainer.getChildren().addAll(lblSpaceOne, lblSpaceTwo);
      
      VBox srqBoxFilterPropertiesContainer = new VBox();
      srqBoxFilterPropertiesContainer.setPrefSize(205, 47);
      srqBoxFilterPropertiesContainer.setSpacing(20);
      srqBoxFilterPropertiesContainer.setLayoutX(14);
      srqBoxFilterPropertiesContainer.setLayoutY(14);
      srqBoxFilterPropertiesContainer.getChildren().addAll(
      		sqrBoxFilterTitleContainer,
      		depthContainer,
      		xContainer,
      		yContainer,
      		spaceContainer
             
      );
      getChildren().addAll(srqBoxFilterPropertiesContainer);
  }
}
