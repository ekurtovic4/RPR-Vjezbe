package com.example.lv78;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni(){
        korisnici.add(new Korisnik("Korisnik", "1", "email1", "korisnik1", "password1"));
        korisnici.add(new Korisnik("Korisnik", "2", "email2", "korisnik2", "password2"));
        korisnici.add(new Korisnik("Korisnik", "3", "email3", "korisnik3", "password3"));
        korisnici.add(new Korisnik("Korisnik", "4", "email4", "korisnik4", "password4"));
        korisnici.add(new Korisnik("Korisnik", "5", "email5", "korisnik5", "password5"));
        trenutniKorisnik = new SimpleObjectProperty<>(new Korisnik("", "", "", "", ""));
    }

    public void dodajNovogKorisnika(Korisnik k){
        korisnici.add(k);
    }
}
