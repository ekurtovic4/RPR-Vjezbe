package unsa.ba.etf.rpr.predavanje;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
    Imenik im = new Imenik();

    @Test
    void dajBroj() {
        im.dodaj("aaa bbb", new FiksniBroj(Grad.SARAJEVO, "433562"));
        im.dodaj("jjdhbgf o", new MobilniBroj(63, "999101"));
        im.dodaj("gdt sdfkd", new FiksniBroj(Grad.SARAJEVO, "241597"));
        im.dodaj("abc xyz", new FiksniBroj(Grad.ZENICA, "900802"));
        im.dodaj("jkl mno", new MobilniBroj(60, "356827"));
        im.dodaj("zrurbe aatar", new MedunarodniBroj("+387", "033515220"));
        im.dodaj("fgtr twtw", new MedunarodniBroj("+387", "032777211"));

        try{
            assertEquals("033/433-562", im.dajBroj("aaa bbb"));
        }
        catch(NotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void dajIme() {
        im.dodaj("aaa bbb", new FiksniBroj(Grad.SARAJEVO, "433562"));
        im.dodaj("jjdhbgf o", new MobilniBroj(63, "999101"));
        im.dodaj("gdt sdfkd", new FiksniBroj(Grad.SARAJEVO, "241597"));
        im.dodaj("abc xyz", new FiksniBroj(Grad.ZENICA, "900802"));
        im.dodaj("jkl mno", new MobilniBroj(60, "356827"));
        im.dodaj("zrurbe aatar", new MedunarodniBroj("+387", "033515220"));
        im.dodaj("fgtr twtw", new MedunarodniBroj("+387", "032777211"));

        assertThrows(NotFoundException.class, ()->{im.dajIme(new FiksniBroj(Grad.MOSTAR, "009293"));});
    }

    @Test
    void naSlovo() {
        im.dodaj("aaa bbb", new FiksniBroj(Grad.SARAJEVO, "433562"));
        im.dodaj("jjdhbgf o", new MobilniBroj(63, "999101"));
        im.dodaj("gdt sdfkd", new FiksniBroj(Grad.SARAJEVO, "241597"));
        im.dodaj("abc xyz", new FiksniBroj(Grad.ZENICA, "900802"));
        im.dodaj("jkl mno", new MobilniBroj(60, "356827"));
        im.dodaj("zrurbe aatar", new MedunarodniBroj("+387", "033515220"));
        im.dodaj("fgtr twtw", new MedunarodniBroj("+387", "032777211"));

        assertEquals("1. zrurbe aatar - +38733/515-220\n", im.naSlovo('z'));
    }

    @Test
    void izGrada() {
        im.dodaj("aaa bbb", new FiksniBroj(Grad.SARAJEVO, "433562"));
        im.dodaj("jjdhbgf o", new MobilniBroj(63, "999101"));
        im.dodaj("gdt sdfkd", new FiksniBroj(Grad.SARAJEVO, "241597"));
        im.dodaj("abc xyz", new FiksniBroj(Grad.ZENICA, "900802"));
        im.dodaj("jkl mno", new MobilniBroj(60, "356827"));
        im.dodaj("zrurbe aatar", new MedunarodniBroj("+387", "033515220"));
        im.dodaj("fgtr twtw", new MedunarodniBroj("+387", "032777211"));

        Set<String> s = im.izGrada(Grad.ORASJE);
        assertTrue(s.isEmpty());
    }

    @Test
    void izGradaBrojevi() {
        im.dodaj("aaa bbb", new FiksniBroj(Grad.SARAJEVO, "433562"));
        im.dodaj("jjdhbgf o", new MobilniBroj(63, "999101"));
        im.dodaj("gdt sdfkd", new FiksniBroj(Grad.SARAJEVO, "241597"));
        im.dodaj("abc xyz", new FiksniBroj(Grad.ZENICA, "900802"));
        im.dodaj("jkl mno", new MobilniBroj(60, "356827"));
        im.dodaj("zrurbe aatar", new MedunarodniBroj("+387", "033515220"));
        im.dodaj("fgtr twtw", new MedunarodniBroj("+387", "032777211"));

        Set<TelefonskiBroj> s = im.izGradaBrojevi(Grad.ORASJE);
        assertTrue(s.isEmpty());
    }
}