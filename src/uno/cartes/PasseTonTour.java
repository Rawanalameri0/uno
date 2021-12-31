package uno.cartes;

import uno.Uno;

public class PasseTonTour extends Carte {


    public PasseTonTour(Uno uno, Couleur c) {
        super(uno, c);

    }


    public int getValeur() {
        return 20;
    }

    @Override
    public void appliquereffet() {
        uno.effet_pass_ton_tour();

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
        return true;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return this.estDeCouleurCompatibleAvec(c);
    }




}
