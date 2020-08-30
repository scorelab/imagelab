package com.imagelab.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

/**
 * View which is used to populate the output image.
 */
public class ProcessedImageView extends ImageView {
    /**
     * Builds the ProcessedImageView
     * to display the output image.
     *
     * @param image image to displayed.
     */
    public ProcessedImageView(WritableImage image) {
        setImage(image);
        setX(50);
        setY(25);
        setFitHeight(400);
        setFitWidth(500);
        setPreserveRatio(true);
        setSmooth(true);
        setCache(true);
    }
}
