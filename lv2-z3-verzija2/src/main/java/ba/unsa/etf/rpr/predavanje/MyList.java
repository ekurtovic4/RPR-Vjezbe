package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;
import java.lang.Math;

public class MyList<Integer> extends ArrayList<java.lang.Integer> {
    public double mean(){
        double mean = 0;
        for(var x : this) mean = mean + x;
        mean = mean / this.size();
        return mean;
    }
    public double sd(){
        double mean = mean();
        double sd = 0;
        for(var x : this)
            sd = sd + (x - mean) * (x - mean);
        sd = sd / this.size();
        sd = Math.sqrt(sd);
        return sd;
    }
    public java.lang.Integer min(){
        java.lang.Integer min = this.get(0);
        for(var x : this)
            if(x < min) min = x;
        return min;
    }
    public java.lang.Integer max(){
        java.lang.Integer max = this.get(0);
        for(var x : this)
            if(x > max) max = x;
        return max;
    }
}