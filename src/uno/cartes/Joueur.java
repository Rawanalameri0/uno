package uno.cartes;
import uno.cartes.*;
import uno.Uno;

public abstract class Joueur {
    protected  Uno uno;
    protected PaquetDeCartes main;
    protected String nom;
    protected int numero;

    Joueur(String nom,Uno uno,int numero){

    }

    public abstract void jouer(String coup){}
}
