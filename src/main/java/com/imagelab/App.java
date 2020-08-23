package com.imagelab;

import com.imagelab.operators.basic.ReadImage;
import com.imagelab.utils.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

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
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        nu.pattern.OpenCV.loadShared();
    }

    /**
     * To set the root for the created scene.
     *
     * @param fxml The fxml related to the root.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * To load parent view from the fxml
     *
     * @param fxml The fxml related to the parent.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // stack empty
        ReadImage readImage = new ReadImage();

        testOpenCVConfig();
        launch();
    }

    /**
     * This method is to make sure the loaded openCV libraries are working
     * within the project
     * <p>
     * Note: this can be removed once the openCV related operations are developed
     */
    static void testOpenCVConfig() {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV Mat: " + m);
        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + m.dump());
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
        scene.getStylesheets().add(getClass().getResource(Constants.STYLESHEET_PATH).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
