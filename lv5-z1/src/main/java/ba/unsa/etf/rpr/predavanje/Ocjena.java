package ba.unsa.etf.rpr.predavanje;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena = 0;
    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        this.ocjena = ocjena;
    }
    public void setOcjena(int ocjena) {
        if(ocjena > 0 && ocjena < 10)
            this.ocjena = ocjena;
    }
    public void ispisiOcjenu(){
        System.out.println("    " + osoba.predstavi() + " -> " + ocjena);
    }
}
