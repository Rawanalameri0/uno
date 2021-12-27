package uno.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;
import uno.cartes.*;

import static org.junit.jupiter.api.Assertions.*;

class PasseTonTourTest {
    ChangementDeSens cds;
    Jocker j;
    Chiffre c;
    Plus2 p2;
    Plus4 p4;
    PasseTonTour ptt_1,ptt_2,ptt_3;
    Uno uno;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        cds= new ChangementDeSens(uno,Couleur.BLEU);
        c= new Chiffre(uno,Couleur.BLEU,5);
        p2= new Plus2(uno,Couleur.JAUNE);
        p4= new Plus4(uno,Couleur.VERT);
        j= new Jocker(uno,Couleur.VERT);
        ptt_1=new PasseTonTour(uno,Couleur.VERT);
        ptt_2=new PasseTonTour(uno,Couleur.BLEU);
        ptt_3=new PasseTonTour(uno,Couleur.JAUNE);
    }

    @Test
    void getValeur() {
        assertEquals(20,ptt_1.getValeur());
    }

    @Test
    void peutEtreRecouvertePar() {
        assertEquals(true, ptt_1.peutEtreRecouvertePar(j));
        assertEquals(true, ptt_2.peutEtreRecouvertePar(j));
        assertEquals(true, ptt_3.peutEtreRecouvertePar(p2));
        assertEquals(false, ptt_1.peutEtreRecouvertePar(p2));
        assertEquals(true, ptt_2.peutEtreRecouvertePar(p4));
        assertEquals(true, ptt_3.peutEtreRecouvertePar(p4));
        assertEquals(true, ptt_2.peutEtreRecouvertePar(cds));
        assertEquals(false, ptt_3.peutEtreRecouvertePar(cds));
        assertEquals(true, ptt_3.peutEtreRecouvertePar(ptt_2));

    }

    @Test
    void peutEtrePoseeSur() {
        assertEquals(true,ptt_1.peutEtrePoseeSur(ptt_1));
        assertEquals(true,ptt_1.peutEtrePoseeSur(ptt_2));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertEquals(true,ptt_1.peutEtrePoseeSur(p4));
        assertEquals(false,ptt_2.peutEtrePoseeSur(p4));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertEquals(true,ptt_3.peutEtrePoseeSur(p2));
        assertEquals(false,ptt_1.peutEtrePoseeSur(p2));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertEquals(true,ptt_2.peutEtrePoseeSur(cds));
        assertEquals(false,ptt_1.peutEtrePoseeSur(cds));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertEquals(true,ptt_1.peutEtrePoseeSur(j));
        assertEquals(false,ptt_2.peutEtrePoseeSur(j));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertEquals(true,ptt_2.peutEtrePoseeSur(c));
        assertEquals(false,ptt_3.peutEtrePoseeSur(c));
    }
}