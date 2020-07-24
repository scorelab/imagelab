package com.imagelab.components;

import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import javafx.scene.Node;

/**
 * Abstract class related to the operator UI elements
 *
 * @param <T> any node
 */
public abstract class OperatorUIElement<T extends Node> {

    private final String uiOperatorID;
    private final String uiOperatorName;
    private boolean isAddedToOperationQueue;

    /*Events*/
    private final OnUIElementCloneCreated onCloneCreated;
    private final OnUIElementDragDone onDragDone;

    private final String stylingID;

    private final boolean cloneable;
    private final boolean previewOnly;

    private final double width;
    private final double height;

    private final T node;

    public OperatorUIElement(String uiOperatorID, String uiOperatorName, boolean isAddedToOperationQueue, OnUIElementCloneCreated onCloneCreated, OnUIElementDragDone onDragDone, String stylingID, boolean cloneable, boolean previewOnly, double width, double height) {
        this.uiOperatorID = uiOperatorID;
        this.uiOperatorName = uiOperatorName;
        this.isAddedToOperationQueue = isAddedToOperationQueue;
        this.onCloneCreated = onCloneCreated;
        this.onDragDone = onDragDone;
        this.stylingID = stylingID;
        this.cloneable = cloneable;
        this.previewOnly = previewOnly;
        this.width = width;
        this.height = height;
        this.node = this.build();
    }

    protected abstract T build();

    public String getUiOperatorID() {
        return uiOperatorID;
    }

    public String getUiOperatorName() {
        return uiOperatorName;
    }

    public boolean isAddedToOperationQueue() { return isAddedToOperationQueue; }

    public void setIsAddedToOperationQueue(boolean isAddedToOperationQueue){
        this.isAddedToOperationQueue = isAddedToOperationQueue;
    }

    public OnUIElementCloneCreated getOnCloneCreated() {
        return onCloneCreated;
    }

    public OnUIElementDragDone getOnDragDone() {
        return onDragDone;
    }

    public String getStylingID() {
        return stylingID;
    }

    public boolean isCloneable() {
        return cloneable;
    }

    public boolean isPreviewOnly() {
        return previewOnly;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public T getNode() {
        return node;
    }
}
