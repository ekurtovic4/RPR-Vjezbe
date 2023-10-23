package ba.unsa.etf.rpr.predavanje;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        Scanner ulaz = new Scanner(System.in);
        while(true){
            System.out.println("Unesi broj: ");
            Integer broj = ulaz.nextInt();
            l.add(broj);
            System.out.println("Zelis li nastaviti s unosom?");
            ulaz.nextLine();
            String s = ulaz.nextLine();
            if(s.equals("stop")) break;
        }

        Integer min = l.get(0), max = l.get(0);
        for(int i = 1; i < l.size(); i++){
            if(l.get(i) < min) min = l.get(i);
            if(l.get(i) > max) max = l.get(i);
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Mean: " + Mean.mean(l));
        System.out.println("Standardna devijacija: " + StandardnaDevijacija.sd(l));
    }
}