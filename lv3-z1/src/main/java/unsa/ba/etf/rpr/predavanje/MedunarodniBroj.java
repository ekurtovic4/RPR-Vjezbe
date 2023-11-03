package unsa.ba.etf.rpr.predavanje;

import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj{
    String dr, br;
    MedunarodniBroj(String drzava, String broj){
        dr = drzava; br = broj;
    }
    @Override
    public String ispisi(){
        return dr + br.substring(1, 3) + "/" + br.substring(3, 6)
                + "-" + br.substring(6);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedunarodniBroj that = (MedunarodniBroj) o;
        return Objects.equals(dr, that.dr) && Objects.equals(br, that.br);
    }
    @Override
    public int hashCode() {
        return Objects.hash(dr, br);
    }
    @Override
    public Grad getGrad(){ //funkcije za pretragu imenika na osnovu grada su samo za fiksne brojeve
        return null;
    }
}
