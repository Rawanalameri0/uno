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

    public Carte top_talon() {
        return this.talon.getSommet();

    }

    public int getCurrent_player() {
        return this.Current_player;
    }


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


    public void creerJoueurs(int nbplayers, String nom) {
        this.players = new ArrayList<Joueur>(nbplayers);
        this.players.add(new JoueurHumain(nom, this, 0));
        for (int j = 1; j < nbplayers; j++) {
            this.players.add(new Bot("PLAYER_BOT", this, j));
        }
    }

    public Joueur getPlayer(int i) {
        return this.players.get(i);

    }

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

    public void effet_pass_ton_tour() {

        players.get(getCurrent_player() + 1);
    }

    public void effetChangementdeSens() {
        if (senshorraire) {
            senshorraire = false;
        }


    }

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

    public int QuiDistribue() {
        return this.joueurquidistrbue = 0; //premier joueur

    }

    public int ChoisirquiJoue() {
        return QuiDistribue();

    }

    public void ajouter_talon(Carte c) {

        this.talon.ajouter(c);
    }


    public void setDialogue(DialogueLigneDeCommande DLDC) {
        this.dialogue = DLDC;
    }


    public void Initialiser(int nbplayers, String nom) {
        this.creerJoueurs(nbplayers, "nom");
        this.DistribuerCartes();
        this.QuiDistribue();
        this.ChoisirquiJoue();
        this.senshorraire = true;


    }

    public Joueur Player_gagne() {
        for (Joueur j : players) {
            if (j.getmain().estVide()) {
                return j;
            }
        }
        return null;
    }

    public int getnbPlayer() {
        return this.players.size();
    }

    public boolean Senshorraire() {
        return this.senshorraire;
    }

    public boolean isPlayerHumain(Joueur player) {
        for (Joueur i : players) {
            if (players.indexOf(i) == 0) {
                return true;
            }
        }
        return false;
    }


    public void jouer(String coup) {
        if(senshorraire==true){

            this.players.get(getCurrent_player()+1).jouer(coup);
        }
        else{
            this.players.get(getnbPlayer()-1).jouer(coup);
        }



    }


}
