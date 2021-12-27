package uno.cartes;

import uno.*;

public abstract class Carte {

    protected Uno uno;
    protected Couleur couleur ;

    public Carte(Uno u,Couleur c) {
        this.uno = u;
        this.couleur = c;
    }
    public abstract int getValeur();
    public abstract boolean peutEtreRecouvertePar (Carte c);
    public abstract boolean peutEtrePoseeSur(Chiffre c);
    public abstract boolean peutEtrePoseeSur(Plus2 c);
    public abstract boolean peutEtrePoseeSur(Plus4 c);
    public abstract boolean peutEtrePoseeSur(Jocker c);
    public abstract boolean peutEtrePoseeSur(PasseTonTour c);
    public abstract boolean peutEtrePoseeSur(ChangementDeSens c);


    public Couleur getCouleur() {
        return couleur;
    }
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }


    public boolean estSansCouleur() {
        if (this.couleur==null){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean estDeCouleurCompatibleAvec(Carte c)
    {
        if (c.getCouleur().equals(this.couleur))
        {
            return true;
        }
        else{
            return false;
        }
    }
}