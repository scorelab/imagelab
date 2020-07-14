package com.imagelab;

import com.imagelab.components.ImageOperator1;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

import static com.imagelab.utils.Constants.ANY_NODE;
import static com.imagelab.utils.Constants.BUTTON;

/**
 * The controller class of the dashboard
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane buildAnchorPane;

    @FXML
    private AnchorPane operationsPane;

    private Node currentlyApplyingOperator;

    /**
     * To handle when users initial drag event.
     *
     * @param event Triggered Drag event.
     *              When user tried to drag something and
     *              move over to another area
     *              this function will be invoked.
     */
    @FXML
    private void handleDragOver(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        if (dragboard.hasContent(ANY_NODE)) {
            event.acceptTransferModes(TransferMode.ANY);
        }
        System.out.println("Drag over detected");
    }

    /**
     * To handle when users initial drag event.
     *
     * @param event Triggered Drop event.
     *              When user dropped the dragged
     *              element this function will
     *              trigger.
     */
    @FXML
    private void handleDrop(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        if (dragboard.hasContent(ANY_NODE)) {
            buildAnchorPane.getChildren().add(currentlyApplyingOperator);
            event.setDropCompleted(true);
        }
        System.out.println("Drop detected");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ImageOperator1 filter1 = new ImageOperator1((operator) -> {
            this.currentlyApplyingOperator = operator;
        }, (_void) -> {
            this.currentlyApplyingOperator = null;
        }, "readImage");

        ImageOperator1 filter2 = new ImageOperator1((operator) -> {
            this.currentlyApplyingOperator = operator;
        }, (_void) -> {
            this.currentlyApplyingOperator = null;
        }, "readImage-blue");

        operationsPane.getChildren().addAll(filter1, filter2);

    }
}

