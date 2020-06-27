package com.imagelab;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class DashboardController {

    private final DataFormat circleFormat = new DataFormat("javafx.scene.shape.Circle");

    @FXML
    private AnchorPane buidlanchorpane;

    @FXML
    private Circle circleoperation;

    @FXML
    private void handleDragDetection (MouseEvent event){
        Dragboard db = circleoperation.startDragAndDrop(TransferMode.COPY);
        db.setDragView(circleoperation.snapshot(null, null));
        ClipboardContent content = new ClipboardContent();
        content.put(circleFormat, "circle");
        db.setContent(content);
        System.out.println("Drag detected");
        event.consume();
    }

    @FXML
    private void handleDragOver (DragEvent event){
        Dragboard db = event.getDragboard();
        if (db.hasContent(circleFormat)) {
            event.acceptTransferModes(TransferMode.COPY);
        }
    }

    @FXML
    private void handleDrop(DragEvent event){
        Dragboard db = event.getDragboard();
        if (db.hasContent(circleFormat)) {
            buidlanchorpane.getChildren().add(circleoperation);
            event.setDropCompleted(true);
        }
    }

}
