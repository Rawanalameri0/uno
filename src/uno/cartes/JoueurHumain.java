package uno.cartes;

import uno.Uno;

public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom, Uno uno, int numero) {
        super(nom,uno,numero);

    }

    public Carte CarteChoisie(String coup) throws CoupIncorrect{
        int Carte_index = Integer.parseInt((String.valueOf(coup.charAt(0))));
        Carte carte_chosie;
        if(Carte_index <= this.main.getNombreDeCartes()){
            carte_chosie = this.main.getCarte(Carte_index);
        }
        else{
            throw new CoupIncorrect("Erreur");
        }
        return carte_chosie;

    }

    @Override
    public void jouer(String coup) {
        Carte carte_jouee;
        carte_jouee= CarteChoisie(coup);
        try {
            //si le player choisit p donc il va piocher une carte
            if (coup.charAt(0) == 'p') {
                this.main.ajouter(uno.pioche_c());
            }
            else{
                System.out.println("Passe ton tour");
            }
            if (coup.length()==2){
                char action_carte = coup.charAt(2);
                char couleur_carte = coup.charAt(1);
                if(action_carte== 'J' || action_carte=='P' ){
                    if(couleur_carte=='J'|| couleur_carte=='j'){
                        carte_jouee.setCouleur(Couleur.JAUNE);
                    }
                    else if(couleur_carte=='B'|| couleur_carte=='b'){
                        carte_jouee.setCouleur(Couleur.BLEU);
                    }
                    else if(couleur_carte=='R'|| couleur_carte=='r')
                    {
                        carte_jouee.setCouleur(Couleur.ROUGE);
                    }
                    else if(couleur_carte=='V'|| couleur_carte=='v'){
                        carte_jouee.setCouleur(Couleur.VERT);
                    }
                    else{
                        throw new CoupIncorrect("erreur");
                    }


                }

            }


        }


    }
}
