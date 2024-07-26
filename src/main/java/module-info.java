module com.lab5team1.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;
    requires java.desktop;


    opens com.lab5team1.app to javafx.fxml;
    exports com.lab5team1.app;
}