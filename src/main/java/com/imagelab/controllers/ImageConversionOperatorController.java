package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;
import com.imagelab.operator.imageconversion.GrayscaleToBinary;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.ColoredToBinaryPropertiesForm;
import com.imagelab.view.forms.GrayscaleToBinaryPropertiesForm;

public class ImageConversionOperatorController {
	public static OperatorUIElement convertToGrayScaleImageElement() {
		//ConvertGrayscale UI element.
		OperatorUIElement convertToGrayScaleImage = new OperatorUIElement() {
		    @Override
		    public AbstractInformationUI buildInformationUI() {
		        return new InformationContainerView(ConvertToGrayscale
		                .Information.OPERATOR_INFO.toString());
		    }
		};
		convertToGrayScaleImage.operator = new ConvertToGrayscale();
		convertToGrayScaleImage.operatorId = ConvertToGrayscale.class.getCanonicalName();
		convertToGrayScaleImage.operatorName = "GRAY_IMAGE";
		convertToGrayScaleImage.elementStyleId = "grayscaleImage";
		convertToGrayScaleImage.buildElement();
		return convertToGrayScaleImage;

	}
	public static OperatorUIElement convertColoredImageToBinaryElement() {

		//convertColoredImageToBinary UI element.
		OperatorUIElement convertColoredImageToBinary = new OperatorUIElement() {
		    @Override
		    public AbstractInformationUI buildInformationUI() {
		        return new InformationContainerView(ColoredImageToBinary
		                .Information.OPERATOR_INFO.toString());
		    }

		    @Override
		    public AbstractPropertiesForm buildPropertiesFormUI() {
		        return new ColoredToBinaryPropertiesForm((ColoredImageToBinary) this.operator);
		    }
		};
		convertColoredImageToBinary.operator = new ColoredImageToBinary();
		convertColoredImageToBinary.operatorId = ColoredImageToBinary.class.getCanonicalName();
		convertColoredImageToBinary.operatorName = "COLOR-TO-BINARY";
		convertColoredImageToBinary.elementStyleId = "coloredToBinary";
		convertColoredImageToBinary.buildElement();
		return convertColoredImageToBinary;
	}
	public static OperatorUIElement convertGrayImageToBinaryElement() {
		//convertGrayImageToBinary UI element.
		OperatorUIElement convertGrayImageToBinary = new OperatorUIElement() {
		    @Override
		    public AbstractInformationUI buildInformationUI() {
		        return new InformationContainerView(GrayscaleToBinary
		                .Information.OPERATOR_INFO.toString());
		    }

		    @Override
		    public AbstractPropertiesForm buildPropertiesFormUI() {
		        return new GrayscaleToBinaryPropertiesForm((GrayscaleToBinary) this.operator);
		    }
		};
		convertGrayImageToBinary.operator = new GrayscaleToBinary();
		convertGrayImageToBinary.operatorId = GrayscaleToBinary.class.getCanonicalName();
		convertGrayImageToBinary.operatorName = "GRAY-TO-BINARY";
		convertGrayImageToBinary.elementStyleId = "grayToBinary";
		convertGrayImageToBinary.buildElement();
		return convertGrayImageToBinary;
	}
}
