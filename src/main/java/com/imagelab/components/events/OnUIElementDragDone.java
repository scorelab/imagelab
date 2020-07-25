package com.imagelab.components.events;

import com.imagelab.components.OperatorUIElement;
import javafx.scene.Node;

/**
 * Functional interface which only have an abstract method to
 * handle drag done logic.
 */
@FunctionalInterface
public interface OnUIElementDragDone {

    void accept(OperatorUIElement<? extends Node, ? extends Node> node);

}
