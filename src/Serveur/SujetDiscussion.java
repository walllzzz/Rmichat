/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Commun.InterfaceAffichageClient;
import Commun.InterfaceSujetDiscussion;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author mon pc
 */
public class SujetDiscussion implements InterfaceSujetDiscussion{
    String sujet;
    ArrayList<InterfaceAffichageClient> clients;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
