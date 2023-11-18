package ba.unsa.etf.rpr.predavanje;

public class Predmet implements Predstavljanje{
    private String naziv, opis;
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Override
    public String predstavi() {
        return naziv + " - " + opis;
    }
}
