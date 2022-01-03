package uno.cartes;

import uno.Uno;

public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom, Uno uno, int numero) {
        super(nom, uno, numero);
    }

    public Carte CarteChoisie(String coup) throws Exception {

        Carte carte_chosie = null;
        try {
            if (coup.length() == 1) {
                if (coup.charAt(0) == 'p') {
                    this.main.ajouter(uno.pioche_c());
                    carte_chosie = main.getSommet();
                    return carte_chosie;
                }

            } else if (coup.length() == 2) {
                char couleur_carte = coup.charAt(1);
                int Carte_index = Integer.parseInt((String.valueOf(coup.charAt(0))));
                if (Carte_index <= this.main.getNombreDeCartes() && Carte_index > 0) {
                    carte_chosie = this.main.getCarte(Carte_index - 1);
                    if (carte_chosie.estSansCouleur()) {
                        if (couleur_carte == 'B' || couleur_carte == 'b') {
                            carte_chosie.setCouleur(Couleur.BLEU);
                        } else if (couleur_carte == 'J' || couleur_carte == 'j') {
                            carte_chosie.setCouleur(Couleur.JAUNE);
                        } else if (couleur_carte == 'R' || couleur_carte == 'r') {
                            carte_chosie.setCouleur(Couleur.ROUGE);
                        } else if (couleur_carte == 'V' || couleur_carte == 'v') {
                            carte_chosie.setCouleur(Couleur.VERT);
                        }

                    }
                    return carte_chosie;
                } else {
                    throw new Exception("CARTE PAS COMPITIBLE");
                }
            }
            throw new Exception("CARTE PAS COMPITIBLE");
        } catch (Exception e) {
            throw new Exception("Erreur");
        }
    }






    @Override
    public boolean isPlayerHumain() {
        return true;
    }

    @Override
    public void jouer(String coup) {
        try {
            Carte carte_jouee;
            carte_jouee= CarteChoisie(coup);
           if(carte_jouee.peutEtreRecouvertePar(carte_jouee)) {
               uno.ajouter_talon(carte_jouee);
               this.main.remove(carte_jouee);
               carte_jouee.appliquereffet();
               this.setscore(carte_jouee.getValeur());
           }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setscore(int val) {
        this.score+=val;
    }
}
