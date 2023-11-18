package ba.unsa.etf.rpr.predavanje;

public class Pobjednik {
    private String ime, prezime;
    private int brojZnakova;
    private Kolekcija kolekcijaImena;
    public Pobjednik(Kolekcija k){
        kolekcijaImena = k;
        String s = k.getMax();
        ime = s.substring(0, s.indexOf(' '));
        prezime = s.substring(s.indexOf(' ') + 1);
        brojZnakova = ime.length();
    }
    public String dajImePobjednika(){
        return ime + " " + prezime;
    }
}
