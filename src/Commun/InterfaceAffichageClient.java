/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commun;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author mon pc
 */
public interface InterfaceAffichageClient extends Remote {
    public void affiche(String message) throws RemoteException;
}
