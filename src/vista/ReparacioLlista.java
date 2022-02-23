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
public class ReparacioLlista {
    
    private JFrame frame;
    
    private final int AMPLADA = 600;
    private final int ALCADA = 200;
    
    private JTable tReparacions;
    
    private JButton sortir;

    public ReparacioLlista() {
        
        frame = new JFrame("Llista de Reparacions");
        frame.setLayout(new GridLayout(0, 1));
        
        tReparacions = new JTable(new ReparacioTableModel());
        
        sortir = new JButton("Sortir");
        
        frame.add(new JScrollPane(tReparacions));
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

    public JTable gettReparacions() {
        return tReparacions;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void settReparacions(JTable tReparacions) {
        this.tReparacions = tReparacions;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }
    
    
    
    
    
    
}
