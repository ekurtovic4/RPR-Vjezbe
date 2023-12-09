package com.example.lv78;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forma.fxml"));
        fxmlLoader.setController(new Controller(model));
        Scene scene = new Scene(fxmlLoader.load(), 620, 400);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}