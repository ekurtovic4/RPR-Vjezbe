package ba.unsa.etf.rpr.predavanje;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Unesi broj: ");
        Scanner ulaz = new Scanner(System.in);
        int x = ulaz.nextInt();
        System.out.println("Sinus unesenog broja iznosi: " + Sinus.sinus(x));
        System.out.println("Faktorijel unesenog broja iznosi: " + Faktorijel.faktorijel(x));
    }
}
