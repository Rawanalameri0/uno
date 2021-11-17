package cartes;

public class Carte {

    private int valeur ;
    private Uno uno;
    private Couleur couleur ;

    public Carte(int v,Couleur c){
        this.valeur=v;
        this.couleur=c;
    }

    public Carte(Uno u,Couleur c) {
        this.uno = u;
        this.couleur = c;
    }

    public int getValeur() {
        return valeur;
    }


    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public String toString() {
        return "Carte{" +
                "valeur=" + valeur +
                ", couleur=" + couleur +
                '}';
    }

}