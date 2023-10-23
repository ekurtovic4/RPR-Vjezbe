package ba.unsa.etf.rpr.predavanje;

import java.util.List;

public class Banka {
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;
    protected Long brojRacuna;
    Banka(){}
    public Korisnik kreirajNovogKorisnika(String x, String y){
        return new Korisnik(x, y);
    }
    public Uposlenik kreirajNovogUposlenika(String x, String y){
        return new Uposlenik(x, y);
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k){
        Long x = 123L;
        return new Racun(x, k);
    }
}
