/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author mon pc
 */
public interface InterfaceServeurForum extends Remote {
    public void addSujetDiscussion(InterfaceSujetDiscussion sujet) throws RemoteException;
    public InterfaceSujetDiscussion obtientSujet(String titre) throws RemoteException;
    public InterfaceSujetDiscussion[] getSujets() throws RemoteException;

} 
