package com.imagelab.views;

import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class ProcessedImageView extends ImageView {

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
