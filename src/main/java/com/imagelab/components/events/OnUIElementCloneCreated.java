package com.imagelab.components.events;

import com.imagelab.components.OperatorUIElement;

/**
 * Functional interface which only have an abstract method to
 * handle clone created logic.
 */
@FunctionalInterface
public interface OnUIElementCloneCreated {
    void accept(OperatorUIElement element);
}
