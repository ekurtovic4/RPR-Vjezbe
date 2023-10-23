package ba.unsa.etf.rpr.predavanje;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;
    public Racun(Long x, Osoba y){}
    private boolean provjeriOdobrenjePrekoracenja(Double x){ return true; }
    public boolean izvrsiUplatu(Double x){ return true; }
    public boolean izvrsiIsplatu(Double x){ return true; }
    public void odobriPrekoracenja(Double x){}
}
