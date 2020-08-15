package com.imagelab.views.forms;

import com.imagelab.operators.WriteImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class WriteImgPropertiesForm extends AnchorPane {
    public WriteImgPropertiesForm(WriteImage operator) {
        setPrefSize(224.0, 523.0);

        //Write Image Properties Title
        PropertiesFormTitleContainer writeImgTitleContainer = new PropertiesFormTitleContainer("Write Image Properties");

        //Saving Image Name
        VBox saveImgNameContainer = new VBox();
        saveImgNameContainer.setPrefWidth(205.0);
        saveImgNameContainer.setSpacing(10);

        Label lblSaveImgName = new Label("Save as");

        TextField saveImgNameTextField = new TextField("ProcessedImage.jpg");
        saveImgNameTextField.setPrefSize(205, 27);

        saveImgNameContainer.getChildren().addAll(lblSaveImgName, saveImgNameTextField);

        //Saving Image Path
        VBox saveDirPathContainer = new VBox();
        saveImgNameContainer.setPrefWidth(205.0);
        saveDirPathContainer.setSpacing(10);

        Label lblSelectSaveDir = new Label("Select a directory to save");

        TextField saveDirTextField = new TextField(operator.getDestinationURL());
        saveDirTextField.setPrefSize(205, 27);

        Button btnBrowseImage = new Button("Browse");
        btnBrowseImage.setPrefWidth(85.0);

        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage stage = new Stage();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String selectedDir = directoryChooser.showDialog(stage).toString();
                if (selectedDir != null) {
                    operator.setDestinationURL(selectedDir);
                    String selectedSaveDir = selectedDir + "/" + saveImgNameTextField.getText();
                    operator.setDestinationURL(selectedSaveDir);
                    saveDirTextField.setText(selectedSaveDir);
                } else {
                    String defaultDir = "src/main/resources/com/imagelab/images/ProcessedImage.jpg";
                    System.err.println("No directory has been selected");
                    System.out.println("Saving to default directory: " + defaultDir);

                }

            }
        };

        btnBrowseImage.setOnAction(event);
        saveDirPathContainer.getChildren().addAll(lblSelectSaveDir, saveDirTextField, btnBrowseImage);

        VBox readImgPropertiesContainer = new VBox();
        readImgPropertiesContainer.setPrefSize(205, 47);
        readImgPropertiesContainer.setLayoutX(14);
        readImgPropertiesContainer.setLayoutY(14);
        readImgPropertiesContainer.setSpacing(20);
        readImgPropertiesContainer.getChildren().addAll(writeImgTitleContainer, saveImgNameContainer, saveDirPathContainer);

        getChildren().addAll(readImgPropertiesContainer);
    }
}
