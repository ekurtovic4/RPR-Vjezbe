package unsa.ba.etf.rpr.predavanje;

import java.util.Comparator;

public class MyComparator implements Comparator<TelefonskiBroj> {
    public int compare(TelefonskiBroj t1, TelefonskiBroj t2){
        return t1.ispisi().compareTo(t2.ispisi());
    }
}
