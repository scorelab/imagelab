package com.imagelab.views.forms;

import com.imagelab.operators.basic.ReadImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Read image properties form view.
 */
public class ReadImgPropertiesForm extends AbstractPropertiesFormUI {
    /**
     * Builds the ReadImgPropertiesForm.
     *
     * @param operator - operator which requires this properties form.
     */
    public ReadImgPropertiesForm(ReadImage operator) {
        setPrefSize(224.0, 523.0);
        //Read Image Properties Title.
        PropertiesFormTitleContainer readImgTitleContainer;
        readImgTitleContainer = new PropertiesFormTitleContainer("Read Image Properties");

        Label lblSelectImage = new Label("Select Image");

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
        //Read image properties container.
        VBox readImgPropertiesContainer = new VBox();
        readImgPropertiesContainer.setPrefSize(205.0, 47.0);
        readImgPropertiesContainer.setLayoutX(14.0);
        readImgPropertiesContainer.setLayoutY(14.0);
        readImgPropertiesContainer.setSpacing(20.0);
        readImgPropertiesContainer.getChildren().addAll(readImgTitleContainer, imageURLContainer);
        getChildren().addAll(readImgPropertiesContainer);
    }
}
