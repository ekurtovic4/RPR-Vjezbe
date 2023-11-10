package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao{
    private File file = new File("laptopi.xml");
    private ArrayList<Laptop> laptopi = new ArrayList<>();
    public void dodajLaptopUListu(Laptop laptop){
        laptopi.add(laptop);
    }
    public void dodajLaptopUFile(Laptop laptop){
        laptopi.add(laptop);
        try{
            XmlMapper xm = new XmlMapper();
            xm.writeValue(file, laptopi);
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
            XmlMapper xm = new XmlMapper();
            l = xm.readValue(file, new TypeReference<ArrayList<Laptop>>(){});
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        return l;
    }
}
