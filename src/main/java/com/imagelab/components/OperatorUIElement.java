package com.imagelab.components;

import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import com.imagelab.operators.OpenCVOperator;
import javafx.scene.Node;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Abstract class related to the operator UI elements.
 *
 * @param <T> any node
 */
@Data
@RequiredArgsConstructor
public abstract class OperatorUIElement<T extends Node, E extends Node> {

    /*Operator logic related*/
    @NonNull
    private final OpenCVOperator operator;
    @NonNull
    private final String operatorId;
    @NonNull
    private final String operatorName;

    /*Events*/
    @NonNull
    private final OnUIElementCloneCreated onCloneCreated;
    @NonNull
    private final OnUIElementDragDone onDragDone;

    @NonNull
    private final String stylingId;
    @NonNull
    private final double width;
    @NonNull
    private final double height;

    @NonNull
    private boolean addedToOperatorsStack;
    @NonNull
    private boolean cloneable;
    @NonNull
    private boolean previewOnly;

    // is null initially. have to set this instance once called
    // the build() method.
    private T node = null;
    private E form = null;

    public abstract void buildNode();

    public abstract void buildForm();

}
