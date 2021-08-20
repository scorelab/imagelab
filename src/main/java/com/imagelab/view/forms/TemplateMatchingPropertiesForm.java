package com.imagelab.view.forms;

import com.imagelab.operator.histogram.TemplateMatching;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TemplateMatchingPropertiesForm extends AbstractPropertiesForm {
	public TemplateMatchingPropertiesForm(TemplateMatching operator) {
		setPrefSize(224.0, 523.0);
        //Read Image Properties Title.
        PropertiesFormTitleContainer readImgTitleContainer;
        readImgTitleContainer = new PropertiesFormTitleContainer("Read Template Properties");

        Label lblSelectImage = new Label("Select Template");

        TextField imgURLTextField = new TextField(operator.getImageURL());
        imgURLTextField.setPrefSize(205.0, 27.0);

        Button btnBrowseImage = new Button("Browse");
        btnBrowseImage.setPrefWidth(85.0);

        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();

        EventHandler<ActionEvent> event = e -> {
            String filepath = fileChooser.showOpenDialog(stage).toString();
            operator.setImageURL(filepath);
            imgURLTextField.setText(filepath);
        };
        btnBrowseImage.setOnAction(event);

        VBox imageURLContainer = new VBox();
        imageURLContainer.setSpacing(10);
        imageURLContainer.getChildren().addAll(lblSelectImage, imgURLTextField, btnBrowseImage);
        
        // Matching Method Radio container
        VBox matchingMethodContainer = new VBox();
        matchingMethodContainer.setPrefWidth(205.0);
        matchingMethodContainer.setSpacing(10);
        //Different ColorMaps Choices.
        ToggleGroup matching_method = new ToggleGroup();
        
        RadioButton r1 = new RadioButton("TM_SQDIFF");
        RadioButton r2 = new RadioButton("TM_SQDIFF_NORMED");
        RadioButton r3 = new RadioButton("TM_CCORR");
        RadioButton r4 = new RadioButton("TM_CCORR_NORMED");
        RadioButton r5 = new RadioButton("TM_CCOEFF");
        RadioButton r6 = new RadioButton("TM_CCOFF_NORMED");
        
        r1.setToggleGroup(matching_method);
        r2.setToggleGroup(matching_method);
        r3.setToggleGroup(matching_method);
        r4.setToggleGroup(matching_method);
        r5.setToggleGroup(matching_method);
        r6.setToggleGroup(matching_method);
        
        // Matching method properties
        VBox matchingContainerRadio = new VBox(r1,r2,r3,r4,r5,r6);
        matchingContainerRadio.setPrefWidth(205.0);
        matchingContainerRadio.setSpacing(7);
        
        r1.setSelected(true);

        matching_method.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        	RadioButton selectedRadioButton =
                    (RadioButton) newValue;
            
            selectedRadioButton.setSelected(true);
            String toggleGroupValue = selectedRadioButton.getText();
            // Pass the value to Controller
            switch(toggleGroupValue) {
            	case "TM_SQDIFF" : operator.setMatchingMethodType(1);break;
            	case "TM_SQDIFF_NORMED" : operator.setMatchingMethodType(2);break;
            	case "TM_CCORR" : operator.setMatchingMethodType(3);break;
            	case "TM_CCORR_NORMED" : operator.setMatchingMethodType(4);break;
            	case "TM_CCOEFF" : operator.setMatchingMethodType(5);break;
            	case "TM_CCOEFF_NORMED": operator.setMatchingMethodType(6); break;
            }
        });
        
        //Read image properties container.
        VBox readImgPropertiesContainer = new VBox();
        readImgPropertiesContainer.setPrefSize(205.0, 47.0);
        readImgPropertiesContainer.setLayoutX(14.0);
        readImgPropertiesContainer.setLayoutY(14.0);
        readImgPropertiesContainer.setSpacing(20.0);
        readImgPropertiesContainer.getChildren().addAll(
        		readImgTitleContainer, 
        		imageURLContainer,
        		matchingMethodContainer,
        		matchingContainerRadio
        );
        getChildren().addAll(readImgPropertiesContainer);
    }
}
