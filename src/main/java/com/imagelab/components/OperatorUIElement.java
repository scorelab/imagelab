package com.imagelab.components;

import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import com.imagelab.operators.OpenCVOperator;
import javafx.scene.Node;

/**
 * Abstract class related to the operator UI elements.
 *
 * @param <T> any node
 */

public abstract class OperatorUIElement<T extends Node, E extends Node, N extends Node> {
    private final OpenCVOperator operator;
    private final String operatorId;
    private final String operatorName;
    /*Events*/
    private final OnUIElementCloneCreated onCloneCreated;
    private final OnUIElementDragDone onDragDone;
    private final String stylingId;
    private final double width;
    private final double height;
    private boolean addedToOperatorsStack;
    private boolean cloneable;
    private boolean previewOnly;
    // is null initially. have to set this instance once called
    // the build() method.
    private T node = null;
    private E form = null;
    private N information = null;

    public OperatorUIElement(OpenCVOperator operator, String operatorId, String operatorName, OnUIElementCloneCreated onCloneCreated, OnUIElementDragDone onDragDone, String stylingId, double width, double height, boolean addedToOperatorsStack, boolean cloneable, boolean previewOnly) {
        this.operator = operator;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.onCloneCreated = onCloneCreated;
        this.onDragDone = onDragDone;
        this.stylingId = stylingId;
        this.width = width;
        this.height = height;
        this.addedToOperatorsStack = addedToOperatorsStack;
        this.cloneable = cloneable;
        this.previewOnly = previewOnly;
    }

    public abstract void buildNode();

    public abstract void buildForm();

    public abstract void populateInformationPane();

    //Getters and Setters
    public OpenCVOperator getOperator() {
        return operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public OnUIElementCloneCreated getOnCloneCreated() {
        return onCloneCreated;
    }

    public OnUIElementDragDone getOnDragDone() {
        return onDragDone;
    }

    public String getStylingId() {
        return stylingId;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isAddedToOperatorsStack() {
        return addedToOperatorsStack;
    }

    public void setAddedToOperatorsStack(boolean addedToOperatorsStack) {
        this.addedToOperatorsStack = addedToOperatorsStack;
    }

    public boolean isCloneable() {
        return cloneable;
    }

    public void setCloneable(boolean cloneable) {
        this.cloneable = cloneable;
    }

    public boolean isPreviewOnly() {
        return previewOnly;
    }

    public void setPreviewOnly(boolean previewOnly) {
        this.previewOnly = previewOnly;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public E getForm() {
        return form;
    }

    public void setForm(E form) {
        this.form = form;
    }

    public N getInformation() {
        return information;
    }

    public void setInformation(N information) {
        this.information = information;
    }

}
