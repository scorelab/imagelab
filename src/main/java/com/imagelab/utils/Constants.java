package com.imagelab.utils;
import javafx.scene.Node;
import javafx.scene.input.DataFormat;

/**
 * This class holds the constants
 * related to the project.
 */
public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    // DataFormats
    public static final DataFormat CIRCLE_FORMAT = new DataFormat("javafx.scene.shape.Circle");
    public static final DataFormat BUTTON = new DataFormat("javafx.scene.control.Button");
    public static final DataFormat ANY_NODE = new DataFormat("javafx.scene.Node");
}
