package com.imagelab.utils;

/**
 * Class which contains the operator UI elements related
 * information which needs to be displayed in the information pane
 */
public final class Information {

    private Information() {
        // restrict instantiation
    }

    /**
     * ImageLab application related general information
     */
    public static final class GENERAL_INFORMATION {
        public static final String OPEN_CV_VERSION = "v3.2.0";
        public static final String IMAGE_LAB_VERSION = "v1.0";
    }

    /**
     * Read Image Operator UI element related information
     */
    public static final class READ_IMAGE {
        public static final String NAME = "Read Image";
        public static final String OP_INFO = "Read Image\n\nThis operator helps you to read an image file and convert it to an OpenCV Mat object.";
        public static final String IMAGE_URL = "Image URL\n\nYou can set the path to your image by setting a string URL or by browsing files.";
    }

    /**
     * Rotate Image Operator UI element related information
     */
    public static final class ROTATE_IMAGE {
        public static final String NAME = "Rotate Image";
        public static final String OP_INFO = "Rotate Image\n\nThis operator allows you to rotate an image to a specific angle. Moreover you can change angle and scale related to the rotation.";
        public static final String ROTATE_ANGLE = "Rotation Angle\n\nThe angle you need to rotate your image.";
        public static final String ROTATE_SCALE = "Rotation Scale\n\nThe scale that you need to process your image while rotating.";
    }

    /**
     * Write Image Operator UI element related information
     */
    public static final class WRITE_IMAGE {
        public static final String NAME = "Write Image";
        public static final String OP_INFO = "Write Image\n\nThis operator allows you to save your processed image as a file";
        public static final String DIR_PATH = "Directory Path to Save\n\nFolder path to save your file.";
    }

}
