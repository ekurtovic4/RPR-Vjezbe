package com.example.lv78;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    public TextField imeField;
    public TextField prezimeField;
    public TextField emailField;
    public TextField korImeField;
    public TextField lozinkaField;
    private KorisniciModel model;
    public ListView<Korisnik> listaKorisnika;

    public Controller(KorisniciModel m) {
        model = m;
    }

    @FXML
    public void initialize(){
        imeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailField.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        korImeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        lozinkaField.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        listaKorisnika.setItems(model.getKorisnici());
        listaKorisnika.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik(newKorisnik);
            listaKorisnika.refresh();
        });
        model.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if(oldKorisnik != null){
                imeField.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                prezimeField.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                emailField.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                korImeField.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                lozinkaField.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
            }
            if(newKorisnik == null){
                imeField.setText("");
                prezimeField.setText("");
                emailField.setText("");
                korImeField.setText("");
                lozinkaField.setText("");
            }
            else{
                imeField.textProperty().bindBidirectional(newKorisnik.imeProperty());
                prezimeField.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                emailField.textProperty().bindBidirectional(newKorisnik.emailProperty());
                korImeField.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                lozinkaField.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
            }
        });
    }

    @FXML
    public void onDodajButtonClick(ActionEvent actionEvent){
        model.setTrenutniKorisnik(new Korisnik("", "", "", "", ""));
        model.dodajNovogKorisnika(model.getTrenutniKorisnik());
        listaKorisnika.refresh();
    }

    @FXML
    public void onKrajButtonClick(ActionEvent actionEvent){
        Platform.exit();
    }
}