package DAL;

public class Grad {
    private String naziv;
    private int broj_stanovnika;
    private String drzava;
    public Grad(String n, int b, String d){
        naziv = n;
        broj_stanovnika = b;
        drzava = d;
    }
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return naziv + " (" + drzava + ") - " + broj_stanovnika;
    }
}
