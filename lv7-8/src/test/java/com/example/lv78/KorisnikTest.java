package com.example.lv78;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisnikTest {

    @Test
    void testToString() {
        Korisnik k = new Korisnik("ime", "prezime", "email", "korime", "1234");
        assertEquals("ime prezime", k.toString());
    }
}