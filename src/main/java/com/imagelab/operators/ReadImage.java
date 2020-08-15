package com.imagelab.operators;

import org.opencv.core.Mat;
import java.util.HashSet;
import java.util.Set;

import static org.opencv.imgcodecs.Imgcodecs.imread;

public class ReadImage extends OpenCVOperator {

    private String ImageURL = "imageFile/main/resources/com/imagelab/images/scorelabLogo.jpg";

    @Override
    public boolean validate(OpenCVOperator previous) {
        return true;
        // return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat image) {
        System.out.println("Image URL: " + getImageURL());
        return readImage();
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        return allowed;
    }

    public Mat readImage() {
        return imread(getImageURL());
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        this.ImageURL = imageURL;
    }

}
