package com.example.lab10;

import DAL.Drzava;
import DAL.GeografijaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.BreakIterator;
import java.util.List;

import static java.lang.Math.floor;

public class GradController {
    @FXML
    public TextField fieldNaziv;
    @FXML
    public TextField fieldBrojStanovnika;
    @FXML
    public ChoiceBox<String> choiceDrzava;
    @FXML
    public Button btnOk;
    @FXML
    public Button btnCancel;
    private ObservableList<String> drzave = FXCollections.observableArrayList();
    private GeografijaDAO geografija;
    private GlavnaController glctrl;

    private boolean dodaj = false;
    private boolean izmijeni = false;
    private boolean obrisi = false;

    public boolean isDodaj() {
        return dodaj;
    }

    public void setDodaj(boolean dodaj) {
        this.dodaj = dodaj;
    }

    public boolean isIzmijeni() {
        return izmijeni;
    }

    public void setIzmijeni(boolean izmijeni) {
        this.izmijeni = izmijeni;
    }

    public boolean isObrisi() {
        return obrisi;
    }

    public void setObrisi(boolean obrisi) {
        this.obrisi = obrisi;
    }

    public GradController(GeografijaDAO geo){
        geografija = geo;
    }
    public GradController(GeografijaDAO geo, GlavnaController glctrl){
        geografija = geo;
        this.glctrl = glctrl;
    }

    @FXML
    public void initialize(){
        List<Drzava> tmp = geografija.drzave();
        for(var x : tmp){
            drzave.add(x.getNaziv());
        }
        choiceDrzava.setItems(drzave);
        choiceDrzava.setOnAction(event -> {
            izabranaDrzava();
        });

        fieldNaziv.textProperty().addListener((obs, oldDrzava, newDrzava) -> {
            if(fieldNaziv.getText().trim().isEmpty()){
                fieldNaziv.setStyle("-fx-control-inner-background: #ee8787;");
            }
            else{
                fieldNaziv.setStyle("-fx-control-inner-background: white;");
            }
        });

        fieldBrojStanovnika.textProperty().addListener((obs, oldBroj, newBroj) -> {
            String brStanovnika = fieldBrojStanovnika.getText();
            boolean neispravno = false;
            for(int i = 0; i < brStanovnika.length(); i++){
                if(!(brStanovnika.charAt(i) >= '0' && brStanovnika.charAt(i) <= '9')){
                    neispravno = true;
                    break;
                }
            }
            if(neispravno) fieldBrojStanovnika.setStyle("-fx-control-inner-background: #ee8787;");
            else fieldBrojStanovnika.setStyle("-fx-control-inner-background: white;");
        });

        fieldNaziv.textProperty().bindBidirectional(geografija.getTrenutniGrad().nazivProperty());

        fieldBrojStanovnika.textProperty().addListener((obs, oldBroj, newBroj) -> {
            if(fieldBrojStanovnika.getText().isEmpty())
                geografija.getTrenutniGrad().brojStanovnikaProperty().set(0);

            else{
                String brStanovnika = fieldBrojStanovnika.getText();
                boolean neispravno = false;
                for(int i = 0; i < brStanovnika.length(); i++){
                    if(!(brStanovnika.charAt(i) >= '0' && brStanovnika.charAt(i) <= '9')){
                        neispravno = true;
                        break;
                    }
                }

                if(!neispravno) geografija.getTrenutniGrad().brojStanovnikaProperty().set(Integer.parseInt(newBroj));
            }
        });
        geografija.getTrenutniGrad().brojStanovnikaProperty().addListener((obs, oldBroj, newBroj) -> {
            fieldBrojStanovnika.textProperty().set(newBroj.toString());
        });
    }
    @FXML
    public void izabranaDrzava(){
        geografija.getTrenutniGrad().setDrzava(choiceDrzava.getValue());
    }

    @FXML
    public void onBtnOkClick(){
        try{
            if(isDodaj()){
                geografija.dodajGrad(geografija.getTrenutniGrad());
            }
            else if(isIzmijeni()){
                geografija.izmijeniGrad(geografija.getTrenutniGrad());
            }
            else if(isObrisi()){
                geografija.obrisiGrad(geografija.getTrenutniGrad().getNaziv());
            }
        }
        catch (org.sqlite.SQLiteException e) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Constraint Violation");
            alert.setContentText(e.getMessage());
            alert.showAndWait().ifPresent((btnType) -> {
                System.out.println();
            });
        }
    }
    @FXML
    public void onBtnCancelClick(ActionEvent event){
        glctrl.refreshTableViewGradovi();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
