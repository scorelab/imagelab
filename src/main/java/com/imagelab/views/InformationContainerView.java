package com.imagelab.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Information view which is used to populate operations related
 * information.
 */
public class InformationContainerView extends AbstractInformationUI {
    /**
     * This builds InformationContainerView.
     *
     * @param description - operator description.
     */
    public InformationContainerView(String description) {
        VBox informationContainer = new VBox();
        informationContainer.setSpacing(20.0);
        informationContainer.setLayoutX(10);
        informationContainer.setLayoutY(15.0);
        informationContainer.setPrefWidth(230.0);
        // To hold operator's description.
        Label lblDescription = new Label(description);
        lblDescription.setWrapText(true);
        // Populating information container.
        informationContainer.getChildren().addAll(lblDescription);
        setPrefWidth(230.0);
        getChildren().addAll(informationContainer);
    }
}
