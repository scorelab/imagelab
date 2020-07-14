package com.imagelab.components;

import com.imagelab.components.events.OnUIElementCloneCreated;
import com.imagelab.components.events.OnUIElementDragDone;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;

import static com.imagelab.utils.Constants.ANY_NODE;
import static javafx.scene.input.TransferMode.MOVE;

/**
 * Class which builds the RGB conversions operation
 * related UI element
 */
public class RGBChangeOpUIElement extends OperatorUIElement<Button> implements Draggable, Cloneable {

    public RGBChangeOpUIElement(OnUIElementCloneCreated onCloneCreated,
                                OnUIElementDragDone onDragDone,
                                String stylingID,
                                boolean cloneable,
                                String uiOperatorID,
                                String uiOperatorName,
                                double width,
                                double height,
                                boolean previewOnly) {
        super(uiOperatorID, uiOperatorName, onCloneCreated, onDragDone, stylingID, cloneable, previewOnly, width, height);
    }

    /**
     * Overridden method from the draggable interface to
     * detect if the user is dragging and UI element
     *
     * @param event - Mouse event at the time of element being dragged
     */
    @Override
    public void dragDetected(MouseEvent event) {
        System.out.println("Drag detected: RGBChangeOpUIElement");

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
        Dragboard dragboard = this.getNode().startDragAndDrop(MOVE);
        dragboard.setDragView(this.getNode().snapshot(null, null));
        ClipboardContent content = new ClipboardContent();
        content.put(ANY_NODE, "operation");
        dragboard.setContent(content);
        event.consume();
    }

    /**
     * Custom clone method to create a clone from the
     * dragged UI element.
     *
     * @return - a cloned RGBChangeOpUIElement
     * @throws CloneNotSupportedException
     */
    public RGBChangeOpUIElement clone() throws CloneNotSupportedException {
        super.clone();
        return new RGBChangeOpUIElement(
                getOnCloneCreated(),
                getOnDragDone(),
                getStylingID(),
                false,
                this.getUiOperatorID(),
                this.getUiOperatorName(),
                this.getWidth(),
                this.getHeight(),
                false);
    }

    /**
     * Method to be triggered when user clicks on a UI element
     * in the build pane.
     *
     * Usage - this can be used to populate the side pane when needed
     */
    public void onClicked() {
        System.out.println("now this element is enabled");
    }

    /**
     * Overridden method which builds an UI element
     * @return - Built RGBChangeOpUIElement
     */
    @Override
    protected Button build() {
        final Button button = new Button();

        button.setId(getStylingID());
        button.setText(super.getUiOperatorName());
        button.prefHeight(super.getHeight());
        button.setPrefWidth(super.getWidth());
        button.setOnDragDetected(this::dragDetected);
        button.setOnDragDone((ignored) -> {
            // custom logic
            getOnDragDone().accept(null);
        });
        button.setOnMouseClicked((event) -> {
            if (!isPreviewOnly()) {
                this.onClicked();
            }
        });
        //button.setDisable(isPreviewOnly());

        return button;
    }

}
