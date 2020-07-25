package com.imagelab.operators;

import lombok.Getter;
import lombok.Setter;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

public class RotateImage extends OpenCVOperator {

    @Getter
    @Setter
    private double angle;
    @Getter
    @Setter
    private double scale;

    @Override
    public boolean validate(OpenCVOperator previous) {
        if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat mat) {
        System.out.println("rotating image");
        return rotateImage(mat, this.angle, scale);
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        return allowed;
    }

    public Mat rotateImage(Mat imageFile, double rotationAngle, double scale) {
        // Creating an empty matrix to store the result
        Mat dst = new Mat();

        // Creating a Point object
        Point point = new Point(300, 200);

        // Creating the transformation matrix M
        //rotationAngle - 90, scale - 1
        Mat rotationMatrix = Imgproc.getRotationMatrix2D(point, rotationAngle, scale);

        // Creating the object of the class Size
        Size size = new Size(imageFile.cols(), imageFile.cols());

        // Rotating the given image
        Imgproc.warpAffine(imageFile, dst, rotationMatrix, size);

        System.out.println("Image Processed");

        return dst;
    }
}
