package ba.unsa.etf.rpr.predavanje;

import java.util.ArrayList;
import java.util.Objects;

public class InformacijeONastavniku extends LicneInformacije implements Predstavljanje, MozeOcijeniti{
    private String ime, prezime, titula;
    private ArrayList<Ocjena> ocjene = new ArrayList<>();
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

    @Override
    public Ocjena ocijeni(int x) {
        return new Ocjena(this, x);
    }

    public void dodajOcjenu(Ocjena o){
        ocjene.add(o);
    }

    public void ispisiOcjene(){
        System.out.println("    Ocjene:");
        for(Ocjena o : ocjene)
            o.ispisiOcjenu();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacijeONastavniku that = (InformacijeONastavniku) o;
        return Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(titula, that.titula);
    }
}
