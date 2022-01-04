package uno.cartes;
import uno.cartes.*;
import uno.Uno;

public abstract class Joueur {
    protected  Uno uno;
    protected PaquetDeCartes main;
    protected String name;
    protected int numero;
    protected int score;
    protected String nom;

    /**
     * Constructeur du Joueur
     * @param nom le nom du joueur (humain pas bot)
     * @param uno
     * @param numero le numero du joueur
     */

    public Joueur(String nom,Uno uno,int numero){
        this.uno= uno;
        this.numero= numero;
        this.nom=nom;
        this.main=new PaquetDeCartes();
        this.score = 0;
    }

    /**
     * fonction abstract jouer
     * @param coup le choix
     */
    public abstract void jouer(String coup);

    /**
     * fonction absract CarteChoisie
     * @param coup le choix
     * @return une carte choisie par le humain ou bot
     * @throws Exception si le choix incorrect
     */
    public abstract Carte CarteChoisie(String coup) throws Exception;

    /***
     * fonction abstract isPlayerHumain
     * @return true si le joueur est humain , false sinon
     */
    public abstract boolean isPlayerHumain();

    /**
     * fonction recoit Cartew
     * @param c
     */
    public void recoitCarte(Carte c)
    {
        this.main.ajouter(c);
    }

    public PaquetDeCartes getmain() {
        return main;
    }
    public int getScore()
    {
        return score;
    }
    public void increment_score(int nb)
    {
        this.score +=nb;
    }
    public  String getnom(){
        return nom;
    }




}

