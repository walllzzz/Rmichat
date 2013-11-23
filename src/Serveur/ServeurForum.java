/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Commun.InterfaceServeurForum;
import Commun.InterfaceSujetDiscussion;
import java.awt.Frame;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mon pc
 */
public class ServeurForum extends UnicastRemoteObject implements InterfaceServeurForum{
    ArrayList<InterfaceSujetDiscussion> sujets;
    public ServeurForum() throws RemoteException{
        sujets=new ArrayList();
    }
    
    @Override
    public InterfaceSujetDiscussion obtientSujet(String titre) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public static void main(String args[]) {
    try {
      // creation du serveur de forum et enregistrement sur le reseau
      LocateRegistry.createRegistry(8686);
      InterfaceServeurForum server = new ServeurForum();
      String URL="localhost";
      Naming.bind(URL, server);
      System.out.println("Démarrage du serveur...");

      JOptionPane.showMessageDialog(new Frame(),
          "Quit this panel to close the server.", "Server Connected",
          JOptionPane.WARNING_MESSAGE);
      System.exit(0);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
}
