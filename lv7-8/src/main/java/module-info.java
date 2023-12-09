module com.example.lv78 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lv78 to javafx.fxml;
    exports com.example.lv78;
}