/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Commun.InterfaceServeurForum;
import Commun.InterfaceSujetDiscussion;
import Serveur.SujetDiscussion;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mon pc
 */
public class FournisseurDeSujet {
    private static InterfaceServeurForum getServer() {
    InterfaceServeurForum server = null;
    String URL="//localhost:8686/RmiServer";
    try {
      server = (InterfaceServeurForum) Naming.lookup(URL);
    } catch (MalformedURLException e) {
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
          "URL Exception", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    } catch (RemoteException e) {
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
          "Remote Exception", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    } catch (NotBoundException e) {
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
          "Not Bound Exception", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    } 

    return server;
  }
    public static void main(String args[]) {
        String name = "coucou";
   
        try {
            String  sujet = JOptionPane.showInputDialog(null,"Saississez le titre de sujet", "Sujet");
            FournisseurDeSujet fournisseur=new FournisseurDeSujet();
            InterfaceServeurForum server = fournisseur.getServer();
            SujetDiscussion subject = new SujetDiscussion();
          
            subject.CreerSujetDiscussion(sujet);
            server.addSujetDiscussion(subject);
      // subject creation
     // server.createSubject(subject);
            
            /*if (server != null) {
                
              ClientView client = new ClientView(server, name);
              try {
                client.display();
              } catch (RemoteException e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
                    "Remote Exception", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
              }
            }*/
        } catch (RemoteException ex) {
            Logger.getLogger(AffichageClient.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
