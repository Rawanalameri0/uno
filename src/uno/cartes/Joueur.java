package uno.cartes;
import uno.cartes.*;
import uno.Uno;

public abstract class Joueur {
    protected  Uno uno;
    protected PaquetDeCartes main;
    protected String nom;
    protected int numero;
    protected int score;

    public Joueur(String nom,Uno uno,int numero){
        this.uno= uno;
        this.numero= numero;
        this.nom=nom;
        this.main=new PaquetDeCartes();
    }

    public abstract void jouer(String coup);

    public void recoitCarte(Carte c)
    {
        this.main.ajouter(c);
    }

    public PaquetDeCartes getmain() {
        return main;
    }
}

