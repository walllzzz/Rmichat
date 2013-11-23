/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Commun.InterfaceAffichageClient;
import Commun.InterfaceServeurForum;
import Commun.InterfaceSujetDiscussion;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mon pc
 */
public class AffichageClient extends UnicastRemoteObject implements InterfaceAffichageClient{
    public AffichageClient() throws RemoteException{
        
    }
    @Override
    public void affiche(String message) throws RemoteException {
        System.out.println("message: "+message);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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
             AffichageClient client=new AffichageClient();
            InterfaceServeurForum server = client.getServer();
            InterfaceSujetDiscussion sujet=server.obtientSujet("books");
            sujet.inscription(client);
            System.out.println("message diffuser");
            sujet.diffuse("coucou");
            
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
