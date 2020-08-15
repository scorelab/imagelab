package com.imagelab.views.forms;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class PropertiesFormTitleContainer extends VBox {

    PropertiesFormTitleContainer(String title) {
        setPrefWidth(205.0);
        setSpacing(10);

        Label titleRotationProperties = new Label(title);
        titleRotationProperties.setPrefWidth(205.0);
        titleRotationProperties.setAlignment(Pos.CENTER);
        titleRotationProperties.setContentDisplay(ContentDisplay.CENTER);

        Separator separator = new Separator();

        getChildren().addAll(titleRotationProperties, separator);
    }

}
