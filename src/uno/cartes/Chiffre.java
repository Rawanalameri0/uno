package uno.cartes;


import uno.*;

public class Chiffre extends Carte {
    private int val;
    public Chiffre(Uno uno, Couleur c , int val){
        super(uno,c);
        this.val = val;
    }



    public void appliquerEffet() {


    }


    public int getValeur() {
        return val;
    }

    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }


    public boolean peutEtrePoseeSur(Chiffre c) {
        if (c.getCouleur().equals(this.couleur) || c.getValeur() == this.getValeur()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean peutEtrePoseeSur(Plus2 c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean peutEtrePoseeSur(Plus4 c){
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }

    public boolean peutEtrePoseeSur(Jocker c) {
        if (c.getCouleur().equals(this.couleur) || !c.getCouleur().equals(this.couleur))
        {
            return true;
        }
        if(c.getValeur()==this.getValeur() || c.getValeur()!=this.getValeur())
        {
            return true;
        }

        return false;
    }
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        if (c.getCouleur().equals(this.couleur) || !c.getCouleur().equals(this.couleur))
        {
            return true;
        }
        if(c.getValeur()==this.getValeur() || c.getValeur()!=this.getValeur())
        {
            return true;
        }
        return false;
    }

    public boolean peutEtrePoseeSur(PasseTonTour c) {
        if (c.getCouleur().equals(this.couleur)) {
            return true;
        }
        return false;
    }




}
