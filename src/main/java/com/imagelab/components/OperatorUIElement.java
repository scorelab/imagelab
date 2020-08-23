package com.imagelab.components;

import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import com.imagelab.operators.OpenCVOperator;
import com.imagelab.utils.Constants;
import com.imagelab.views.AbstractInformationUI;
import com.imagelab.views.forms.AbstractPropertiesFormUI;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;

import static com.imagelab.utils.Constants.ANY_NODE;
import static javafx.scene.input.TransferMode.MOVE;

/**
 * This is class is the base of operator UI elements.
 */
public class OperatorUIElement {
    public static final double WIDTH = Constants.OPERATOR_UI_ELEMENT.WIDTH;
    public static final double HEIGHT = Constants.OPERATOR_UI_ELEMENT.HEIGHT;

    // Events related:
    // Must be initialized before creating any instances of this class.
    public static OnUIElementCloneCreated onCloneCreated;
    public static OnUIElementDragDone onDragDone;

    // Passed from parent
    public static ScrollPane propertiesPane;
    public static ScrollPane informationPane;

    // Must pass when creating an instance
    public OpenCVOperator operator;
    public String operatorId;
    public String operatorName;
    public String elementStyleId;

    // Controller logic related.
    public boolean addedToOperatorsStack = true;
    public boolean cloneable = true;
    public boolean previewOnly = false;

    public Node element;
    public AbstractPropertiesFormUI propertiesFormUI;
    public AbstractInformationUI informationUI;

    public void buildElement() {

        final Button button = new Button();
        button.setId(this.elementStyleId);
        button.setText(this.operatorName);
        button.prefHeight(HEIGHT);
        button.setPrefWidth(WIDTH);
        button.setOnDragDetected(this::onElementDragDetected);

        button.setOnDragDone((event) -> {
            if (event.isAccepted()) {
                onDragDone.accept(this);
            } else {
                onDragDone.accept(null);
            }
        });

        button.setOnMouseClicked((event) -> {
            if (!this.previewOnly) {
                propertiesPane.setContent(this.propertiesFormUI);
                informationPane.setContent(this.informationUI);
            }
        });

        this.element = button;

    }

    public AbstractPropertiesFormUI buildPropertiesFormUI() {
        return null;
    }

    public AbstractInformationUI buildInformationUI() {
        return null;
    }

    private void onElementDragDetected(MouseEvent e) {

        // create a new clone if cloneable.
        assert onCloneCreated != null;
        if (!cloneable) {
            onCloneCreated.accept(this);
        } else {
            onCloneCreated.accept(this.cloneElement());
        }
        Dragboard dragboard = element.startDragAndDrop(MOVE);
        dragboard.setDragView(element.snapshot(null, null));
        ClipboardContent content = new ClipboardContent();
        content.put(ANY_NODE, "operation");
        dragboard.setContent(content);
        e.consume();

    }

    private OperatorUIElement cloneElement() {

        OperatorUIElement copy = new OperatorUIElement();

        copy.operator = this.operator;
        copy.operatorId = this.operatorId;
        copy.operatorName = this.operatorName;

        copy.cloneable = false;
        copy.previewOnly = false;
        copy.addedToOperatorsStack = false;

        copy.propertiesFormUI = buildPropertiesFormUI();
        copy.informationUI = buildInformationUI();
        copy.elementStyleId = this.elementStyleId;

        copy.buildElement();

        return copy;

    }


}
