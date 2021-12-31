package uno;

import uno.cartes.*;

import java.util.ArrayList;
import java.util.Random;

public class Uno {
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;
    private int Current_player;
    private ArrayList<Joueur> players;
    private int nb; //nombres de cartes à piocher



    //un constructeur vide
    public Uno (){

    }

    public Carte top_talon()
    {
        return this.talon.getSommet();

    }

    public int getCurrent_player() {
        return Current_player;
    }

    public void add_carte_talon(Carte tc){
         this.talon.ajouter(tc);

    }
    public Carte pioche_c()
    {
       if(pioche.piocher()==null){
           Carte sommet = top_talon();
           talon.remove(sommet);
           this.pioche.ajouter(talon);
           for (Carte c: talon) {
               talon.remove(c);
           }
           talon.ajouter(sommet);
       }
       return pioche.piocher();
    }


 public void creerJoueurs (int nbplayers)
 {
     this.players = new ArrayList<Joueur>(nbplayers);
     this.players.add(new JoueurHumain( "PLAYER_HUMAIN",this,0));
     for (int j = 1 ; j<nbplayers ;j++) {
         this.players.add(new Bot("PLAYER_BOT",this, j));
     }
 }




 public void effet_piocher(int nb)
 {
     if (nb < 0) {
         throw new IllegalArgumentException("Erreur");
     } else {
         this.nb = nb;
     }
     for(int i=0; i<nb;i++)
     {
         Carte c = pioche.piocher();
         players.get(getCurrent_player()+1).recoitCarte(c);
     }


 }
 public void effetChangementdeSens(){
        if(Current_player){

        }
 }
 public void DistribuerCartes(int players)
 {
     this.pioche= FabriqueCartes.getPaquet_UNO(this);
     this.talon = FabriqueCartes.getPaquetVide();
     PaquetDeCartes deck;
     for(int nombre_carte = 1 ; nombre_carte<=7; nombre_carte++){
         for(int i =0; i<players; i++)
         {
             deck= this.players.get(i).getmain();
             deck.ajouter(pioche.piocher());
             this.players.get(i).setmain(deck);
         }


     }
     this.talon.ajouter(pioche.piocher());
 }

 public void QuiDistribue(int players)
 {
     Random rand = new Random();

 }




}
