package uno.cartes;

import uno.Uno;

public class Bot extends Joueur {

    public Bot(String nom, Uno uno, int numero) {
        super(nom,uno,numero);

    }

    public void jouer(String coup) {
        for (Carte carte : main) {
            if(uno.top_talon().peutEtreRecouvertePar(carte)){
                uno.add_carte_talon(carte);
                main.remove(carte);
               // appliquereffet()

            }
            else{

            }
            
        }



    }



}
