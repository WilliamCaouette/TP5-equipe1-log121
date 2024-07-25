module org.example.tp5_log121 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.tp5_log121 to javafx.fxml;
    exports org.tp5_log121;
}