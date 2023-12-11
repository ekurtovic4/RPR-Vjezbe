package com.example.lv78;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {

    @Test
    void napuni() {
        KorisniciModel k = new KorisniciModel();
        k.napuni();
        ArrayList<Korisnik> l = new ArrayList<>(k.getKorisnici());
        assertEquals("korisnik1", l.get(0).getKorisnickoIme());
    }

    @Test
    void dodajNovogKorisnika() {
        Korisnik k = new Korisnik("ime", "prezime", "email", "korime", "1234");
        KorisniciModel km = new KorisniciModel();
        km.dodajNovogKorisnika(k);
        ArrayList<Korisnik> l = new ArrayList<>(km.getKorisnici());
        assertEquals("korime", l.get(0).getKorisnickoIme());
    }
}