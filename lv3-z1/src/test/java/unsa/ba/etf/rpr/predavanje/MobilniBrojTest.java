package unsa.ba.etf.rpr.predavanje;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobilniBrojTest {
    MobilniBroj m = new MobilniBroj(60, "356827");

    @Test
    void ispisi() {
        assertEquals("060/356-827", m.ispisi());
    }

    @Test
    void getGrad() {
        assertNull(m.getGrad());
    }
}