package cartes;
import cartes.Carte;
import java.util.ArrayList;
import java.util.Collections;



public class PaquetDeCartes{

    private ArrayList<Carte> deck;


    /**
     * Constructeur de paquet de cartes
     */
    public PaquetDeCartes()
    {
        this.deck = new ArrayList<Carte>();
    }
    /**
     * Ajouter des cartes au paquet
     * @param cartes tableau de cartes
     */
    public void ajouter(Carte... cartes)
    {
        for(Carte i: cartes)
        {
            this.deck.add(i);
        }
    }

    /**
     * @return le nombres de cartes dans le paquet
     */
    public int getNombreDeCartes()
    {
        return this.deck.size();
    }

    /**
     * @return vrai si le paquet est vide
     */
    public boolean estVide()
    {
        return this.deck.isEmpty();
    }

    /**
     * @return la somme des cartes du paquet
     */
    public int getValeur()
    {
        int somme=0;
        for(int i=0; i<getNombreDeCartes(); i++)
        {
            somme += this.deck.get(i).getValeur();

        }
        return somme;

    }


    /**
     * @return l'affichage du paquet de cartes
     */
    public String toString()
    {
        return ("paquet:"+this.deck);
    }

    /**
     * Rajouter un paquet de cartes au paquet existant
     * @param pdc paquet de cartes
     */
    public void ajouter(PaquetDeCartes pdc)
    {
        for(Carte i: pdc.deck)
        {
            this.deck.add(i);
        }

    }


    /**
     * Mélanger les cartes du paquet
     */
    public void melanger()
    {
        Collections.shuffle(this.deck);

    }

    /**
     * inverser l'ordre des cartes du paquet
     */
    public void retourner()
    {
        Collections.reverse(this.deck);
    }

    /**
     * @return le carte au sommet du paquet
     */
    public Carte getSommet(){
        return this.deck.get(getNombreDeCartes()-1);


    }
    /**
     * @return le carte au sommet du paquet et l'enlève
     */
    public Carte piocher(){
        Carte c = getSommet();
        this.deck.remove(c);
        return c;
    }




}
