/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Commun.InterfaceAffichageClient;
import Commun.InterfaceSujetDiscussion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author mon pc
 */
public class SujetDiscussion extends UnicastRemoteObject  implements InterfaceSujetDiscussion{
    String sujet;
    ArrayList<InterfaceAffichageClient> clients;
    public SujetDiscussion() throws RemoteException{
        
        clients=new ArrayList();
    }
    public void CreerSujetDiscussion(String sujet) throws RemoteException{
        this.sujet=sujet;
    }
    @Override
    public void inscription(InterfaceAffichageClient c) throws RemoteException {
        clients.add(c);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desincription(InterfaceAffichageClient c) throws RemoteException {
        clients.remove(c);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void diffuse(String message) throws RemoteException {
        for(InterfaceAffichageClient client:clients){
            client.affiche(message);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
