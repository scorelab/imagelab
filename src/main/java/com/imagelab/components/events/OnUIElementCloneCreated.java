package com.imagelab.components.events;

import com.imagelab.components.OperatorUIElement;

/**
 * Functional interface which only have an abstract method to
 * handle clone created logic.
 */
@FunctionalInterface
public interface OnUIElementCloneCreated {
    /**
     * Call back function to accept an OperatorUIElement
     * during the cloning.
     *
     * @param element - OperatorUIElement.
     */
    void accept(OperatorUIElement element);
}
