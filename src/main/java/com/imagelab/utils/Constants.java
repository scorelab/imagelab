package com.imagelab.utils;

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
    public static final DataFormat ANY_NODE = new DataFormat("javafx.scene.Node");

    //Sizes of windows and layouts related values
    public static final double DASHBOARD_WIDTH = 1285.0;
    public static final double DASHBOARD_HEIGHT = 785.0;

    //Custom UI elements related values
    public static final class READ_IMAGE_OPERATION_BLOCK {
        public static final double WIDTH = 60.0;
        public static final double HEIGHT = 50.0;
    }
}
