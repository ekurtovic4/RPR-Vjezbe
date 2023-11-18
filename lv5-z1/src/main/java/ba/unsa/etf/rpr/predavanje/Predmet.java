package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;

public class Predmet implements Predstavljanje{
    private String naziv, opis;
    private ArrayList<Ocjena> ocjene = new ArrayList<>();
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Override
    public String predstavi() {
        return naziv + " - " + opis;
    }

    public void dodajOcjenu(Ocjena o){
        ocjene.add(o);
    }

    public void ispisiOcjene(){
        System.out.println("    Ocjene:");
        for(Ocjena o : ocjene)
            o.ispisiOcjenu();
    }

    Predmet copy(){
        Predmet p = new Predmet();
        p.setNaziv(naziv); p.setOpis(opis);
        return p;
    }
}
