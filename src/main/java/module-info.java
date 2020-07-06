module com.imagelab {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencvjar;

    opens com.imagelab to javafx.fxml;
    exports com.imagelab;
}
