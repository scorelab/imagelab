package com.imagelab.components;

import javafx.scene.input.MouseEvent;

/**
 * Interface which contains the methods related to the
 * draggable logic.
 */
public interface Draggable {
    /**
     * To detect the dragEvent.
     *
     * @param event - MouseEvent.
     */
    void dragDetected(MouseEvent event);
}
