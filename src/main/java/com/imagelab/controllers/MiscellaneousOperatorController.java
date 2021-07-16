package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.miscellaneousoperators.CannyEdgeDetection;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.CannyEdgeDetectionPropertiesForm;


public class MiscellaneousOperatorController {
	public static OperatorUIElement cannyEdgeDetectionElement() {
		//Canny Edge Detection UI element.
        OperatorUIElement cannyEdgeDetection = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(CannyEdgeDetection
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new CannyEdgeDetectionPropertiesForm((CannyEdgeDetection) this.operator);
            }
        };
        cannyEdgeDetection.operator = new CannyEdgeDetection();
        cannyEdgeDetection.operatorId = CannyEdgeDetection.class.getCanonicalName();
        cannyEdgeDetection.operatorName = "CANNY-EDGE";
        cannyEdgeDetection.elementStyleId = "cannyEdge";
        cannyEdgeDetection.buildElement();
        return cannyEdgeDetection;
	}
}
