package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;

public class KolekcijaPoruka {
    private ArrayList<String> poruke = new ArrayList<>();
    public ArrayList<String> getPoruke() {
        return poruke;
    }
    public KolekcijaPoruka(ArrayList<Predstavljanje> l){
        for(Predstavljanje p : l)
            poruke.add(p.predstavi());
    }
}
