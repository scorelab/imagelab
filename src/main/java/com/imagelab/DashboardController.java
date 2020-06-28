package com.imagelab;

import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import static utils.Constants.CIRCLE_FORMAT;

/**
 * The controller class of the dashboard
 */
public class DashboardController {

    @FXML
    private AnchorPane buildAnchorPane;

    @FXML
    private Circle circleOperation;

    /**
     * To handle when users initial drag event.
     * @param event Triggered mouse event.
     *              When user tried to drag something that event
     *              passed as a parameter.
     */
    @FXML
    private void handleDragDetection (MouseEvent event) {
        Dragboard dragboard = circleOperation.startDragAndDrop(TransferMode.COPY);
        dragboard.setDragView(circleOperation.snapshot(null,null));
        ClipboardContent content = new ClipboardContent();
        content.put(CIRCLE_FORMAT, "circle");
        dragboard.setContent(content);
        System.out.println("Drag detected");
        event.consume();
    }

    /**
     * To handle when users initial drag event.
     * @param event Triggered Drag event.
     *              When user tried to drag something and
     *              move over to another area
     *              this function will be invoked.
     */
    @FXML
    private void handleDragOver (DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        if (dragboard.hasContent(CIRCLE_FORMAT)) {
            event.acceptTransferModes(TransferMode.COPY);
        }
        System.out.println("Drag over detected");
    }

    /**
     * To handle when users initial drag event.
     * @param event Triggered Drop event.
     *              When user dropped the dragged
     *              element this function will
     *              trigger.
     */
    @FXML
    private void handleDrop(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        if (dragboard.hasContent(CIRCLE_FORMAT)) {
            buildAnchorPane.getChildren().add(circleOperation);
            event.setDropCompleted(true);
        }
        System.out.println("Drop detected");
    }
}

