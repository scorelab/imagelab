package com.imagelab.components.events;

import com.imagelab.components.OperatorUIElement;
import javafx.scene.Node;

/**
 * Functional interface which only have an abstract method to
 * handle clone created logic.
 */
@FunctionalInterface
public interface OnUIElementCloneCreated {
    void accept(OperatorUIElement<? extends Node, ? extends Node, ? extends Node> node);
}
