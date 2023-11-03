package unsa.ba.etf.rpr.predavanje;
import java.util.Arrays;
import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    private Grad gr;
    private String br;
    public static String[] pozivni = new String[]{"033", "035", "032", "037", "036",
                    "049", "030", "031", "034", "038", "039", "051"}; //na osnovu grada (elemenata enuma Grad)
    public FiksniBroj(Grad grad, String broj){
        gr = grad; br = broj;
    }
    @Override
    public String ispisi(){
        return pozivni[gr.ordinal()] + "/" + br.substring(0, 3)
                + "-" + br.substring(3);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return gr == that.gr && Objects.equals(br, that.br) && Arrays.equals(pozivni, that.pozivni);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(gr, br);
        result = 31 * result + Arrays.hashCode(pozivni);
        return result;
    }
    @Override
    public Grad getGrad(){ return gr; }
}
