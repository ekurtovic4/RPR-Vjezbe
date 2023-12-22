package DAL;

public class Drzava {
    private String naziv;
    private String glavni_grad;
    public Drzava(String n, String gg){
        naziv = n;
        glavni_grad = gg;
    }
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGlavni_grad() {
        return glavni_grad;
    }

    public void setGlavni_grad(String glavni_grad) {
        this.glavni_grad = glavni_grad;
    }
}
