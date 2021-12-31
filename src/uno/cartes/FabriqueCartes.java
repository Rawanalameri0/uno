package uno.cartes;


import uno.*;

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



    public PaquetDeCartes Paquet_UNO()
    {
        Uno uno = new Uno();
        PaquetDeCartes pdc = new PaquetDeCartes();
        Carte chiffre1 = new Chiffre(uno, Couleur.BLEU,0);
        Carte chiffre2 = new Chiffre(uno,Couleur.JAUNE,0);
        Carte chiffre3 = new Chiffre(uno,Couleur.VERT,0);
        Carte chiffre4 = new Chiffre(uno,Couleur.ROUGE,0);
        pdc.ajouter(chiffre1,chiffre2,chiffre3,chiffre4);

        for(int i=1; i<=9 ; i++)
        {
            pdc.ajouter(new Chiffre(uno,Couleur.BLEU,i),new Chiffre(uno,Couleur.BLEU,i));
            pdc.ajouter(new Chiffre(uno,Couleur.JAUNE,i),new Chiffre(uno,Couleur.JAUNE,i));
            pdc.ajouter(new Chiffre(uno,Couleur.ROUGE,i),new Chiffre(uno,Couleur.ROUGE,i));
            pdc.ajouter(new Chiffre(uno,Couleur.VERT,i),new Chiffre(uno,Couleur.VERT,i));
        }

        for(int n=0; n<=2 ;n++)
        {
            pdc.ajouter(new ChangementDeSens(uno,Couleur.BLEU));
            pdc.ajouter(new ChangementDeSens(uno,Couleur.JAUNE));
            pdc.ajouter(new ChangementDeSens(uno,Couleur.VERT));
            pdc.ajouter(new ChangementDeSens(uno,Couleur.ROUGE));
            pdc.ajouter(new PasseTonTour(uno,Couleur.BLEU));
            pdc.ajouter(new PasseTonTour(uno,Couleur.JAUNE));
            pdc.ajouter(new PasseTonTour(uno,Couleur.ROUGE));
            pdc.ajouter(new PasseTonTour(uno,Couleur.VERT));
            pdc.ajouter(new Plus2(uno,Couleur.BLEU));
            pdc.ajouter(new Plus2(uno,Couleur.JAUNE));
            pdc.ajouter(new Plus2(uno,Couleur.ROUGE));
            pdc.ajouter(new Plus2(uno,Couleur.VERT));

        }

        for(int j=0; j<=4;j++)
        {
            pdc.ajouter(new Plus4(uno,null));
            pdc.ajouter(new Jocker(uno,null));
        }
        return pdc;
    }


    public  PaquetDeCartes getPaquetVide()
    {
        PaquetDeCartes pdc = new PaquetDeCartes();
        return pdc;
    }



}