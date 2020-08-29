package com.imagelab.views.forms;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 * Properties form related title container which contains
 * tittle label and the separator.
 */
public class PropertiesFormTitleContainer extends VBox {
    /**
     * Builds the tittle container which is
     * a reusable view for properties containers
     * of each operator.
     *
     * @param title - title of the container.
     */
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
