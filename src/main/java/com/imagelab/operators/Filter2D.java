package com.imagelab.operators;

import java.util.ArrayList;
import java.util.List;

public class Filter2D extends OpenCVOperator {

    public void STYPE() {
    }

    @Override
    protected void validate() {
    }

    @Override
    protected void build() {

    }

    @Override
    protected List<Class<?>> allowedOperators() {

        List<Class<?>> list = new ArrayList<>();
        list.add(Filter2D.class);
        list.add(Filter2D.class);
        list.add(Filter2D.class);
        list.add(Filter2D.class);

        return list;
    }

    private static  class Properties {
        int sType;
        int dType;
    }

}
