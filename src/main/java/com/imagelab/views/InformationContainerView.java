package com.imagelab.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Information view which is used to populate operations related
 * information.
 */
public class InformationContainerView extends AbstractInformationUI {
    public InformationContainerView(String description) {
        VBox informationContainer = new VBox();
        informationContainer.setSpacing(20.0);
        informationContainer.setLayoutX(10);
        informationContainer.setLayoutY(15.0);
        informationContainer.setPrefWidth(230.0);

        Label lblDescription = new Label(description);
        lblDescription.setWrapText(true);

        informationContainer.getChildren().addAll(lblDescription);
        setPrefWidth(230.0);
        getChildren().addAll(informationContainer);
    }
}
