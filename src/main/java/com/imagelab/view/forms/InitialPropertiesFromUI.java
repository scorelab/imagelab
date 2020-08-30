package com.imagelab.view.forms;

import com.imagelab.util.Constants;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Initial properties form UI.
 */
public class InitialPropertiesFromUI extends AnchorPane {
    /**
     * Builds the initial properties form UI
     * with one area indicator label.
     */
    public InitialPropertiesFromUI() {
        setPrefSize(224.0, 523.0);
        VBox areaIndicatorLabelContainer = new VBox();
        areaIndicatorLabelContainer.setPrefWidth(205.0);
        Label areaIndicationLabel;
        areaIndicationLabel = new Label(" Properties Pane");
        areaIndicationLabel.setWrapText(true);
        areaIndicationLabel.setTextAlignment(TextAlignment.CENTER);
        areaIndicationLabel.setFont(new Font(Constants.AREA_LBL_FONT_SIZE));
        areaIndicationLabel.setPrefWidth(205.0);
        areaIndicationLabel.setTextFill(Color.web(Constants.AREA_LBL_FONT_CLR));
        areaIndicationLabel.setAlignment(Pos.CENTER);
        areaIndicationLabel.setContentDisplay(ContentDisplay.CENTER);
        areaIndicatorLabelContainer.getChildren().addAll(areaIndicationLabel);
        areaIndicatorLabelContainer.setLayoutY(115.0);
        getChildren().addAll(areaIndicatorLabelContainer);
    }
}
