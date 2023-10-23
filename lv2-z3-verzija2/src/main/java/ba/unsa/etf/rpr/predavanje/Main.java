package ba.unsa.etf.rpr.predavanje;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> l = new MyList<>();
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
        System.out.println("Min: " + l.min());
        System.out.println("Max: " + l.max());
        System.out.println("Mean: " + l.mean());
        System.out.println("Standardna devijacija: " + l.sd());
    }
}