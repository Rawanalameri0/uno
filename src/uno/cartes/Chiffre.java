package uno.cartes;


import uno.*;

public class Chiffre extends Carte {
    private int val;
    public Chiffre(Uno uno, Couleur c , int val){
        super(uno,c);
        this.val = val;
    }

    public int getValeur() {
        return val;
    }

    @Override
    public void appliquereffet() {

    }

    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }


    public boolean peutEtrePoseeSur(Chiffre c) {
        return c.getCouleur().equals(this.couleur) || c.getValeur() == this.getValeur();
    }

    public boolean peutEtrePoseeSur(Plus2 c) {
        return this.estDeCouleurCompatibleAvec(c);
    }
    public boolean peutEtrePoseeSur(Plus4 c){
        return this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(Jocker c) {
        return this.estDeCouleurCompatibleAvec(c);
    }
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return this.estDeCouleurCompatibleAvec(c);
    }

    @Override
    public String toString() {
        return ("Chiffre_" + getValeur()+ "_" + getCouleur());
    }


    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return this.estDeCouleurCompatibleAvec(c);
    }




}
