package ba.unsa.etf.rpr.predavanje;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class IndeksTest {
    //Predmet p = spy(new Predmet());

    @Test
    void upisiOcjenu() {
        Indeks i = new Indeks();
        i.upisiOcjenu(Mockito.mock(Predmet.class), 10);

        //i.upisiOcjenu(p, 10);
        
        assertEquals(1, i.dajBrojPolozenih());
    }
}
