package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.histogram.HistogramCalculation;
import com.imagelab.operator.imagecontours.BoundingBoxesForContours;
import com.imagelab.operator.imagecontours.FindContours;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.BoundingBoxesForContoursPropertiesForm;
import com.imagelab.view.forms.FindContoursPropertiesForm;
import com.imagelab.view.forms.HistogramCalculationPropertiesForm;

public class ImageContoursController {
	public static OperatorUIElement findContoursElement() {
		//Find Contours UI element.
        OperatorUIElement findContours = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(FindContours
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new FindContoursPropertiesForm((FindContours) this.operator);
            }
        };
        findContours.operator = new FindContours();
        findContours.operatorId = FindContours.class.getCanonicalName();
        findContours.operatorName = "FIND-CONTOURS";
        findContours.elementStyleId = "findImageContours";
        findContours.buildElement();
        return findContours;
	}
	public static OperatorUIElement boundingBoxesForContoursElement() {
		//Bounding Box For Contours properties form.
        OperatorUIElement boundingBoxesForContours = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(BoundingBoxesForContours
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new BoundingBoxesForContoursPropertiesForm((BoundingBoxesForContours) this.operator);
            }
        };
        boundingBoxesForContours.operator = new BoundingBoxesForContours();
        boundingBoxesForContours.operatorId = BoundingBoxesForContours.class.getCanonicalName();
        boundingBoxesForContours.operatorName = "DRAW-BOUND-BOX";
        boundingBoxesForContours.elementStyleId = "boundBoxContours";
        boundingBoxesForContours.buildElement();
        return boundingBoxesForContours;
	}
}
