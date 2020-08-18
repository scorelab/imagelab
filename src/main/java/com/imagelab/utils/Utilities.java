package com.imagelab.utils;

import com.imagelab.views.ProcessedImageView;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;

import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

public final class Utilities {

    public static WritableImage loadImage(Mat image) throws IOException {
        ProcessedImageView processedImage;
        //Setting processed Mat object to an ImageView

        //Encoding the image
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", image, matOfByte);

        //Storing the encoded Mat in a byte array
        byte[] byteArray = matOfByte.toArray();

        //Displaying the image
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);
        System.out.println("Image Loaded");
        WritableImage writableImage = SwingFXUtils.toFXImage(bufImage, null);

        return writableImage;
    }
}
