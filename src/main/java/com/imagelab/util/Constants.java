package com.imagelab.util;

import javafx.scene.input.DataFormat;

/**
 * This class holds the constants
 * related to the project.
 */
public final class Constants {
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
     * Dashboard area indicator label
     * font size.
     */
    public static final double AREA_LBL_FONT_SIZE = 33.0;
    /**
     * Dashboard area indicator label
     * font color.
     */
    public static final String AREA_LBL_FONT_CLR = "#b0b0b0";
    /**
     * Initial information or the instructions to use dashboard
     * to be displayed in the information pane
     * when the app starts.
     */
    public static final String HOW_TO_USE_INFO = "Let's get stated with"
            + " ImageLab.\n\nImageLab dashboard consist four main parts"
            + " such as,\n"
            + "Operators pane: panel on your left contains the"
            + "operators that you can drag and drop to the"
            + "playground area.\n\n"
            + "Playground: area that you can use to build your"
            + "openCV pipeline.\n\n"
            + "Preview pane: area which you can see your output.\n\n"
            + "Properties pane: where you can change the properties"
            + "related to the operators.";
    /**
     * Private constructor to restrict
     * instantiation.
     */
    private Constants() {
    }

    /**
     * Operator UI element related values.
     */
    public static final class OPERATOR_UI_ELEMENT {
        /**
         * Height of the operator UI element.
         */
        public static final double HEIGHT = 70.0;
        /**
         * Width of the operator UI element.
         */
        public static final double WIDTH = 170.0;
    }
}
