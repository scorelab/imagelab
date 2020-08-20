package com.imagelab.operators.basic;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.geotransformation.RotateImage;
import org.opencv.core.Mat;

import java.util.HashSet;
import java.util.Set;

import static org.opencv.imgcodecs.Imgcodecs.imwrite;

/**
 * Operator class which contains the logic related to the
 * WriteImage UI element.
 */
public class WriteImage extends OpenCVOperator {

    //Default destination dir path to save the processed image.
    private String destinationURL = "src/main/resources/com/imagelab/images/ProcessedImage.jpg";

    /**
     * This method validates the possible operations before the
     * writeImage operation.
     *
     * @param previous - previous elements acceptable for the Write Image.
     * @return - true.
     */
    @Override
    public boolean validate(OpenCVOperator previous) {
        return true;
        // return allowedOperators().contains(previous.getClass());
    }

    /**
     * This method execute the openCV logic related to this
     * operator.
     *
     * @param image - Mat object need to write as an image.
     * @return processed image.
     */
    @Override
    public Mat compute(Mat image) {
        System.out.println("Processed image file has saved to: " + getDestinationURL());
        return writeImage(getDestinationURL(), image);
    }

    /**
     * This method contains the allowed previous elements related to
     * this openCV operation.
     *
     * @return - allowed operation set.
     */
    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        return allowed;
    }

    /**
     * OpenCV logic related to the writeImage operation.
     *
     * @param dstURL         - URL that the file needs to be saved.
     * @param processedImage - image processed from the previous steps.
     * @return - processed image.
     */
    private Mat writeImage(String dstURL, Mat processedImage) {
        imwrite(dstURL, processedImage);
        return processedImage;
    }

    /**
     * To get file saving path.
     *
     * @return - directory path.
     */
    public String getDestinationURL() {
        return destinationURL;
    }

    /**
     * To set the URL that image needs to be saved.
     *
     * @param destinationURL - The URL that image needs to be saved.
     */
    public void setDestinationURL(String destinationURL) {
        this.destinationURL = destinationURL;
    }
}
