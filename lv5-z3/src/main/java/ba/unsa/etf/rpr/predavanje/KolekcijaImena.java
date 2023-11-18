package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;

public class KolekcijaImena implements Kolekcija{
    private ArrayList<String> imena = new ArrayList<>();
    public String getNajduzeIme(){
        int max = 0;
        for(int i = 0; i < imena.size(); i++)
            if(imena.get(i).length() > imena.get(max).length()) max = i;
        return imena.get(max);
    }
    public void dodajUKolekciju(String s){
        imena.add(s);
    }

    @Override
    public String getMax() {
        return getNajduzeIme();
    }
}
