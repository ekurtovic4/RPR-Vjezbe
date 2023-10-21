package ba.unsa.etf.rpr.predavanje02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unesi 2 broja: ");
        int a, b;
        Scanner ulaz = new Scanner(System.in);
        a = ulaz.nextInt();
        b = ulaz.nextInt();
        System.out.println("prvi broj: " + a);
        System.out.println("drugi broj: " + b);
    }
}
