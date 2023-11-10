package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {

    @Test
    void getLaptop() {
        LaptopDaoSerializableFile ls = new LaptopDaoSerializableFile();
        ls.dodajLaptopUFile(new Laptop("b10", "m10", 200, 9, 8, 66, "p10", "g10", 90));
        ls.dodajLaptopUFile(new Laptop("b21", "m21", 1211, 141, 911, 42, "p21", "g21", 661));
        assertThrows(NeodgovarajuciProcesorException.class, ()->{ls.getLaptop("p111");});
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        LaptopDaoSerializableFile ls = new LaptopDaoSerializableFile();
        ls.dodajLaptopUFile(new Laptop("b10", "m10", 200, 9, 8, 66, "p10", "g10", 90));
        ls.dodajLaptopUFile(new Laptop("b21", "m21", 1211, 141, 911, 42, "p21", "g21", 661));
        ArrayList<Laptop> l = ls.vratiPodatkeIzDatoteke();
        assertEquals(2, l.size());
    }
}