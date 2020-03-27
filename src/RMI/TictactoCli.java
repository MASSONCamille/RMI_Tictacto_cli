package RMI;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TictactoCli {
    private static RMIInterface look_up;

    public static void  main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        try {
            int port = 8000;
            look_up = (RMIInterface) Naming.lookup("rmi://localhost:" + port + "/tictacto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        System.out.println(look_up.ReStart());

        int i;
        boolean fin = false;
        while (!fin) {

            i = Integer.parseInt(JOptionPane.showInputDialog("Tour du J"+look_up.getPlayer()+" (1 à 9): "));
            if (look_up.Play(i)){
                System.out.println(look_up.ImprGrille());

                fin = look_up.TestGagne(i);
                if (fin) System.out.println("Fin du jeu victoire de J"+look_up.getPlayer());
                else {
                    fin = look_up.TestEgal();
                    if (fin) System.out.println("Fin du jeu égalité");
                }

                look_up.NextPlayer();
            }else System.out.println("Case deja prise !");

        }

    }
}