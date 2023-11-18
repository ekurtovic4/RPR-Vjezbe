package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Predmet> predmeti = new ArrayList<>();
        Predmet p = new Predmet();
        p.setNaziv("RPR"); p.setOpis("java");
        predmeti.add(p.copy());
        p.setNaziv("ASP"); p.setOpis("algoritmi");
        predmeti.add(p.copy());
        p.setNaziv("OBP"); p.setOpis("baze");
        predmeti.add(p.copy());
        p.setNaziv("NA"); p.setOpis("algoritmi");
        predmeti.add(p.copy());
        p.setNaziv("DM"); p.setOpis("matematika");
        predmeti.add(p.copy());
        p.setNaziv("LD"); p.setOpis("logicka kola");
        predmeti.add(p.copy());

        ArrayList<InformacijeONastavniku> nastavnici = new ArrayList<>();
        InformacijeONastavniku nast = new InformacijeONastavniku();
        nast.setIme("IME");
        nast.setPrezime("PREZIME");
        nast.setTitula("TITULA");
        nastavnici.add(nast);

        for(int i = 0; i < 3; i++){
            System.out.print("Da li ocjenjujete kao nastavnik (1) ili kao student(2)? ");
            Scanner ulaz = new Scanner(System.in);
            int n = ulaz.nextInt();
            if(n == 1){
                ulaz.nextLine();
                InformacijeONastavniku nastavnik = new InformacijeONastavniku();
                System.out.print("Unesite ime: ");
                nastavnik.setIme(ulaz.nextLine());
                System.out.print("Unesite prezime: ");
                nastavnik.setPrezime(ulaz.nextLine());
                System.out.print("Unesite titulu: ");
                nastavnik.setTitula(ulaz.nextLine());
                boolean exists = false;
                for(var x : nastavnici)
                    if (x.equals(nastavnik)) {
                        exists = true;
                        break;
                    }
                if(!exists) nastavnici.add(nastavnik);

                System.out.println("Koji predmet zelite ocijeniti?");
                for(int j = 0; j < predmeti.size(); j++){
                    System.out.println(j + " " + predmeti.get(j).getNaziv());
                }
                n = ulaz.nextInt();
                System.out.print("Unesite ocjenu: ");
                int x = ulaz.nextInt();
                if(n >= 0 && n < predmeti.size())
                    predmeti.get(n).dodajOcjenu(nastavnik.ocijeni(x));
            }
            else if(n == 2){
                ulaz.nextLine();
                InformacijeOStudentu student = new InformacijeOStudentu();
                System.out.print("Unesite ime: ");
                student.setIme(ulaz.nextLine());
                System.out.print("Unesite prezime: ");
                student.setPrezime(ulaz.nextLine());
                System.out.print("Unesite godinu studija: ");
                student.setGodinaStudija(ulaz.nextLine());
                System.out.print("Unesite broj indexa: ");
                student.setBrojIndexa(ulaz.nextLine());

                System.out.print("Da li zelite ocijeniti predmet (1) ili nastavnika(2)? ");
                n = ulaz.nextInt();
                if(n == 1){
                    System.out.println("Koji predmet zelite ocijeniti?");
                    for(int j = 0; j < predmeti.size(); j++){
                        System.out.println(j + " " + predmeti.get(j).getNaziv());
                    }
                    n = ulaz.nextInt();
                    System.out.print("Unesite ocjenu: ");
                    int x = ulaz.nextInt();
                    if(n >= 0 && n < predmeti.size())
                        predmeti.get(n).dodajOcjenu(student.ocijeni(x));
                }
                else if(n == 2){
                    System.out.println("Kojeg nastavnika zelite ocijeniti?");
                    for(int j = 0; j < nastavnici.size(); j++){
                        System.out.println(j + " " + nastavnici.get(j).predstavi());
                    }
                    n = ulaz.nextInt();
                    System.out.print("Unesite ocjenu: ");
                    int x = ulaz.nextInt();
                    if(n >= 0 && n < nastavnici.size())
                        nastavnici.get(n).dodajOcjenu(student.ocijeni(x));
                }
            }
        }

        System.out.println("Ocjene predmeta: ");
        for(var x : predmeti){
            System.out.println(x.predstavi());
            x.ispisiOcjene();
        }

        System.out.println();
        System.out.println("Ocjene nastavnika: ");
        for(var x : nastavnici){
            System.out.println(x.predstavi());
            x.ispisiOcjene();
        }
    }
}