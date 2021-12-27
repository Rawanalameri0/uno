package uno.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;
import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

class ChiffreTest {
    Chiffre c1,c2,c3,c4;
    Jocker j;
    ChangementDeSens cds;
    Plus2 p2;
    Plus4 p4;
    PasseTonTour ptt;
    Uno uno;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        c1= new Chiffre(uno,Couleur.BLEU,1);
        c2= new Chiffre(uno,Couleur.JAUNE,2);
        c3= new Chiffre(uno,Couleur.ROUGE,3);
        c4= new Chiffre(uno,Couleur.VERT,4);
        cds= new ChangementDeSens(uno,Couleur.BLEU);
        p2= new Plus2(uno,Couleur.JAUNE);
        p4= new Plus4(uno,Couleur.VERT);
        j= new Jocker(uno,Couleur.VERT);
        ptt=new PasseTonTour(uno,Couleur.VERT);
    }

    @Test
    void getValeur() {
        assertEquals(1,c1.getValeur());
    }

    @Test
    void peutEtreRecouvertePar() {
        assertEquals(true, c4.peutEtreRecouvertePar(j));
        assertEquals(true, c1.peutEtreRecouvertePar(j));
        assertEquals(true, c1.peutEtreRecouvertePar(p4));
        assertEquals(true, c3.peutEtreRecouvertePar(p4));
        assertEquals(true, c2.peutEtreRecouvertePar(p2));
        assertEquals(false, c3.peutEtreRecouvertePar(p2));
        assertEquals(true, c4.peutEtreRecouvertePar(ptt));
        assertEquals(false, c1.peutEtreRecouvertePar(ptt));
        assertEquals(true, c3.peutEtreRecouvertePar(p4));
        assertEquals(true, c3.peutEtreRecouvertePar(p4));
        assertEquals(true, c1.peutEtreRecouvertePar(cds));
        assertEquals(false, c3.peutEtreRecouvertePar(cds));
        assertEquals(true, c1.peutEtreRecouvertePar(c1));
        assertEquals(true, c2.peutEtreRecouvertePar(c3));

    }

    @Test
    void peutEtrePoseeSur() {
        assertEquals(true,c1.peutEtrePoseeSur(c1));
        assertEquals(false,c2.peutEtrePoseeSur(c1));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertEquals(true,c4.peutEtrePoseeSur(p4));
        assertEquals(false,c1.peutEtrePoseeSur(p4));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertEquals(true,c4.peutEtrePoseeSur(ptt));
        assertEquals(false,c1.peutEtrePoseeSur(ptt));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertEquals(true,c1.peutEtrePoseeSur(cds));
        assertEquals(false,c3.peutEtrePoseeSur(cds));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertEquals(true,c2.peutEtrePoseeSur(p2));
        assertEquals(false,c1.peutEtrePoseeSur(p2));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertEquals(true,c4.peutEtrePoseeSur(j));
        assertEquals(false,c1.peutEtrePoseeSur(j));
    }
}