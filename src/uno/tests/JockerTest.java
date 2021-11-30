package uno.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;
import uno.cartes.*;

import static org.junit.jupiter.api.Assertions.*;

class JockerTest {
    Chiffre c;
    Jocker j1,j2,j3;
    ChangementDeSens cds;
    Plus2 p2;
    Plus4 p4;
    PasseTonTour ptt;
    Uno uno;

    @BeforeEach
    void setUp() {
        uno = new Uno();
        c= new Chiffre(uno,Couleur.BLEU,1);
        cds= new ChangementDeSens(uno,Couleur.BLEU);
        p2= new Plus2(uno,Couleur.JAUNE);
        p4= new Plus4(uno,Couleur.VERT);
        j1= new Jocker(uno,Couleur.VERT);
        j2= new Jocker(uno,Couleur.JAUNE);
        j3= new Jocker(uno,Couleur.BLEU);
        ptt=new PasseTonTour(uno,Couleur.VERT);
    }

    @Test
    void getValeur() {
        assertEquals(50,j1.getValeur());
    }

    @Test
    void peutEtreRecouvertePar() {
        assertEquals(false, j1.peutEtreRecouvertePar(c));
        assertEquals(false, j1.peutEtreRecouvertePar(cds));
        assertEquals(true, j1.peutEtreRecouvertePar(ptt));
        assertEquals(false, j1.peutEtreRecouvertePar(p2));
        assertEquals(true, j1.peutEtreRecouvertePar(p4));

    }

    @Test
    void peutEtrePoseeSur() {
        assertEquals(true,j1.peutEtrePoseeSur(j1));
    }

    @Test
    void testPeutEtrePoseeSur() {
        assertEquals(true,j3.peutEtrePoseeSur(c));
        assertEquals(false,j2.peutEtrePoseeSur(c));
    }

    @Test
    void testPeutEtrePoseeSur1() {
        assertEquals(true,j1.peutEtrePoseeSur(p4));
        assertEquals(false,j2.peutEtrePoseeSur(p4));
    }

    @Test
    void testPeutEtrePoseeSur2() {
        assertEquals(true,j2.peutEtrePoseeSur(p2));
        assertEquals(false,j1.peutEtrePoseeSur(p2));
    }

    @Test
    void testPeutEtrePoseeSur3() {
        assertEquals(true,j1.peutEtrePoseeSur(ptt));
        assertEquals(false,j2.peutEtrePoseeSur(ptt));
    }

    @Test
    void testPeutEtrePoseeSur4() {
        assertEquals(true,j3.peutEtrePoseeSur(cds));
        assertEquals(false,j1.peutEtrePoseeSur(cds));
    }
}