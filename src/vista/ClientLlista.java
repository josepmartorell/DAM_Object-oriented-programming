/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author jtech
 */
public class ClientLlista {
    
    private JFrame frame;
    
    private final int AMPLADA = 600;
    private final int ALCADA = 200;
    
    private JTable tClients;

    private JButton sortir;   
    

    public ClientLlista() {
        frame = new JFrame("Llista de Clients");
        frame.setLayout(new GridLayout(0, 1));

        tClients = new JTable(new ClientTableModel());
        
        sortir = new JButton("Sortir");

        frame.add(new JScrollPane(tClients));  
        frame.add(sortir);

        showFinestra();
    }
    
    private void showFinestra(){
        //Es mostra la finestra amb propietats per defecte
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable gettClients() {
        return tClients;
    }

    public void settClients(JTable tClients) {
        this.tClients = tClients;
    }    

    public JButton getSortir() {
        return sortir;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }
    
}
