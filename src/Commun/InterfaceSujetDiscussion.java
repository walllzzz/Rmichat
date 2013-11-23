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
public interface InterfaceSujetDiscussion extends Remote {
    public void inscription(InterfaceAffichageClient c) throws RemoteException;
    public void desincription(InterfaceAffichageClient c) throws RemoteException;
    public void diffuse(String message) throws RemoteException;
}
