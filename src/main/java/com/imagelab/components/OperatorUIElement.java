package com.imagelab.components;

import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import com.imagelab.operators.OpenCVOperator;
import javafx.scene.Node;

/**
 * Abstract class related to the operator UI elements.
 *
 * @param <T> - node of the UI element.
 * @param <E> - properties form.
 * @param <N> - information form.
 */
public abstract class OperatorUIElement<T extends Node, E extends Node, N extends Node> {
    private final OpenCVOperator operator;
    private final String operatorId;
    private final String operatorName;
    //Events related
    private final OnUIElementCloneCreated onCloneCreated;
    private final OnUIElementDragDone onDragDone;

    private final String stylingId;
    private final double width;
    private final double height;
    private boolean addedToOperatorsStack;
    private boolean cloneable;
    private boolean previewOnly;
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

    /**
     * Abstract method which builds an UIElement
     * once it's dragged on to the playground area
     * to build an openCV pipeline.
     */
    public abstract void buildNode();

    /**
     * Abstract method that builds the UI element related
     * properties form for which allows user to change
     * the property values before executing the pipeline.
     */
    public abstract void buildForm();

    /**
     * Abstract method that populates the information pane with
     * UI element related information. So, that user can get a basic idea
     * what sort of functionality it does.
     */
    public abstract void populateInformationPane();

    //Getters and setters.

    /**
     * Usage - to get operator.
     *
     * @return - operator.
     */
    public OpenCVOperator getOperator() {
        return operator;
    }

    /**
     * Usage - to get operation ID.
     *
     * @return - operationID.
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Usage - to get operator name.
     *
     * @return - operatorName.
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Usage - to get clone creation state.
     *
     * @return - onCloneCreated.
     */
    public OnUIElementCloneCreated getOnCloneCreated() {
        return onCloneCreated;
    }

    /**
     * Usage - to get drag done state.
     *
     * @return - onDragDone.
     */
    public OnUIElementDragDone getOnDragDone() {
        return onDragDone;
    }

    /**
     * Usage - to get operator styling id.
     *
     * @return - stylingId.
     */
    public String getStylingId() {
        return stylingId;
    }

    /**
     * Usage - to get operator width.
     *
     * @return - width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Usage - to get operator height.
     *
     * @return - height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Usage - to get whether operator has been added
     * to the stack state.
     *
     * @return - addedToOperatorsStack.
     */
    public boolean isAddedToOperatorsStack() {
        return addedToOperatorsStack;
    }

    /**
     * To set the state of whether operator has been added
     * to the stack.
     *
     * @param addedToOperatorsStack - true/false.
     */
    public void setAddedToOperatorsStack(boolean addedToOperatorsStack) {
        this.addedToOperatorsStack = addedToOperatorsStack;
    }

    /**
     * Usage - to check whether operator has
     * cloneable permission.
     *
     * @return - cloneable.
     */
    public boolean isCloneable() {
        return cloneable;
    }

    /**
     * To set the state of whether the element is cloneable or not.
     *
     * @param cloneable - true/false.
     */
    public void setCloneable(boolean cloneable) {
        this.cloneable = cloneable;
    }

    /**
     * Usage - to check whether operator is
     * only available to preview.
     *
     * @return - previewOnly.
     */
    public boolean isPreviewOnly() {
        return previewOnly;
    }

    /**
     * To set the state of whether the UI element is only preview.
     *
     * @param previewOnly - true/false.
     */
    public void setPreviewOnly(boolean previewOnly) {
        this.previewOnly = previewOnly;
    }

    /**
     * Usage - to get operator node.
     *
     * @return - node.
     */
    public T getNode() {
        return node;
    }

    /**
     * To set the node element.
     *
     * @param node - accepts a UI element node.
     */
    public void setNode(T node) {
        this.node = node;
    }

    /**
     * Usage - to get operator properties form.
     *
     * @return - form.
     */
    public E getForm() {
        return form;
    }

    /**
     * To set the UI element related properties form
     *
     * @param form -  properties from node.
     */
    public void setForm(E form) {
        this.form = form;
    }

    /**
     * Usage - to get operator information.
     *
     * @return - information.
     */
    public N getInformation() {
        return information;
    }

    /**
     * To set the information related to the UI element.
     *
     * @param information - information pane form.
     */
    public void setInformation(N information) {
        this.information = information;
    }
}
