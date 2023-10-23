package ba.unsa.etf.rpr.predavanje;

public class Faktorijel {
    public static int faktorijel(int x){
        int rez = 1;
        for(int i = 2; i <= x; i++) rez = rez * i;
        return rez;
    }
}
