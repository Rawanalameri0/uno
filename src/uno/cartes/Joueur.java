package uno.cartes;
import uno.cartes.*;
import uno.Uno;

public abstract class Joueur {
    protected  Uno uno;
    protected PaquetDeCartes main;
    protected String nom;
    protected int numero;

    Joueur(String nom,Uno uno,int numero){
        this.uno= uno;
        this.numero= numero;

    }

    public abstract void jouer(String coup);

    public void recoitCarte(Carte c)
    {
        for(Carte i: main)
        {
            this.main.ajouter(i);
        }
    }

    public PaquetDeCartes getmain() {
        return main;
    }

    public void setmain(PaquetDeCartes deck) {
        this.main=deck;
    }
}

