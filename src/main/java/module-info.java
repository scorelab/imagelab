module com.imagelab {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.imagelab to javafx.fxml;
    exports com.imagelab;
}