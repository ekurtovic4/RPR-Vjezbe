package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoJSONFileTest {
    @Test
    void getLaptop(){
        LaptopDaoJSONFile lj = new LaptopDaoJSONFile();
        lj.dodajLaptopUListu(new Laptop("b", "m", 100, 1, 2, 3, "p", "g", 10));
        assertDoesNotThrow(()->{lj.getLaptop("p");});
    }

    @Test
    void napuniListu() throws NeodgovarajuciProcesorException {
        ArrayList<Laptop> l = new ArrayList<>();
        l.add(new Laptop("b", "m", 100, 1, 2, 3, "p", "g", 10));
        LaptopDaoJSONFile lj = new LaptopDaoJSONFile();
        lj.napuniListu(l);
        assertEquals("m", lj.getLaptop("p").getModel());
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        LaptopDaoJSONFile lj = new LaptopDaoJSONFile();
        for(int i = 0; i < 10; i++)
            lj.dodajLaptopUFile(new Laptop("b121", "m1330", 456, 14, 26, 37, "p546", "g546", 660));
        ArrayList<Laptop> l = lj.vratiPodatkeIzDatoteke();
        assertEquals(10, l.size());
    }
}