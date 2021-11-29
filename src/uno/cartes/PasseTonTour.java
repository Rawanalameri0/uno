package uno.cartes;

import uno.Uno;

public class PasseTonTour extends Carte {


    public PasseTonTour(Uno uno, Couleur c) {
        super(uno, c);

    }


    public int getValeur() {
        return 20;
    }


    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    public boolean peutEtrePoseeSur(Chiffre c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }


    public boolean peutEtrePoseeSur(Plus2 c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }


    public boolean peutEtrePoseeSur(Plus4 c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }


    public boolean peutEtrePoseeSur(Jocker c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }


    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }


}
