module com.example.lab10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.lab10 to javafx.fxml;
    exports com.example.lab10;
    exports DAL;
}