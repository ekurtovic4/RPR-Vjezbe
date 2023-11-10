package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.io.File;

class LaptopDaoXMLFileTest {
    @Test
    void dodajLaptopUFile(){
        LaptopDaoXMLFile lx = new LaptopDaoXMLFile();
        lx.dodajLaptopUFile(Mockito.mock(Laptop.class)); //koristen Mocking kako bi se provjerilo da li ispravno radi dodavanje u file
                                                         //"laptopi.xml" u klasi LaptopDaoXMLFile, neovisno o klasi Laptop
        File f = new File("laptopi.xml");
        assertTrue(f.length() != 0);
    }
}