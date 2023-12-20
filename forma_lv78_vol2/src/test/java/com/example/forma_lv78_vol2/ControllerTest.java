package com.example.forma_lv78_vol2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static javafx.scene.control.PopupControl.USE_PREF_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
@ExtendWith(ApplicationExtension.class)

public class ControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        Controller ctrl = new Controller(model);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("forma.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        Scene scene = new Scene(root, USE_PREF_SIZE, USE_PREF_SIZE);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.toFront();
    }

    @Test
    void testDodaj1(FxRobot robot) {
        TextField korImeField = robot.lookup("#korImeField").queryAs(TextField.class);
        robot.clickOn("#korImeField");
        robot.write("anonymous");
        robot.clickOn("#dodajButton");
        assertEquals("", korImeField.getText());
    }

    @Test
    void testDodaj2(FxRobot robot) {
        TextField imeField = robot.lookup("#imeField").queryAs(TextField.class);
        robot.clickOn("#dodajButton");
        robot.clickOn("#imeField");
        robot.write("nekoime");
        assertEquals("nekoime", imeField.getText());
    }

    @Test
    void testDodaj3(FxRobot robot) {
        TextField korImeField = robot.lookup("#korImeField").queryAs(TextField.class);
        robot.clickOn("#dodajButton");
        robot.clickOn("#imeField");
        robot.write("nekoime");
        robot.clickOn("#prezimeField");
        robot.write("nekoprezime");
        robot.clickOn("#korImeField");
        robot.write("imeprezime");
        robot.clickOn("#dodajButton");
        robot.clickOn("#listaKorisnika").clickOn("Korisnik 1");
        robot.clickOn("#listaKorisnika").clickOn("nekoime nekoprezime");
        assertEquals("imeprezime", korImeField.getText());
    }

    @Test
    void testLista1(FxRobot robot) {
        TextField prezimeField = robot.lookup("#prezimeField").queryAs(TextField.class);
        robot.clickOn("#listaKorisnika").clickOn("Korisnik 1");
        assertEquals("1", prezimeField.getText());
    }

    @Test
    void testLista2(FxRobot robot) {
        TextField prezimeField = robot.lookup("#prezimeField").queryAs(TextField.class);
        robot.clickOn("#listaKorisnika").clickOn("Korisnik 3");
        robot.clickOn("#prezimeField").push(javafx.scene.input.KeyCode.CONTROL, javafx.scene.input.KeyCode.A).push(javafx.scene.input.KeyCode.BACK_SPACE);
        robot.write("Prezime");
        assertEquals("Prezime", prezimeField.getText());
    }

    @Test
    void testLista3(FxRobot robot) {
        TextField emailField = robot.lookup("#emailField").queryAs(TextField.class);
        robot.clickOn("#listaKorisnika").clickOn("Korisnik 3");
        robot.clickOn("#prezimeField").push(javafx.scene.input.KeyCode.CONTROL, javafx.scene.input.KeyCode.A).push(javafx.scene.input.KeyCode.BACK_SPACE);
        robot.write("Prezime");
        robot.clickOn("#dodajButton");
        robot.clickOn("#listaKorisnika").clickOn("Korisnik Prezime");
        assertEquals("email3", emailField.getText());
    }
}