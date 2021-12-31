package uno.cartes;

import uno.Uno;

public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom, Uno uno, int numero) {
        super(nom,uno,numero);
    }

    public Carte CarteChoisie(String coup) throws Exception{
        int Carte_index = Integer.parseInt((String.valueOf(coup.charAt(0))));
        Carte carte_chosie = null;
        try{
            if(Carte_index <= this.main.getNombreDeCartes()){
                carte_chosie = this.main.getCarte(Carte_index);
            }
        } catch (Exception e){
            throw new Exception("Erreur");
        }
        return carte_chosie;
    }

    @Override
    public void jouer(String coup) {
        Carte carte_jouee;
        try {
            carte_jouee= CarteChoisie(coup);
            if (uno.top_talon().peutEtreRecouvertePar(carte_jouee)) {
                uno.ajouter_talon(carte_jouee);
                this.main.remove(carte_jouee);
                carte_jouee.appliquereffet();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
