package uno.tests;
import uno.Uno;
import uno.cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Plus2Test {
    Plus2 plus2_1,plus2_2,plus2_3,plus2_4;
    Jocker j;
    ChangementDeSens cds;
    Chiffre c;
    Plus4 p4;
    PasseTonTour ptt;
    Uno uno;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        plus2_1= new Plus2(uno,Couleur.BLEU);
        plus2_2= new Plus2(uno,Couleur.JAUNE);
        plus2_3= new Plus2(uno,Couleur.ROUGE);
        plus2_4= new Plus2(uno,Couleur.VERT);
        cds= new ChangementDeSens(uno,Couleur.BLEU);
        c= new Chiffre(uno,Couleur.BLEU,1);
        p4= new Plus4(uno,Couleur.VERT);
        j= new Jocker(uno,Couleur.VERT);
        ptt=new PasseTonTour(uno,Couleur.VERT);
    }

    @Test
    void getValeur() {
        assertEquals(20,plus2_3.getValeur());
    }

    @Test
    void peutEtreRecouvertePar() {
        assertEquals(true, plus2_4.peutEtreRecouvertePar(j));
        assertEquals(false, plus2_1.peutEtreRecouvertePar(j));
    }

    @Test
    void peutEtrePoseeSur() {
        assertEquals(true, plus2_1.peutEtrePoseeSur(c));
        assertEquals(false, plus2_2.peutEtrePoseeSur(c));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertEquals(true, plus2_4.peutEtrePoseeSur(ptt));
        assertEquals(false, plus2_2.peutEtrePoseeSur(ptt));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertEquals(true, plus2_1.peutEtrePoseeSur(cds));
        assertEquals(false, plus2_2.peutEtrePoseeSur(cds));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertEquals(true, plus2_1.peutEtrePoseeSur(plus2_1));
        assertEquals(false, plus2_2.peutEtrePoseeSur(plus2_1));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertEquals(true, plus2_4.peutEtrePoseeSur(p4));
        assertEquals(false, plus2_2.peutEtrePoseeSur(p4));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertEquals(true, plus2_4.peutEtrePoseeSur(j));
        assertEquals(false, plus2_2.peutEtrePoseeSur(j));
    }
}