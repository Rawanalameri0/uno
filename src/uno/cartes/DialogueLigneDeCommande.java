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
        int nbPlayers = scan.nextInt();
        String nomPlayer = scan.next();
        uno.Initialiser(nbPlayers,nomPlayer);

    }

    public void regair(){
        uno.top_talon();


    }

}
