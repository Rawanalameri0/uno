package uno.tests;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.Uno;
import uno.cartes.*;

import static org.junit.jupiter.api.Assertions.*;

class ChangementDeSensTest {
    ChangementDeSens cds1,cds2,cds3,cds4;
    Jocker j;
    Chiffre c;
    Plus2 p2;
    Plus4 p4;
    PasseTonTour ptt;
    Uno uno;



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        uno = new Uno();
        cds1= new ChangementDeSens(uno,Couleur.BLEU);
        cds2= new ChangementDeSens(uno,Couleur.JAUNE);
        cds3= new ChangementDeSens(uno,Couleur.ROUGE);
        cds4= new ChangementDeSens(uno,Couleur.VERT);
        c= new Chiffre(uno,Couleur.BLEU,5);
        p2= new Plus2(uno,Couleur.JAUNE);
        p4= new Plus4(uno,Couleur.VERT);
        j= new Jocker(uno,Couleur.VERT);
        ptt=new PasseTonTour(uno,Couleur.VERT);
    }

    @org.junit.jupiter.api.Test
    void getValeur() {
       assertEquals(20,cds1.getValeur());

    }

    @org.junit.jupiter.api.Test
    void peutEtreRecouvertePar() {
        assertEquals(true, cds4.peutEtreRecouvertePar(j));
        assertEquals(false, cds1.peutEtreRecouvertePar(j));
    }

    @org.junit.jupiter.api.Test
    void peutEtrePoseeSur() {

        assertEquals(true,cds1.peutEtrePoseeSur(cds1));
        assertEquals(false,cds2.peutEtrePoseeSur(cds1));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur() {

        assertEquals(true,cds4.peutEtrePoseeSur(p4));
        assertEquals(false,cds1.peutEtrePoseeSur(p4));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur1() {

        assertEquals(true,cds4.peutEtrePoseeSur(ptt));
       // assertEquals(false,cds1.peutEtrePoseeSur(ptt));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur2() {

        assertEquals(true,cds1.peutEtrePoseeSur(c));
       // assertEquals(false,cds3.peutEtrePoseeSur(c));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur3() {

        assertEquals(true,cds2.peutEtrePoseeSur(p2));
        //assertEquals(false,cds1.peutEtrePoseeSur(p2));
    }

    @org.junit.jupiter.api.Test
    void testPeutEtrePoseeSur4() {

        assertEquals(true,cds4.peutEtrePoseeSur(j));
      //  assertEquals(false,cds1.peutEtrePoseeSur(j));
    }
}