package com.imagelab.components;

import javafx.scene.input.MouseEvent;

/**
 * Interface which contains the methods related to the
 * draggable logic
 */
public interface Draggable {
    void dragDetected(MouseEvent event);
}
