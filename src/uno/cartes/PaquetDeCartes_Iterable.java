package uno.cartes;

import java.util.ArrayList;
import java.util.Iterator;

public class PaquetDeCartes_Iterable implements Iterator<Carte> {
    private ArrayList<Carte> deck;
    private int i;

    public PaquetDeCartes_Iterable(ArrayList<Carte> deck){
        this.i=0;
        this.deck=deck;

    }


    @Override
    public boolean hasNext() {
        if(i+1<this.deck.size()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Carte next() {
        i++;
        return this.deck.get(i);

    }
}
