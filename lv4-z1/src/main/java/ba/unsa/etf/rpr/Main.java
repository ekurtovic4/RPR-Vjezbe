package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //testni program za LaptopDaoSerializableFile
        LaptopDaoSerializableFile ls = new LaptopDaoSerializableFile();
        ls.dodajLaptopUFile(new Laptop("b", "m", 100, 1, 2, 3, "p", "g", 10));
        ls.dodajLaptopUFile(new Laptop("b1", "m1", 101, 11, 21, 31, "p1", "g1", 11));
        ArrayList<Laptop> lista = ls.vratiPodatkeIzDatoteke();
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
        ls.dodajLaptopUListu(new Laptop("b2", "m2", 121, 41, 91, 32, "p2", "g2", 21));
        ls.dodajLaptopUFile(new Laptop("b3", "m3", 151, 331, 181, 81, "p3", "g3", 13));
        lista = ls.vratiPodatkeIzDatoteke();
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
        try{
            ls.getLaptop("p2");
            System.out.println("Nadjen");
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        try{
            ls.getLaptop("pp");
            System.out.println("Nadjen");
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        System.out.println();

        //testni program za LaptopDaoJSONFile
        LaptopDaoJSONFile lj = new LaptopDaoJSONFile();
        lj.dodajLaptopUFile(new Laptop("b10", "m10", 200, 9, 8, 66, "p10", "g10", 90));
        lj.dodajLaptopUFile(new Laptop("b11", "m11", 102, 51, 61, 81, "p11", "g11", 221));
        lista = lj.vratiPodatkeIzDatoteke();
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
        lj.dodajLaptopUListu(new Laptop("b21", "m21", 1211, 141, 911, 42, "p21", "g21", 661));
        lj.dodajLaptopUFile(new Laptop("b31", "m31", 1151, 131, 81, 41, "p31", "g31", 253));
        lista = lj.vratiPodatkeIzDatoteke();
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
        try{
            lj.getLaptop("p");
            System.out.println("Nadjen");
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        try{
            lj.getLaptop("p31");
            System.out.println("Nadjen");
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        System.out.println();

        //testni program za LaptopDaoXMLFile
        LaptopDaoXMLFile lx = new LaptopDaoXMLFile();
        lx.dodajLaptopUFile(new Laptop("b121", "m1330", 456, 14, 26, 37, "p546", "g546", 660));
        lx.dodajLaptopUFile(new Laptop("b196", "m29", 29, 92, 81, 71, "p123", "g682", 19));
        lista = lx.vratiPodatkeIzDatoteke();
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
        lx.dodajLaptopUListu(new Laptop("b2882", "m247", 1991, 105, 64, 322, "p234", "g211", 26));
        lx.dodajLaptopUFile(new Laptop("b373", "m74643", 1201, 321, 871, 851, "p4443", "g873", 15));
        lista = lx.vratiPodatkeIzDatoteke();
        for (Laptop laptop : lista)
            System.out.println(laptop.getBrend());
        try{
            lx.getLaptop("p546");
            System.out.println("Nadjen");
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        try{
            lx.getLaptop("p235");
            System.out.println("Nadjen");
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        System.out.println();
    }
}
