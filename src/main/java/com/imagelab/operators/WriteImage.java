package com.imagelab.operators;

import lombok.Getter;
import lombok.Setter;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import java.util.HashSet;
import java.util.Set;

public class WriteImage extends OpenCVOperator {

    @Getter
    @Setter
    private String url;

    @Override
    public boolean validate(OpenCVOperator previous) {
        return true;
        // return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat image) {
        System.out.println("Writing image");
        String filePath = url;
        Highgui.imwrite(filePath, image);
        return image;
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        return allowed;
    }


}
