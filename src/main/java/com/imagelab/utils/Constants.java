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

    //File Paths or URLs
    public static final String STYLESHEET_PATH = "/com/imagelab/style.css";

    //Operator UI element related values
    public static final class OPERATOR_UI_ELEMENT {
        public static final double HEIGHT = 60.0;
        public static final double WIDTH = 150.0;
    }

}
