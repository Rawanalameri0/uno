package uno.cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;


public class PaquetDeCartes implements Iterable<Carte>{

    private ArrayList<Carte> deck;


    /**
     * Constructeur de paquet de uno.cartes
     */
    public PaquetDeCartes()
    {
        this.deck = new ArrayList<Carte>();
    }
    /**
     * Ajouter des uno.cartes au paquet
     * @param cartes tableau de uno.cartes
     */
    public void ajouter(Carte... cartes)
    {
        for(Carte i: cartes)
        {
            this.deck.add(i);
        }
    }

    /**
     * @return le nombres de uno.cartes dans le paquet
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
     * @return la somme des uno.cartes du paquet
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
     * @return l'affichage du paquet de uno.cartes
     */
    public String toString()
    {
        return ("paquet:"+this.deck);
    }

    /**
     * Rajouter un paquet de uno.cartes au paquet existant
     * @param pdc paquet de uno.cartes
     */
    public void ajouter(PaquetDeCartes pdc)
    {
        for(Carte i: pdc.deck)
        {
            this.deck.add(i);
        }

    }


    /**
     * Mélanger les uno.cartes du paquet
     */
    public void melanger()
    {
        Collections.shuffle(this.deck);

    }

    /**
     * inverser l'ordre des uno.cartes du paquet
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


    @Override
    public Iterator<Carte> iterator() {
        return new PaquetDeCartes_Iterable(deck);

    }

    


}
