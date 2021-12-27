package uno.tests;
import uno.Uno;
import uno.cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Plus4Test {
    Plus4 plus4_1,plus4_2,plus4_3,plus4_4;
    Jocker j;
    ChangementDeSens cds;
    Chiffre c;
    Plus2 p2;
    PasseTonTour ptt;
    Uno uno;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        plus4_1= new Plus4(uno,Couleur.BLEU);
        plus4_2= new Plus4(uno,Couleur.JAUNE);
        plus4_3= new Plus4(uno,Couleur.VERT);
        plus4_4= new Plus4(uno,Couleur.ROUGE);
        cds= new ChangementDeSens(uno,Couleur.BLEU);
        c= new Chiffre(uno,Couleur.BLEU,1);
        p2= new Plus2(uno,Couleur.VERT);
        j= new Jocker(uno,Couleur.VERT);
        ptt=new PasseTonTour(uno,Couleur.VERT);
    }

    @Test
    void getValeur() {
        assertEquals(50,plus4_1.getValeur());
    }

    @Test
    void peutEtreRecouvertePar() {
        assertEquals(true, plus4_1.peutEtreRecouvertePar(c));
        assertEquals(false, plus4_2.peutEtreRecouvertePar(c));
        assertEquals(true, plus4_1.peutEtreRecouvertePar(cds));
        assertEquals(false, plus4_2.peutEtreRecouvertePar(cds));
        assertEquals(true, plus4_3.peutEtreRecouvertePar(ptt));
        assertEquals(false, plus4_2.peutEtreRecouvertePar(ptt));
        assertEquals(false, plus4_1.peutEtreRecouvertePar(p2));
        assertEquals(true, plus4_3.peutEtreRecouvertePar(p2));
        assertEquals(true, plus4_2.peutEtreRecouvertePar(plus4_3));
        assertEquals(true, plus4_1.peutEtreRecouvertePar(j));
    }

    @Test
    void peutEtrePoseeSur() {
        assertEquals(true,plus4_1.peutEtrePoseeSur(plus4_1));

    }

    @Test
    void testPeutEtrePoseeSur() {
        assertEquals(true,plus4_1.peutEtrePoseeSur(c));
        assertEquals(true,plus4_2.peutEtrePoseeSur(c));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertEquals(true,plus4_3.peutEtrePoseeSur(ptt));
        assertEquals(true,plus4_2.peutEtrePoseeSur(ptt));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertEquals(true,plus4_3.peutEtrePoseeSur(p2));
        assertEquals(true,plus4_1.peutEtrePoseeSur(p2));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertEquals(true,plus4_1.peutEtrePoseeSur(cds));
        assertEquals(true,plus4_3.peutEtrePoseeSur(cds));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertEquals(true,plus4_1.peutEtrePoseeSur(j));
        assertEquals(true,plus4_2.peutEtrePoseeSur(j));


    }
}