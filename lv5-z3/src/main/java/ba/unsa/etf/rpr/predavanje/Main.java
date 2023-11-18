package ba.unsa.etf.rpr.predavanje;

public class Main {
    public static void main(String[] args) {
       KolekcijaImena k = new KolekcijaImena();
        k.dodajUKolekciju("ime1 prezime1");
        k.dodajUKolekciju("ime2 prez2");
        k.dodajUKolekciju("ime3 preeeziiimeee3");
        k.dodajUKolekciju("ime4 prz4");
        k.dodajUKolekciju("iiiimeeeeeeeeeeee5 prez5");

        Pobjednik p = new Pobjednik(k);
        System.out.println(p.dajImePobjednika());

        KolekcijaImenaIPrezimena k2 = new KolekcijaImenaIPrezimena();
        k2.dodajUKolekciju("i6", "p6");
        k2.dodajUKolekciju("iiimmmmmmmeeeeee7", "preeeeziiimmeee7");
        k2.dodajUKolekciju("ime8", "prz8");

        Pobjednik q = new Pobjednik(k2);
        System.out.println(q.dajImePobjednika());
    }
}