package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.drawing.DrawCircle;
import com.imagelab.operator.drawing.DrawLine;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.DrawCirclePropertiesForm;
import com.imagelab.view.forms.DrawLinePropertiesForm;

public class DrawingOperatorController {
	public static OperatorUIElement drawCircleEffectElement() {
		//drawCircle UI element.
        OperatorUIElement drawCircleEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(DrawCircle
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new DrawCirclePropertiesForm((DrawCircle) this.operator);
            }
        };
        drawCircleEffect.operator = new DrawCircle();
        drawCircleEffect.operatorId = DrawCircle.class.getCanonicalName();
        drawCircleEffect.operatorName = "DRAW-CIRCLE";
        drawCircleEffect.elementStyleId = "drawCircle";
        drawCircleEffect.buildElement();
        return drawCircleEffect;
	}
	public static OperatorUIElement drawLineEffectElement() {
		//drawCircle UI element.
        OperatorUIElement drawLineEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(DrawLine
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new DrawLinePropertiesForm((DrawLine) this.operator);
            }
        };
        drawLineEffect.operator = new DrawLine();
        drawLineEffect.operatorId = DrawCircle.class.getCanonicalName();
        drawLineEffect.operatorName = "DRAW-LINE";
        drawLineEffect.elementStyleId = "drawLine";
        drawLineEffect.buildElement();
        return drawLineEffect;
	}
}