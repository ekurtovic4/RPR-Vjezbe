package unsa.ba.etf.rpr.predavanje;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{
    int mreza;
    String br;
    MobilniBroj(int mobilnaMreza, String broj){
        mreza = mobilnaMreza; br = broj;
    }
    @Override
    public String ispisi(){
        return "0" + mreza + "/" + br.substring(0, 3) + "-"
                + br.substring(3);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilniBroj that = (MobilniBroj) o;
        return mreza == that.mreza && Objects.equals(br, that.br);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mreza, br);
    }
    @Override
    public Grad getGrad(){ //funkcije za pretragu imenika na osnovu grada su samo za fiksne brojeve
        return null;
    }
}
