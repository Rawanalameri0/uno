package cartes;
import cartes.*;



public class FabriqueCartes{

    private static FabriqueCartes instance = new FabriqueCartes();


    /**
     * @return l'instance de fabrique Cartes
     */
    public static FabriqueCartes getInstance(){
        return instance;
    }

    /**
     * Constructeur privé de FabriqueCartes
     */

    private FabriqueCartes()
    {

    }
    /**
     * @return paquet de cartes vide
     */
    public PaquetDeCartes getPaquetVide()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        return pdc;
    }
    /**
     * @return paquet de cartes avec une carte verte de valeur 1
     */
    public PaquetDeCartes getPaquet1Vert()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        Carte carte = new Carte(1, Couleur.VERT);
        pdc.ajouter(carte);
        return pdc;
    }

    /**
     * @return paquet de cartes avec une carte verte de valeur 5
     */
    public PaquetDeCartes getPaquet5Vert()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        Carte carte = new Carte(5, Couleur.VERT);
        pdc.ajouter(carte);
        return pdc;
    }









}