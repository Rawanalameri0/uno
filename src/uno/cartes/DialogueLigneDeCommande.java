package uno.cartes;
import uno.*;
import uno.cartes.*;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Uno uno;
    private Scanner scan;
    private boolean fin_jeu;

    public DialogueLigneDeCommande(Uno uno) {
        this.uno = uno;
        this.fin_jeu = false;
        this.scan = new Scanner(System.in);
        this.uno.setDialogue(this);
        System.out.println("Choisissez le nombre de joueurs?");
        int nbPlayers = scan.nextInt();
        while(nbPlayers<2 || nbPlayers>7)
        {
            System.out.println("Incorrecte choisissez un nombre >0 et nombre<=5?!!!");
            System.out.println("Choisissez le nombre de joueurs?");
             nbPlayers = scan.nextInt();

        }
        System.out.println("Entrez votre nom");
        String nomPlayer = scan.next();
        this.uno.Initialiser(nbPlayers, nomPlayer);

    }

    public void regair() {
        String coup = null;
        Joueur player;
            while(!fin_jeu){
                System.out.println("Le Sommet du talon du jeu: " + uno.top_talon().toString());
                for(int i=1;i<uno.getnbPlayer();i++)
                {
                    System.out.println("Main de bot"+i+"-"+uno.getPlayer(i).getmain().toString());
                }
                if(uno.isPlayerHumain(uno.getPlayer(uno.getCurrent_player()))){
                    System.out.println("Votre main est:" +uno.getPlayer(uno.getCurrent_player()).getmain().toString());
                    System.out.println("Quelle carte voulez-vous jouer?");
                    System.out.println("Choisi l'indice de vos cartes et les couleurs(v,b,j,r)");
                    coup = scan.next();
                }
                this.uno.jouer(coup);








            }

    }




    /*public void score_jeu()
    {
        if (uno.getnbPlayer(uno.getCurrent_player().getMain().getNombresdeCartes()== 0)
        {
            System.out.println("Votre score est: ");
        }

    }*/

}

