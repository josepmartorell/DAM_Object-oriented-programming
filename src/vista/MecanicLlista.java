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
public class MecanicLlista {
    
    private JFrame frame;
    
    private final int AMPLADA = 600;
    private final int ALCADA = 200;
    
    private JTable tMecanics;

    private JButton sortir;
    
    public MecanicLlista(){
    
        frame = new JFrame("Llista de Mecanics");
        frame.setLayout(new GridLayout(0, 1));
        
        tMecanics = new JTable(new MecanicTableModel());
        
        sortir = new JButton("Sortir");
        
        frame.add(new JScrollPane(tMecanics));
        frame.add(sortir);
        
        showFinestra();
        
        
    }
    
    private void showFinestra(){
        
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable gettClients() {
        return tMecanics;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void settClients(JTable tClients) {
        this.tMecanics = tClients;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }
    
    
    
}
