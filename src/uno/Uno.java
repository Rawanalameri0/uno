package uno;

import uno.cartes.*;

import java.util.ArrayList;

public class Uno {
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;
    private int Current_player;
    private ArrayList<Joueur> players;
    private int nb; //nombres de cartes à piocher
    private boolean senshorraire;
    private int joueurquidistrbue;
    private DialogueLigneDeCommande dialogue;


    //un constructeur vide
    public Uno() {
    }

    /**
     * une fonction pour ajouter la sommet au talon
     * @return une carte
     */
    public Carte top_talon() {
        return this.talon.getSommet();

    }

    /**
     * joueur actuel
     * @return int
     */
    public int getCurrent_player() {
        return this.Current_player;
    }

    /**
     * une fonction if la pioche est vide on ajoute le talon sauf le sommet
     * @return une carte
     */
    public Carte pioche_c() {
        if (pioche.piocher() == null) {
            Carte sommet = top_talon();
            talon.remove(sommet);
            this.pioche.ajouter(talon);
            for (Carte c : talon) {
                talon.remove(c);
            }
            talon.ajouter(sommet);
        }
        return pioche.piocher();
    }

    /**
     * on creer des joueurs
     * @param nbplayers
     * @param nom
     */
    public void creerJoueurs(int nbplayers, String nom) {
        this.players = new ArrayList<Joueur>();
        this.players.add(new JoueurHumain(nom, this, 0));
        for (int j = 1; j < nbplayers; j++) {
            this.players.add(new Bot("PLAYER_BOT", this, j));
        }
    }

    /**
     * Getter de joueur
     * @param i
     * @return joueur
     */
    public Joueur getPlayer(int i) {
        if(i>=players.size()){
            i=0;
        }
        if(i<=0)
        {
            i=players.size()-1;
        }
        return this.players.get(i);

    }

    /**
     * effet pour de piocher pour plus2 et plus4
     * @param nb
     */
    public void effet_piocher(int nb) {
        if (nb < 0) {
            throw new IllegalArgumentException("Erreur");
        } else {
            this.nb = nb;
        }
        for (int i = 0; i < nb; i++) {
            Carte c = pioche.piocher();
            players.get(getCurrent_player() + 1).recoitCarte(c);
        }


    }

    /**
     * effet de pass ton tour
     */
    public void effet_pass_ton_tour() {

        players.get(getCurrent_player() + 1);
    }

    /**
     * effet de chanhgmement de sens
     */
    public void effetChangementdeSens() {
        if (senshorraire) {
            senshorraire = false;
        }
        else {
            senshorraire=true;
        }
    }

    /**
     * distruber les cartes au joueurs
     */
    public void DistribuerCartes() {
        this.pioche = FabriqueCartes.getInstance().Paquet_UNO(this);
        pioche.melanger();
        this.talon = FabriqueCartes.getInstance().getPaquetVide();
        this.talon.ajouter(pioche_c());

        for (int nb_c = 1; nb_c <= 7; nb_c++) {
            for (int i = QuiDistribue(); i < players.size(); i++) {
                Carte c = this.pioche.piocher();
                this.players.get(i).recoitCarte(c);

            }
        }
        this.talon.ajouter(pioche.piocher());
    }

    /**
     * le premeir joueur qui distrube est humain
     * @return
     */
    public int QuiDistribue() {
        return this.joueurquidistrbue = 0; //premier joueur

    }

    /**
     * qui joue et le personne qui distrbue
     * @return
     */
    public int ChoisirquiJoue() {
        return QuiDistribue();

    }

    /**
     * ajoueter une carte au talon
     * @param c
     */
    public void ajouter_talon(Carte c) {

        this.talon.ajouter(c);
    }

    /**
     * set dialogue
     * @param DLDC
     */
    public void setDialogue(DialogueLigneDeCommande DLDC) {
        this.dialogue = DLDC;
    }

    /**
     * initialiser le jeu
     * @param nbplayers
     * @param nom
     */
    public void Initialiser(int nbplayers, String nom) {
        this.creerJoueurs(nbplayers, "nom");
        this.DistribuerCartes();
        this.QuiDistribue();
        this.ChoisirquiJoue();
        this.senshorraire = true;


    }

    /**
     * fin du jeu cest le main du joueur est vide
     * @return
     */
    public boolean fin_jeu() {
        for (Joueur j : players) {
            if (this.players.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * nb du joueurs
     * @return
     */
    public int getnbPlayer() {
        return this.players.size();
    }

    /**
     * sens du joue
     * @return vrai si clockwise sinon faux
     */
    public boolean Senshorraire() {
        return this.senshorraire;
    }

    /**
     * verifie si le joueur est humain
     * @param player
     * @return
     */
    public boolean isPlayerHumain(Joueur player) {
        for (Joueur i : players) {
            if (players.indexOf(i) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * sens de joue
     * @param coup
     */
    public void jouer(String coup) {
        this.players.get(getCurrent_player()).jouer(coup);
        if(Senshorraire()){
            if( this.Current_player>=getnbPlayer()){
                this.Current_player=0;
            }
            this.Current_player++;
        }
        else{
            if( this.Current_player<=0){
                this.Current_player=getnbPlayer()-1;
            }
            Current_player --;
        }

    }
}

