package com.imagelab.operators.imageconversion;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.geotransformation.RotateImage;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class ConvertToGrayscale extends OpenCVOperator {

    @Override
    public boolean validate(OpenCVOperator previous) {
        if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat image) {
        System.out.println("Performed - Convert to Grayscale");
        return convertToGrayScale(image);
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        return allowed;
    }

    private Mat convertToGrayScale(Mat imageFile) {
        Mat image = new Mat(); //Creating the empty destination matrix

        //Converting the image to grayscale and saving it in the dst matrix
        Imgproc.cvtColor(imageFile, image, Imgproc.COLOR_RGB2GRAY);

        //Extracting data from the transformed image (dst)
        byte[] data1 = new byte[image.rows() * image.cols() * (int) (image.elemSize())];
        image.get(0, 0, data1);

        //Creating Buffered image using the data
        BufferedImage bufImage = new BufferedImage(image.cols(), image.rows(),
                BufferedImage.TYPE_BYTE_GRAY);

        //Setting the data elements to the image
        bufImage.getRaster().setDataElements(0, 0, image.cols(), image.rows(), data1);

        return image;
    }
}
