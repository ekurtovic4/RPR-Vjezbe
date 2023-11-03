package unsa.ba.etf.rpr.predavanje;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiksniBrojTest {

    @Test
    void ispisi() {
        FiksniBroj f = new FiksniBroj(Grad.SARAJEVO, "433562");
        assertEquals("033/433-562", f.ispisi());
    }
}