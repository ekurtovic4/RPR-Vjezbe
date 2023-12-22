package program;

import DAL.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static GeografijaDAO geo = GeografijaDAO.getInstance();

    public static void main(String[] args){
        System.out.println("Odaberi opciju:");
        System.out.println("1 -- ispis svih gradova");
        System.out.println("2 -- glavni grad neke drzave");
        System.out.println("3 -- brisanje drzave");
        System.out.println("4 -- dodavanje grada");
        System.out.println("5 -- dodavanje drzave");
        System.out.println("6 -- promjena grada");
        System.out.println("7 -- pronalazak drzave");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice == 1) ispisiGradove();
        else if(choice == 2) glavniGrad();
        else if(choice == 3) brisiDrzavu();
        else if(choice == 4) noviGrad();
        else if(choice == 5) novaDrzava();
        else if(choice == 6) promjenaGrada();
        else if(choice == 7) pronalazakDrzave();
        else System.out.println("Odabrana opcija nije validna");
    }
    public static String ispisiGradove(){
        ArrayList<Grad> gradovi = geo.gradovi();
        if(gradovi.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for(var x : gradovi){
            System.out.println(x.toString());
            sb.append(x);
        }
        return sb.toString();
    }
    public static void glavniGrad(){
        System.out.println("Unesi drzavu: ");
        Scanner input = new Scanner(System.in);
        String drzava = input.nextLine();
        Grad grad = geo.glavniGrad(drzava);
        if(grad == null)
            System.out.println("Nepostojeca drzava");
        else
            System.out.println("Glavni grad drzave " + drzava + " je " + grad.getNaziv());
    }
    public static void brisiDrzavu(){
        System.out.println("Unesi drzavu: ");
        Scanner input = new Scanner(System.in);
        String drzava = input.nextLine();
        geo.obrisiDrzavu(drzava);
    }
    public static void noviGrad(){
        System.out.println("Unesi grad: ");
        Scanner input = new Scanner(System.in);
        String grad = input.nextLine();
        System.out.println("Unesi broj stanovnika: ");
        int broj = input.nextInt();
        System.out.println("Unesi drzavu: ");
        if(input.hasNextLine()) input.nextLine();
        String drzava = input.nextLine();
        geo.dodajGrad(new Grad(grad, broj, drzava));
    }
    public static void novaDrzava(){
        System.out.println("Unesi drzavu: ");
        Scanner input = new Scanner(System.in);
        String drzava = input.nextLine();
        System.out.println("Unesi glavni grad: ");
        String glGrad = input.nextLine();
        geo.dodajDrzavu(new Drzava(drzava, glGrad));
    }
    public static void promjenaGrada(){
        System.out.println("Unesi grad: ");
        Scanner input = new Scanner(System.in);
        String grad = input.nextLine();
        System.out.println("Unesi broj stanovnika: ");
        int broj = input.nextInt();
        System.out.println("Unesi drzavu: ");
        if(input.hasNextLine()) input.nextLine();
        String drzava = input.nextLine();
        geo.izmijeniGrad(new Grad(grad, broj, drzava));
    }
    public static void pronalazakDrzave(){
        System.out.println("Unesi drzavu: ");
        Scanner input = new Scanner(System.in);
        String drzava = input.nextLine();
        Drzava d = geo.nadjiDrzavu(drzava);
        if(d == null)
            System.out.println("Drzava " + drzava + " nije nadjena");
        else
            System.out.println(d.getNaziv() + " - " + d.getGlavni_grad());
    }
}
