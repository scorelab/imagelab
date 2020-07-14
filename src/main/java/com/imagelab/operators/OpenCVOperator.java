package com.imagelab.operators;

import java.util.List;

public abstract class OpenCVOperator {

    protected abstract void validate();

    protected abstract void build();

    protected abstract List<Class<?>> allowedOperators();

}
