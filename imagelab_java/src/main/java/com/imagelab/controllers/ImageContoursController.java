package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.histogram.HistogramCalculation;
import com.imagelab.operator.imagecontours.BoundingBoxesForContours;
import com.imagelab.operator.imagecontours.ConvexHull;
import com.imagelab.operator.imagecontours.FindContours;
import com.imagelab.operator.imagecontours.ImageMoments;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.BoundingBoxesForContoursPropertiesForm;
import com.imagelab.view.forms.ConvexHullPropertiesForm;
import com.imagelab.view.forms.FindContoursPropertiesForm;
import com.imagelab.view.forms.HistogramCalculationPropertiesForm;
import com.imagelab.view.forms.ImageMomentsPropertiesForm;

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
	public static OperatorUIElement imageMomentsElement() {
		//Image Moments For Contours properties form.
        OperatorUIElement imageMoments = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ImageMoments
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new ImageMomentsPropertiesForm((ImageMoments) this.operator);
            }
        };
        imageMoments.operator = new ImageMoments();
        imageMoments.operatorId = ImageMoments.class.getCanonicalName();
        imageMoments.operatorName = "IMAGE-MOMENTS";
        imageMoments.elementStyleId = "imageMoments";
        imageMoments.buildElement();
        return imageMoments;
	}
	public static OperatorUIElement convexHullElement() {
		//Image Moments For Contours properties form.
        OperatorUIElement convexHull = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ConvexHull
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new ConvexHullPropertiesForm((ConvexHull) this.operator);
            }
        };
        convexHull.operator = new ConvexHull();
        convexHull.operatorId = ConvexHull.class.getCanonicalName();
        convexHull.operatorName = "CONVEX-HULL";
        convexHull.elementStyleId = "convexHull";
        convexHull.buildElement();
        return convexHull;
	}
}
