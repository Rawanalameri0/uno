package uno.cartes;

public enum Couleur{

    ROUGE("Rouge"),
    JAUNE("Jaune"),
    BLEU("Bleu"),
    VERT("Vert");

    private String nom;

    private Couleur (String nom)
    {
        this.nom=nom;
    }



    public String getNom(){
        return this.nom;
    }


    private static void TestCouleur()
    {
        Couleur c = Couleur.VERT;
        assert(c.getNom()=="Vert"): "Bug la couleur entrée n'est pas correcte";

    }

    public String toString(){
        return this.nom;
    }



}
