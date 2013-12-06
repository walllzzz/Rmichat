/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Commun.InterfaceServeurForum;
import Commun.InterfaceSujetDiscussion;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author mon pc
 */
public class ChoisirSujetGUI extends JFrame{
    JPanel panel;
    JList list;
    JButton miseAjour;
    JButton inscription;
    InterfaceServeurForum server;
     DefaultListModel model = new DefaultListModel();
    ChoisirSujetGUI(InterfaceServeurForum server) {
        super();
        this.server=server;
        panel=new JPanel();
        list = new JList();
        list.setModel(model);
        getSujet();
         //data has type Object[]
        
        miseAjour=new JButton("mise A jour de la liste");
        miseAjour.addActionListener(new ActionListener() {
			  
	            public void actionPerformed(ActionEvent e)
	            {
                        System.out.println("getting sujets");
	                getSujet();
                        
	            }
	        });
        inscription=new JButton("Inscription");
        inscription.addActionListener(new ActionListener() {
			  
	            public void actionPerformed(ActionEvent e)
	            {
                        inscriptionSujet();
                        
	            }
	        });
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        panel.add(listScroller);
        panel.add(miseAjour);
        panel.add(this.inscription);
        this.add(panel);
        this.setVisible(true);
        this.setSize(400, 400);
    }
    public void inscriptionSujet(){
        try {
            String sujetSelec=list.getSelectedValue().toString();
            InterfaceSujetDiscussion sujet=server.obtientSujet(sujetSelec);
            AffichageClient client=new AffichageClient(sujet);
           
            sujet.inscription(client);
            
        } catch (RemoteException ex) {
            Logger.getLogger(ChoisirSujetGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getSujet(){
        try {
            InterfaceSujetDiscussion[] sujets=server.getSujets();
            model.removeAllElements();
            for(InterfaceSujetDiscussion sj: sujets){
                try {
                    model.addElement(sj.getSujet());
                } catch (RemoteException ex) {
                    Logger.getLogger(ChoisirSujetGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
           // list=new JList(model);
        } catch (RemoteException ex) {
            Logger.getLogger(ChoisirSujetGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ChoisirSujetGUI(){
       
    }
     public static void main(String args[]) {
        ChoisirSujetGUI ch=new ChoisirSujetGUI();
        
     }

   
    
}
