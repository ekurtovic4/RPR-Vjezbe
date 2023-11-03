package unsa.ba.etf.rpr.predavanje;

import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Imenik im = new Imenik();
        int n = 0;
        do{
            System.out.println("Odaberi opciju: ");
            System.out.println("0---- Izlaz");
            System.out.println("1---- Dodaj fiksni broj");
            System.out.println("2---- Dodaj mobilni broj");
            System.out.println("3---- Dodaj medjunarodni broj");
            System.out.println("4---- Pretraga po fiksnom broju");
            System.out.println("5---- Pretraga po mobilnom broju");
            System.out.println("6---- Pretraga po medjunarodnom broju");
            System.out.println("7---- Pretraga po prvom slovu imena");
            System.out.println("8---- Pretraga po imenu");
            System.out.println("9---- Pretraga imena po gradu"); //samo za fiksne brojeve
            System.out.println("10---- Pretraga brojeva po gradu"); //samo za fiksne brojeve
            Scanner ulaz = new Scanner(System.in);
            n = ulaz.nextInt();

            if(n == 1){
                System.out.println("Odaberi grad: ");
                ispisiGradove();
                n = ulaz.nextInt();
                System.out.println("Unesi broj: ");
                ulaz.nextLine();
                String b = ulaz.nextLine();
                System.out.println("Unesi ime: ");
                String i = ulaz.nextLine();
                im.dodaj(i, new FiksniBroj(Grad.values()[n],b));
            }
            else if(n == 2){
                System.out.println("Unesi mrezu: ");
                n = ulaz.nextInt();
                System.out.println("Unesi broj: ");
                ulaz.nextLine();
                String b = ulaz.nextLine();
                System.out.println("Unesi ime: ");
                String i = ulaz.nextLine();
                im.dodaj(i, new MobilniBroj(n,b));
            }
            else if(n == 3){
                System.out.println("Unesi drzavu: ");
                ulaz.nextLine();
                String d = ulaz.nextLine();
                System.out.println("Unesi broj: ");
                String b = ulaz.nextLine();
                System.out.println("Unesi ime: ");
                String i = ulaz.nextLine();
                im.dodaj(i, new MedunarodniBroj(d,b));
            }
            else if(n == 4){
                System.out.println("Odaberi grad: ");
                ispisiGradove();
                n = ulaz.nextInt();
                System.out.println("Unesi broj: ");
                ulaz.nextLine();
                String b = ulaz.nextLine();
                try{
                    System.out.println(im.dajIme(new FiksniBroj(Grad.values()[n],b)));
                }
                catch(NotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(n == 5){
                System.out.println("Unesi mrezu: ");
                n = ulaz.nextInt();
                System.out.println("Unesi broj: ");
                ulaz.nextLine();
                String b = ulaz.nextLine();
                try{
                    System.out.println(im.dajIme(new MobilniBroj(n,b)));
                }
                catch(NotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(n == 6){
                System.out.println("Unesi drzavu: ");
                ulaz.nextLine();
                String d = ulaz.nextLine();
                System.out.println("Unesi broj: ");
                String b = ulaz.nextLine();
                try{
                    System.out.println(im.dajIme(new MedunarodniBroj(d,b)));
                }
                catch(NotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(n == 7){
                System.out.println("Unesi slovo: ");
                char c = ulaz.next().charAt(0);
                System.out.println(im.naSlovo(c));
            }
            else if(n == 8){
                System.out.println("Unesi ime: ");
                ulaz.nextLine();
                String i = ulaz.nextLine();
                try{
                    System.out.println(im.dajBroj(i));
                }
                catch(NotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(n == 9){
                System.out.println("Odaberi grad: ");
                ispisiGradove();
                n = ulaz.nextInt();
                Set<String> s = im.izGrada(Grad.values()[n]);
                for(String x : s) System.out.println(x);
            }
            else if(n == 10){
                System.out.println("Odaberi grad: ");
                ispisiGradove();
                n = ulaz.nextInt();
                Set<TelefonskiBroj> s = im.izGradaBrojevi(Grad.values()[n]);
                for(TelefonskiBroj x : s) System.out.println(x.ispisi());
            }
        }while(n != 0);
    }

    public static void ispisiGradove(){ //iz enuma Grad
        System.out.println("0 - Sarajevo");
        System.out.println("1 - Tuzla");
        System.out.println("2 - Zenica");
        System.out.println("3 - Bihac");
        System.out.println("4 - Mostar");
        System.out.println("5 - Brcko");
        System.out.println("6 - Travnik");
        System.out.println("7 - Orasje");
        System.out.println("8 - Livno");
        System.out.println("9 - Gorazde");
        System.out.println("10 - Siroki Brijeg");
        System.out.println("11 - Banja Luka");
    }
}