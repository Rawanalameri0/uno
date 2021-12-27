package uno.cartes;

import uno.*;

public class ChangementDeSens extends Carte {


    public ChangementDeSens(Uno uno, Couleur c) {
        super(uno, c);
    }


    public int getValeur() {
        return 20;
    }


    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }


    public boolean peutEtrePoseeSur(Chiffre c) {
      return this.estDeCouleurCompatibleAvec(c);
    }


    public boolean peutEtrePoseeSur(Plus2 c) {
        return this.estDeCouleurCompatibleAvec(c);
    }


    public boolean peutEtrePoseeSur(Plus4 c) {
        return this.estDeCouleurCompatibleAvec(c);
    }


    public boolean peutEtrePoseeSur(Jocker c) {
        return this.estDeCouleurCompatibleAvec(c);
    }


    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return this.estDeCouleurCompatibleAvec(c);
    }


    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }





}