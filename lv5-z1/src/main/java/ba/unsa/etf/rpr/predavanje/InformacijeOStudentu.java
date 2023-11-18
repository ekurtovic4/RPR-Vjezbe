package ba.unsa.etf.rpr.predavanje;

public class InformacijeOStudentu extends LicneInformacije implements Predstavljanje, MozeOcijeniti{
    private String ime, prezime, godinaStudija, brojIndexa;

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

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
    @Override
    public String predstavi() {
        return ime + " " + prezime + " - " + godinaStudija + ", " + brojIndexa;
    }

    @Override
    public Ocjena ocijeni(int x) {
        return new Ocjena(this, x);
    }
}
