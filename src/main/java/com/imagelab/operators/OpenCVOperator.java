package com.imagelab.operators;

import org.opencv.core.Mat;

import java.util.Set;

/**
 * Abstract class which contains the openCV operator related
 * abstract methods.
 */
public abstract class OpenCVOperator {
    /**
     * This method contains the logic which validates the applicable
     * openCV operations for a particular openCV operator.
     *
     * @param previous - accepts the previous operator to validate.
     * @return - whether the received operator is valid or not.
     */
    public abstract boolean validate(OpenCVOperator previous);

    /**
     * This method contains the openCV operator related specific logic.
     *
     * @param image - accepts the mat object processed from the previous steps.
     * @return - processed computed Mat obj.
     */
    public abstract Mat compute(Mat image);

    /**
     * This method contains the applicable openCV operators for the selected
     * openCV operator.
     *
     * @return - applicable operators.
     */
    public abstract Set<Class<?>> allowedOperators();
}
