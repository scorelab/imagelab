package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.histogram.HistogramCalculation;
import com.imagelab.operator.transformation.LaplacianTransformation;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.HistogramCalculationPropertiesForm;
import com.imagelab.view.forms.LaplacianTransformationPropertiesForm;

public class HistogramController {
	public static OperatorUIElement histogramCalculationElement() {
		//Histogram Calculation UI element.
        OperatorUIElement histogramCalculation = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(HistogramCalculation
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new HistogramCalculationPropertiesForm((HistogramCalculation) this.operator);
            }
        };
        histogramCalculation.operator = new HistogramCalculation();
        histogramCalculation.operatorId = HistogramCalculation.class.getCanonicalName();
        histogramCalculation.operatorName = "HISTOGRAM";
        histogramCalculation.elementStyleId = "calHist";
        histogramCalculation.buildElement();
        return histogramCalculation;
	}
}
