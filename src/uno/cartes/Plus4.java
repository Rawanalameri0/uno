package uno.cartes;

import uno.Uno;

public class Plus4 extends Carte {


    public Plus4 (Uno uno, Couleur c ){
        super(uno, c);
    }


    public int getValeur() {
        return 50;
    }

    @Override
    public void appliquereffet() {
        uno.effet_piocher(4);
    }


    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }


    public boolean peutEtrePoseeSur(Chiffre c) {
        return true;
    }


    public boolean peutEtrePoseeSur(Plus2 c) {
        return true;
    }


    public boolean peutEtrePoseeSur(Plus4 c) {
        return true;
    }


    public boolean peutEtrePoseeSur(Jocker c) {
        return true;
    }


    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }


    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }

    @Override
    public String toString() {
        return ("Plus4");
    }


}