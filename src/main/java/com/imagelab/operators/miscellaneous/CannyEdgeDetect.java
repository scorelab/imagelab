package com.imagelab.operators.miscellaneous;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.geotransformation.RotateImage;
import com.imagelab.operators.imageconversion.ConvertToGrayscale;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

import static org.opencv.imgcodecs.Imgcodecs.imwrite;

public class CannyEdgeDetect extends OpenCVOperator {
    @Override
    public boolean validate(OpenCVOperator previous) {
        if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat image) {
        System.out.println("Performed - Canny Edge Detection");
        return null;
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(CannyEdgeDetect.class);
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(WriteImage.class);
        return allowed;
    }

    private Mat detectCannyEdge(Mat imageFile) {
        // Creating an empty matrix to store the result
        Mat gray = new Mat();

        // Converting the image from color to Gray
        Imgproc.cvtColor(imageFile, gray, Imgproc.COLOR_BGR2GRAY);
        Mat edges = new Mat();

        // Detecting the edges
        Imgproc.Canny(gray, edges, 60, 60 * 3);

        // Writing the image
        imwrite("src/main/resources/com/imagelab/images/ProcessedImage.jpg", edges);

        return imageFile;
    }
}
