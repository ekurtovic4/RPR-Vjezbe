package ba.unsa.etf.rpr.predavanje;

public class Predmet {
    private String naziv;
    private String odsjek;
    private Integer godina;
    public Predmet(){ naziv = "neki predmet"; odsjek = "odsjek"; godina = 2; }
    public Predmet(String n, String o, Integer g){ naziv = n; odsjek = o; godina = g; }
    public String dajSifru(){
        String s = odsjek + godina.toString() + naziv.charAt(0);
        for(int i = 0; i < naziv.length(); i++){
            if(naziv.charAt(i) == ' ' && i + 1 < naziv.length() && naziv.charAt(i + 1) != ' ')
                s = s + naziv.charAt(i + 1);
        }
        return s;
    }
}
