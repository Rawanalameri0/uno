package uno.cartes;
import uno.*;
import uno.cartes.*;
import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Uno uno;
    private Scanner scan;

    public DialogueLigneDeCommande (Uno uno){
        this.uno= uno;
        this.scan=new Scanner(System.in);
        uno.setDialogue(this);
        System.out.println("Choisir combien de joueurs?");
        int nbPlayers = scan.nextInt();
        if(nbPlayers<1 && nbPlayers>6){
           nbPlayers=5;
        }
        System.out.println("Entrez votre nom");
        String nomPlayer = scan.next();
        uno.Initialiser(nbPlayers,nomPlayer);

    }

    public void regair(){

    }

}
