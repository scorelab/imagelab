package com.imagelab.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Utilities {

    /**
     * This is a utility function which converts an OpenCV Mat object
     * to a writable image file.
     *
     * @param image - Mat object generated from the build pipeline
     * @return writableImage
     * @throws IOException
     */
    public static WritableImage loadImage(Mat image) throws IOException {
        //Encoding the image
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", image, matOfByte);

        //Storing the encoded Mat in a byte array
        byte[] byteArray = matOfByte.toArray();

        //Displaying the image
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);
        System.out.println("Image Loaded");

        //returning a writable image
        return SwingFXUtils.toFXImage(bufImage, null);
    }

}
