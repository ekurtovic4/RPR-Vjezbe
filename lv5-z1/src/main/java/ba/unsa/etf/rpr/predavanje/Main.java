package ba.unsa.etf.rpr.predavanje;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LicneInformacije l1 = new LicneInformacije();
        for(int i = 0; i < 4; i++){
            l1.setIme("ime" + i);
            l1.setPrezime("prezime" + i);
            System.out.println(l1.getIme());
            System.out.println(l1.getPrezime());
        }

        InformacijeONastavniku n = new InformacijeONastavniku();
        System.out.println("Unesi ime nastavnika: ");
        Scanner ulaz = new Scanner(System.in);
        n.setIme(ulaz.nextLine());
        System.out.println("Unesi prezime nastavnika: ");
        n.setPrezime(ulaz.nextLine());
        System.out.println("Unesi titulu nastavnika: ");
        n.setTitula(ulaz.nextLine());
        System.out.println(n.predstavi());

        InformacijeOStudentu s = new InformacijeOStudentu();
        System.out.println("Unesi ime studenta: ");
        s.setIme(ulaz.nextLine());
        System.out.println("Unesi prezime studenta: ");
        s.setPrezime(ulaz.nextLine());
        System.out.println("Unesi godinu studija: ");
        s.setGodinaStudija(ulaz.nextLine());
        System.out.println("Unesi broj indeksa: ");
        s.setBrojIndexa(ulaz.nextLine());
        System.out.println(s.predstavi());
    }
}