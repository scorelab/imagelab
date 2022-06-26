package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.ReadImgPropertiesForm;
import com.imagelab.view.forms.WriteImgPropertiesForm;

public class BasicOperatorController{

		//ReadImage UI element.
		public static OperatorUIElement readImageElement() {
			OperatorUIElement readImage = new OperatorUIElement() {
	            @Override
	            public AbstractInformationUI buildInformationUI() {
	                return new InformationContainerView(ReadImage
	                        .Information.OPERATOR_INFO.toString());
	            }

	            @Override
	            public AbstractPropertiesForm buildPropertiesFormUI() {
	                return new ReadImgPropertiesForm((ReadImage) this.operator);
	            }
	        };
	        readImage.operator = new ReadImage();
	        readImage.operatorId = ReadImage.class.getCanonicalName();
	        readImage.operatorName = "READ_IMAGE";
	        readImage.elementStyleId = "readImage";
	        readImage.buildElement();
			return readImage;
		}
		
		//WriteImage UI element
		public static OperatorUIElement writeImageElement() {
			OperatorUIElement writeImage = new OperatorUIElement() {
	            @Override
	            public AbstractInformationUI buildInformationUI() {
	                return new InformationContainerView(WriteImage
	                        .Information.OPERATOR_INFO.toString());
	            }

	            @Override
	            public AbstractPropertiesForm buildPropertiesFormUI() {
	                return new WriteImgPropertiesForm((WriteImage) this.operator);
	            }
	        };
	        writeImage.operator = new WriteImage();
	        writeImage.operatorId = WriteImage.class.getCanonicalName();
	        writeImage.operatorName = "WRITE_IMAGE";
	        writeImage.elementStyleId = "writeImage";
	        writeImage.buildElement();
	        return writeImage;

		}

}
