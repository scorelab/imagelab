package com.imagelab;

import com.imagelab.operators.basic.ReadImage;
import com.imagelab.utils.Constants;
import com.imagelab.utils.Utilities;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencv.core.Core;

import java.io.IOException;

import static com.imagelab.utils.Constants.DASHBOARD_HEIGHT;
import static com.imagelab.utils.Constants.DASHBOARD_WIDTH;

/**
 * JavaFX App main class which creates the scene
 * for the UI and set the stage.
 */
public class App extends Application {

    private static Scene scene;

    /*
     * To load openCV libraries
     */
    static {
        nu.pattern.OpenCV.loadShared();
    }

    /**
     * To set the root for the created scene.
     *
     * @param fxml - the fxml to be set as root.
     * @throws IOException - errors related to setting the root.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * To load parent view from the fxml.
     *
     * @param fxml - fxml to be loaded.
     * @return - loaded fxml.
     * @throws IOException any errors
     *                     occurs between loading the fxml.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * main method of the application.
     *
     * @param args - arguments to run the app.
     */
    public static void main(String[] args) {
        // stack empty
        ReadImage readImage = new ReadImage();
        generateWelcomeMessage();
        launch();
    }

    /**
     * This method has been used to generate ASCII welcome message
     * and to make sure openCV configured version is running properly.
     */
    static void generateWelcomeMessage() {
        System.out.println("\n\n");
        Utilities.drawAsciiArt("Image Lab", 230, 20);
        System.out.println("\n" + Constants.IMAGELAB_VERSION);
        System.out.println("A project by " + Constants.ORG_INFO);
        System.out.println("OpenCV configured version " + Core.VERSION);
    }

    /**
     * Method which loads the UI from fxml resource and set the stylesheet.
     *
     * @param stage - stage which need to be showed.
     * @throws IOException - exceptions related loading stage.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("dashboard"), DASHBOARD_WIDTH, DASHBOARD_HEIGHT);
        scene.getStylesheets().add(getClass()
                .getResource(Constants.STYLESHEET_PATH).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
