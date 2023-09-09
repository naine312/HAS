module com.example.has {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.media;
    requires java.desktop;

    opens com.example.has to javafx.fxml;
    exports com.example.has;
}