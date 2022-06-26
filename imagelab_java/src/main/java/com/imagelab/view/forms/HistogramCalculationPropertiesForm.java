package com.imagelab.view.forms;

import javafx.scene.layout.VBox;

import com.imagelab.operator.histogram.HistogramCalculation;

import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HistogramCalculationPropertiesForm extends AbstractPropertiesForm {

	public HistogramCalculationPropertiesForm(HistogramCalculation operator){
		//Histogram Calculation title container.
		
        PropertiesFormTitleContainer HistoTitleContainer;
        HistoTitleContainer = new PropertiesFormTitleContainer("Histogram Analysis");
	
        /**
         * Dark image analysis 
         */
        Label lblDark = new Label("Dark Image Histogram");
        Image imageDark = new Image("file:src/main/resources/com/imagelab/images/dark.png");  
        
        //Setting the image view 
        ImageView imageViewDark = new ImageView(imageDark); 
        
        //Setting the position of the image 
        imageViewDark.setX(25); 
        imageViewDark.setY(25); 
        
        //setting the fit height and width of the image view 
        imageViewDark.setFitHeight(225); 
        imageViewDark.setFitWidth(200); 
        
        //Setting the preserve ratio of the image view 
        imageViewDark.setPreserveRatio(true);
        
        /**
         * Bright Image Analysis
         */
        Label lblBright = new Label("Bright Image Histogram");
        Image imageBright = new Image("file:src/main/resources/com/imagelab/images/bright.png");  
        
        //Setting the image view 
        ImageView imageViewBright = new ImageView(imageBright); 
        
        //Setting the position of the image 
        imageViewBright.setX(25); 
        imageViewBright.setY(25); 
        
        //setting the fit height and width of the image view 
        imageViewBright.setFitHeight(225); 
        imageViewBright.setFitWidth(200); 
        
        //Setting the preserve ratio of the image view 
        imageViewBright.setPreserveRatio(true);
        
        /**
         * High Contrast Image Analysis
         */
        Label lblHighContrast = new Label("High Contrast Histogram");
        Image imageHighContrast = new Image("file:src/main/resources/com/imagelab/images/highcontrast.png");  
        
        //Setting the image view 
        ImageView imageViewHC = new ImageView(imageHighContrast); 
        
        //Setting the position of the image 
        imageViewHC.setX(25); 
        imageViewHC.setY(25); 
        
        //setting the fit height and width of the image view 
        imageViewHC.setFitHeight(225); 
        imageViewHC.setFitWidth(200); 
        
        //Setting the preserve ratio of the image view 
        imageViewHC.setPreserveRatio(true);
        
        /**
         * Low Contrast Image Analysis
         */
        Label lblLowContrast = new Label("Low Contrast Histogram");
        Image imageLowContrast = new Image("file:src/main/resources/com/imagelab/images/lowcontrast.png");  
        
        //Setting the image view 
        ImageView imageViewLC = new ImageView(imageLowContrast); 
        
        //Setting the position of the image 
        imageViewLC.setX(25); 
        imageViewLC.setY(25); 
        
        //setting the fit height and width of the image view 
        imageViewLC.setFitHeight(225); 
        imageViewLC.setFitWidth(200); 
        
        //Setting the preserve ratio of the image view 
        imageViewLC.setPreserveRatio(true);
        
        VBox histogramImageAnalysisContainer = new VBox();
        histogramImageAnalysisContainer.setPrefWidth(300.0);
        histogramImageAnalysisContainer.setPrefHeight(300.0);
        histogramImageAnalysisContainer.setSpacing(10);
        histogramImageAnalysisContainer.getChildren().addAll(lblDark,imageViewDark,lblBright,imageViewBright,
        		lblHighContrast,imageViewHC,lblLowContrast,imageViewLC);
        
        
        VBox colorMapsPropertiesContainer = new VBox();
        colorMapsPropertiesContainer.setPrefSize(205, 47);
        colorMapsPropertiesContainer.setSpacing(20);
        colorMapsPropertiesContainer.setLayoutX(14);
        colorMapsPropertiesContainer.setLayoutY(14);
        colorMapsPropertiesContainer.getChildren().addAll(
        	HistoTitleContainer,
        	histogramImageAnalysisContainer
        );
        getChildren().addAll(colorMapsPropertiesContainer);
	}
}
