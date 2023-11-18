package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;

public class KolekcijaImenaIPrezimena implements Kolekcija{
    private ArrayList<String> imena = new ArrayList<>();
    private ArrayList<String> prezimena = new ArrayList<>();
    public int getIndexNajduzegPara(){
        int max = 0;
        for(int i = 0; i < imena.size(); i++){
            if(imena.get(i).length() + prezimena.get(i).length() >
                    imena.get(max).length() + prezimena.get(max).length())
                max = i;
        }
        return max;
    }
    public String getImeIPrezime(int i){
        if(i < 0 || i > imena.size()) return null;
        return imena.get(i) + " " + prezimena.get(i);
    }
    public void dodajUKolekciju(String ime, String prezime){
        imena.add(ime);
        prezimena.add(prezime);
    }

    @Override
    public String getMax() {
        return getImeIPrezime(getIndexNajduzegPara());
    }
}
