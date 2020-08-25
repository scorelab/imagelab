package com.imagelab.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.opencv.imgcodecs.Imgcodecs.imencode;

public final class Utilities {
    /**
     * This is a utility function which converts an OpenCV Mat object
     * to a writable image file.
     *
     * @param image - Mat object generated from the build pipeline.
     * @return writableImage.
     */
    public static WritableImage loadImage(Mat image, String fileExtension) {
        //returning a writable image
        return SwingFXUtils.toFXImage(convertMatToBufImage(image, fileExtension), null);
    }

    /**
     * This utility methods converts a given mat image object to a buffered image
     * with the given image extension.
     *
     * @param image         - Mat image object.
     * @param fileExtension - File extension to be added to the bugImage.
     * @return - Converted Buffered image.
     */
    private static BufferedImage convertMatToBufImage(Mat image, String fileExtension) {
        //convert the matrix into a matrix of bytes appropriate for this file extension.
        MatOfByte matOfByte = new MatOfByte();
        if (image != null) {
            imencode(fileExtension, image, matOfByte);
        } else {
            throw new NullPointerException("image");
        }
        //convert the "matrix of bytes" into a byte array.
        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImage;
    }
}
