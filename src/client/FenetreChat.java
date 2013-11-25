/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Commun.InterfaceSujetDiscussion;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author mon pc
 */
public class FenetreChat extends JFrame{
    JPanel panel;
    JTextArea textArea;
    JTextField message;
    JButton envoyer;
    JButton desinscription;
    InterfaceSujetDiscussion sujet;
    public FenetreChat(InterfaceSujetDiscussion sujet){
         super();
        panel=new JPanel();
        this.sujet=sujet;
        textArea = new JTextArea(); //data has type Object[]
        envoyer=new JButton("envoyer");
        envoyer.addActionListener(new ActionListener() {			  
	            public void actionPerformed(ActionEvent e)
	            {
                        envoyerMessage();                        
	            }
	        });
        desinscription=new JButton("DesInscription");
        message=new JTextField(40);
        JScrollPane listScroller = new JScrollPane(textArea);
        listScroller.setPreferredSize(new Dimension(350, 300));
        panel.add(listScroller);
        panel.add(message);
        panel.add(envoyer);
        panel.add(this.desinscription);
        this.add(panel);
        this.setVisible(true);
        this.setSize(400, 400);
    }
    public void envoyerMessage(){
        try {
            sujet.diffuse(message.getText());
        } catch (RemoteException ex) {
            Logger.getLogger(FenetreChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void afficherMessage(String message){
        textArea.setText(textArea.getText()+"\n"+message);
    }
      public static void main(String args[]) {
       // FenetreChat ch=new FenetreChat();
        
     }
}
