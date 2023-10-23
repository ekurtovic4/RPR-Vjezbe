package ba.unsa.etf.rpr.predavanje;

public class Osoba {
    protected String ime;
    protected String prezime;
    Osoba(String x, String y){
        ime = x; prezime = y;
    }
    public String to_String(){
        return ime + prezime;
    }
}
