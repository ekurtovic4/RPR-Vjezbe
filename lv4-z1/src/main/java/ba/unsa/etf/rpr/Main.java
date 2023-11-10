package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        LaptopDaoJSONFile lj = new LaptopDaoJSONFile();
        lj.dodajLaptopUFile(new Laptop("b", "m", 100, 1, 2, 3, "p", "g", 10));
        lj.dodajLaptopUFile(new Laptop("b1", "m1", 101, 11, 21, 31, "p1", "g1", 11));
        ArrayList<Laptop> lista = lj.vratiPodatkeIzDatoteke();
        System.out.println(lista.size());
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
    }
}
