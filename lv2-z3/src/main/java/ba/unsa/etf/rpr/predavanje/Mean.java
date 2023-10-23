package ba.unsa.etf.rpr.predavanje;

import java.util.List;
public class Mean {
    public static double mean(List<Integer> l){
        double mean = 0;
        for (var x : l) mean = mean + x;
        mean = mean / l.size();
        return mean;
    }
}
