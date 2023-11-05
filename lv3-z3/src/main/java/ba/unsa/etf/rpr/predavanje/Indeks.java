package ba.unsa.etf.rpr.predavanje;

import java.util.Map;
import java.util.TreeMap;
public class Indeks {
    private String brojIndeksa;
    private Map<String, String> ocjene;
    public Indeks(){
        ocjene = new TreeMap<String, String>();
    }

    /*public void upisiOcjenu(Predmet p, Integer o){ //verzija koja je planirana da se koristi, moze sa spy
        ocjene.put(p.dajSifru(), o.toString());
    }*/

    public void upisiOcjenu(Predmet p, Integer o){ //verzija za kad se koristi samo mock u testu
        ocjene.put("abcd", o.toString());
    }

    public int dajBrojPolozenih(){ return ocjene.size(); }
}
