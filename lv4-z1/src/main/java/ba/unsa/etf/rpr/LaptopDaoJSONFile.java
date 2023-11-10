package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao{
    private File file = new File("laptopi.json");
    private ArrayList<Laptop> laptopi = new ArrayList<>();
    public void dodajLaptopUListu(Laptop laptop){
        laptopi.add(laptop);
    }
    public void dodajLaptopUFile(Laptop laptop){
        laptopi.add(laptop);
        try{
            ObjectMapper om = new ObjectMapper();
            om.writeValue(file, laptopi);
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
    }
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi)
            if (laptop.getProcesor().equals(procesor))
                return laptop;
        throw new NeodgovarajuciProcesorException("Nema laptopa s navedenim procesorom");
    }
    public void napuniListu(ArrayList<Laptop> laptopi){
        this.laptopi = laptopi;
    }
    public ArrayList<Laptop> vratiPodatkeIzDatoteke(){
        ArrayList<Laptop> l = new ArrayList<>();
        try{
            ObjectMapper om = new ObjectMapper();
            l = om.readValue(file, new TypeReference<ArrayList<Laptop>>(){});
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        return l;
    }
}
