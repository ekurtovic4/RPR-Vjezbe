package ba.unsa.etf.rpr.predavanje;

import java.util.List;
import java.lang.Math;
public class StandardnaDevijacija {
    public static double sd(List<Integer> l){
        double sd = 0;
        double m = Mean.mean(l);
        for(var x : l)
            sd = sd + (x - m) * (x - m);
        sd = sd / l.size();
        sd = Math.sqrt(sd);
        return sd;
    }
}
