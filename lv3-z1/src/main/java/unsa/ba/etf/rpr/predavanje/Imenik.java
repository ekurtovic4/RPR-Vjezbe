package unsa.ba.etf.rpr.predavanje;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;

public class Imenik {
    private HashMap<TelefonskiBroj, String> brojevi = new HashMap<>();
    public void dodaj(String ime, TelefonskiBroj broj){
        brojevi.put(broj, ime);
    }
    public String dajBroj(String ime) throws NotFoundException {
        for(Map.Entry<TelefonskiBroj, String> entry : brojevi.entrySet())
            if(ime.equals(entry.getValue()))
                return entry.getKey().ispisi();
        throw new NotFoundException("Ne postoji broj pod ovim imenom!");
    }
    public String dajIme(TelefonskiBroj broj) throws NotFoundException {
        if(brojevi.containsKey(broj))
            return brojevi.get(broj);
        throw new NotFoundException("Ne postoji ovaj broj u imeniku!");
    }
    public String naSlovo(char s){
        String r = new String();
        Integer brojac = 1;
        for(Map.Entry<TelefonskiBroj, String> entry : brojevi.entrySet())
            if(entry.getValue().indexOf(s) == 0){
                r = r + brojac.toString() + ". " + entry.getValue() + " - "
                        + entry.getKey().ispisi() + "\n";
                brojac++;
            }
        return r;
    }
    public Set<String> izGrada(Grad g){
        Set<String> s = new TreeSet<>();
        for(Map.Entry<TelefonskiBroj, String> entry : brojevi.entrySet())
            if(entry.getKey() instanceof FiksniBroj &&
                    g == entry.getKey().getGrad())
                s.add(entry.getValue());
        return s;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> s = new TreeSet<>(new MyComparator());
        for(Map.Entry<TelefonskiBroj, String> entry : brojevi.entrySet())
            if(entry.getKey() instanceof FiksniBroj &&
                    g == entry.getKey().getGrad())
                s.add(entry.getKey());
        return s;
    }
}


