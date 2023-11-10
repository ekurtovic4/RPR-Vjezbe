package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file = new File("laptopi.txt");
    private ArrayList<Laptop> laptopi = new ArrayList<>();
    public void dodajLaptopUListu(Laptop laptop){
        laptopi.add(laptop);
    }
    public void dodajLaptopUFile(Laptop laptop){
        laptopi.add(laptop);
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(laptopi);
            out.close();
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
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            l = (ArrayList<Laptop>)in.readObject();
            in.close();
        }
        catch(Exception e){
            System.out.println("Greska: " + e);
        }
        return l;
    }
}
