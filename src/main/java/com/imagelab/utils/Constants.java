package com.imagelab.utils;

import javafx.scene.input.DataFormat;

/**
 * This class holds the constants
 * related to the project.
 */
public final class Constants {
    /**
     * Private constructor to restrict
     * instantiation.
     */
    private Constants() {
    }

    /**
     * Application version.
     */
    public static final String IMAGELAB_VERSION = "v1.0.0";

    /**
     * Organization details.
     */
    public static final String ORG_INFO = "SCoRE Labs";

    /**
     * DataFormats related to the app.
     */
    public static final DataFormat ANY_NODE
            = new DataFormat("javafx.scene.Node");

    /**
     * Width of the dashboard.
     */
    public static final double DASHBOARD_WIDTH = 1285.0;
    /**
     * Height of the dashboard.
     */
    public static final double DASHBOARD_HEIGHT = 785.0;

    /**
     * Stylesheet Paths or URLs.
     */
    public static final String STYLESHEET_PATH = "/com/imagelab/style.css";

    /**
     * Operator UI element related values.
     */
    public static final class OPERATOR_UI_ELEMENT {
        /**
         * Height of the operator UI element.
         */
        public static final double HEIGHT = 60.0;
        /**
         * Width of the operator UI element.
         */
        public static final double WIDTH = 170.0;
    }
}
