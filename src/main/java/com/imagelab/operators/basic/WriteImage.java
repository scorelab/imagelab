package com.imagelab.operators.basic;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.geotransformation.RotateImage;
import org.opencv.core.Mat;

import java.util.HashSet;
import java.util.Set;

import static org.opencv.imgcodecs.Imgcodecs.imwrite;

public class WriteImage extends OpenCVOperator {

    private String destinationURL = "src/main/resources/com/imagelab/images/ProcessedImage.jpg";

    @Override
    public boolean validate(OpenCVOperator previous) {
        return true;
        // return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat image) {
        System.out.println("Processed image file has saved to: " + getDestinationURL());
        return writeImage(getDestinationURL(), image);
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        return allowed;
    }

    private Mat writeImage(String dstURL, Mat processedImage) {
        imwrite(dstURL, processedImage);
        return processedImage;
    }

    public String getDestinationURL() {
        return destinationURL;
    }

    public void setDestinationURL(String destinationURL) {
        this.destinationURL = destinationURL;
    }


}
