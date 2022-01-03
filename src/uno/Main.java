package uno;

import uno.cartes.DialogueLigneDeCommande;

public class Main {
    public static void main(String[] args){
        Uno uno = new Uno();
        DialogueLigneDeCommande dldc = new DialogueLigneDeCommande(uno);
        dldc.regair();
    }
}
