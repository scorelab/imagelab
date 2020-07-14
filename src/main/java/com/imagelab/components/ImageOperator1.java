package com.imagelab.components;

import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

import java.util.function.Consumer;

import static com.imagelab.utils.Constants.ANY_NODE;

public class ImageOperator1 extends Button implements Draggable {

    private final Consumer<ImageOperator1> onCloneCreated;
    private final Consumer<Void> onDragDone;
    private final String id;

    private static double scaleFactor = 10;
    private static int elementCount = 0;

    public ImageOperator1(Consumer<ImageOperator1> onCloneCreated, Consumer<Void> onDragDone, String id) {
        this.onCloneCreated = onCloneCreated;
        this.onDragDone = onDragDone;
        this.id = id;
        this.setUp();
    }


    private void setUp() {
        this.setId(this.id);
        if (elementCount > 0) {

            this.setLayoutX(15.0 + scaleFactor);
            this.setLayoutY(68.0 + scaleFactor);
        } else {

            this.setLayoutX(15.0);
            this.setLayoutY(68.0);
        }
        this.setMnemonicParsing(false);
        this.prefHeight(52.0);
        this.setPrefWidth(64.8);
        this.setOnDragDetected(this::dragDetected);
        this.setOnDragDone((ignored) -> this.onDragDone.accept(null));
        elementCount++;

    }

    @Override
    public void dragDetected(MouseEvent event) {

        System.out.println("Drag detected");

        assert this.onCloneCreated != null;
        // create new clone
        this.onCloneCreated.accept(this.createClone());

        Dragboard dragboard = this.startDragAndDrop(TransferMode.ANY);
        dragboard.setDragView(this.snapshot(null, null));
        ClipboardContent content = new ClipboardContent();
        content.put(ANY_NODE, "sample-button");
        dragboard.setContent(content);

        event.consume();

    }

    private ImageOperator1 createClone() {
        return new ImageOperator1(onCloneCreated, onDragDone, this.id);
    }


}
