package com.imagelab.view;

import com.imagelab.util.Constants;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Initial preview view.
 */
public class InitialPreviewPaneView extends VBox {
    /**
     * Builds the initial preview UI
     * with one area indicator label.
     */
    public InitialPreviewPaneView() {
        setPrefSize(200.0, 100.0);
        Label areaIndicationLabel;
        areaIndicationLabel = new Label("Preview Pane");
        areaIndicationLabel.setWrapText(true);
        areaIndicationLabel.setTextAlignment(TextAlignment.CENTER);
        areaIndicationLabel.setFont(new Font(Constants.AREA_LBL_FONT_SIZE));
        areaIndicationLabel.setPrefWidth(205.0);
        areaIndicationLabel.setTextFill(Color.web(Constants.AREA_LBL_FONT_CLR));
        areaIndicationLabel.setAlignment(Pos.CENTER);
        areaIndicationLabel.setContentDisplay(ContentDisplay.CENTER);
        setLayoutY(150.0);
        setLayoutX(240.0);
        getChildren().addAll(areaIndicationLabel);
    }
}
