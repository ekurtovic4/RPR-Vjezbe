package ba.unsa.etf.rpr.predavanje;

public class InformacijeONastavniku extends LicneInformacije implements Predstavljanje{
    private String ime, prezime, titula;
    @Override
    public String getIme() {
        return ime;
    }

    @Override
    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String getPrezime() {
        return prezime;
    }

    @Override
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    @Override
    public String predstavi() {
        return ime + " " + prezime + ", " + titula;
    }
}
