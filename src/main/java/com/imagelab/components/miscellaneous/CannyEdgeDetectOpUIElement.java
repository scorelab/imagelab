package com.imagelab.components.miscellaneous;

import com.imagelab.components.Draggable;
import com.imagelab.components.OperatorUIElement;
import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import com.imagelab.operators.miscellaneous.CannyEdgeDetect;
import com.imagelab.utils.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import static com.imagelab.utils.Constants.ANY_NODE;
import static javafx.scene.input.TransferMode.MOVE;

public class CannyEdgeDetectOpUIElement extends OperatorUIElement<Button, AnchorPane, AnchorPane> implements Draggable, Cloneable {

    private final ScrollPane uiElementPropertiesPane;
    private final ScrollPane informationScrollPane;

    public CannyEdgeDetectOpUIElement(
            OnUIElementCloneCreated onCloneCreated,
            OnUIElementDragDone onDragDone,
            ScrollPane uiElementPropertiesPane,
            ScrollPane informationScrollPane
    ) {
        super(
                new CannyEdgeDetect(), // To invoke openCV related logic
                CannyEdgeDetect.class.getCanonicalName(),
                CannyEdgeDetect.class.getSimpleName(),
                onCloneCreated,
                onDragDone,
                "cannyEdgeDetect",
                Constants.OPERATOR_UI_ELEMENT.WIDTH,
                Constants.OPERATOR_UI_ELEMENT.HEIGHT,
                true,
                true,
                false
        );
        this.uiElementPropertiesPane = uiElementPropertiesPane;
        this.informationScrollPane = informationScrollPane;
    }

    /**
     * Overridden method from the draggable interface to
     * detect if the user is dragging and UI element
     *
     * @param event - Mouse event at the time of element being dragged
     */
    @Override
    public void dragDetected(MouseEvent event) {
        // create new clone
        assert getOnCloneCreated() != null;
        try {
            if (!isCloneable()) {
                getOnCloneCreated().accept(this);
            } else {
                getOnCloneCreated().accept(this.clone());
            }
        } catch (CloneNotSupportedException e) {
            System.err.println("operator does not support dragging / cloning");
        }

        Dragboard dragboard = getNode().startDragAndDrop(MOVE);
        dragboard.setDragView(getNode().snapshot(null, null));
        ClipboardContent content = new ClipboardContent();
        content.put(ANY_NODE, "operation");
        dragboard.setContent(content);
        event.consume();
    }

    /**
     * Custom clone method to create a clone from the
     * dragged UI element.
     *
     * @return - a cloned ReadImageOpUIElement
     * @throws CloneNotSupportedException x
     */
    public OperatorUIElement<Button, AnchorPane, AnchorPane> clone() throws CloneNotSupportedException {

        super.clone();

        final OperatorUIElement<Button, AnchorPane, AnchorPane> copy = new CannyEdgeDetectOpUIElement(
                this.getOnCloneCreated(),
                this.getOnDragDone(),
                this.uiElementPropertiesPane,
                this.informationScrollPane
        );
        copy.setCloneable(false);
        copy.setPreviewOnly(false);
        copy.setAddedToOperatorsStack(false);
        copy.buildNode();
        copy.buildForm();
        copy.populateInformationPane();

        return copy;

    }

    /**
     * Method to be triggered when user clicks on a UI element
     * in the playground.
     * Usage - this can be used to populate the side pane when needed
     */
    public void onClicked() {
        this.uiElementPropertiesPane.setContent(this.getForm());
        this.informationScrollPane.setContent(this.getInformation());
    }

    @Override
    public void buildNode() {
        final Button button = new Button();
        button.setId(getStylingId());
        button.setText(super.getOperatorName());
        button.prefHeight(super.getHeight());
        button.setPrefWidth(super.getWidth());
        button.setOnDragDetected(this::dragDetected);

        // source
        button.setOnDragDone((DragEvent event) -> {
            if (event.isAccepted()) {
                getOnDragDone().accept(this);
            } else {
                getOnDragDone().accept(null);
            }
        });
        button.setOnMouseClicked((event) -> {
            if (!isPreviewOnly()) {
                this.onClicked();
            }
        });

        setNode(button);
    }

    @Override
    public void buildForm() {
        CannyEdgeDetect operator = (CannyEdgeDetect) CannyEdgeDetectOpUIElement.this.getOperator();
    }

    @Override
    public void populateInformationPane() {
        CannyEdgeDetect operator = (CannyEdgeDetect) CannyEdgeDetectOpUIElement.this.getOperator();
    }
}
