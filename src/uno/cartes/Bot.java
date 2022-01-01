package uno.cartes;

import uno.Uno;

import java.util.Random;

public class Bot extends Joueur {

    public Bot(String nom, Uno uno, int numero) {
        super(nom,uno,numero);

    }

    public  Carte carteChoisie(String coup)
    {
        int color_random;
        Random rand = new Random();
        for (Carte carte : main){
            if(uno.top_talon().peutEtreRecouvertePar(carte)) {
                if (carte.estSansCouleur()) {
                    color_random = rand.nextInt(5);
                    switch (color_random) {
                        case 1:
                            carte.setCouleur(Couleur.BLEU);
                            break;
                        case 2:
                            carte.setCouleur(Couleur.JAUNE);
                            break;
                        case 3:
                            carte.setCouleur(Couleur.ROUGE);
                            break;
                        case 4:
                            carte.setCouleur(Couleur.VERT);
                            break;
                    }
                }
                return carte;
            }
        }
        return null;
    }

    public void jouer(String coup) {
        Carte carte= carteChoisie(coup);
        if (carte==null) {
            main.ajouter(uno.pioche_c());
        }else {
            uno.add_carte_talon(carte);
            main.remove(carte);
            carte.appliquereffet();
        }
    }


}
