package uno.cartes;

import uno.Uno;

public class Jocker extends Carte {


    public Jocker(Uno uno, Couleur c) {
        super(uno, c);

    }


    public int getValeur() {
        return 50;
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

}
