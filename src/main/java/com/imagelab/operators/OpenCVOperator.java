package com.imagelab.operators;

import org.opencv.core.Mat;

import java.util.Set;

public abstract class OpenCVOperator {

    public abstract boolean validate(OpenCVOperator previous);

    public abstract Mat compute(Mat image);

    public abstract Set<Class<?>> allowedOperators();

}
