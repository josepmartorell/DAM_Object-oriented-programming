/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jtech
 */
public class ReparacioForm {
        
    private JFrame frame;
    
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lCodi;
    private JTextField tCodi;
    private JLabel lDataInici;
    private JTextField tDataInici;
    private JLabel lDataFi;
    private JTextField tDataFi;

    private JButton desar;   
    private JButton sortir; 

    public ReparacioForm() {
        
        frame = new JFrame("Reparacio Taller");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lCodi = new JLabel("Codi");
        tCodi = new JTextField(10);
        lDataInici = new JLabel("Data Inici");
        tDataInici = new JTextField(20);
        lDataFi = new JLabel("Data Fi");
        tDataFi = new JTextField(20);

        //Creació dels botons del formulari
        desar = new JButton("Desar");
        sortir = new JButton("Sortir");

        //Addició del tot el formulari a la finestra
        frame.add(lCodi);
        frame.add(tCodi);
        frame.add(lDataInici);
        frame.add(tDataInici);
        frame.add(lDataFi);
        frame.add(tDataFi);
        frame.add(desar);       
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

    public JLabel getlCodi() {
        return lCodi;
    }

    public JTextField gettCodi() {
        return tCodi;
    }

    public JLabel getlDataInici() {
        return lDataInici;
    }

    public JTextField gettDataInici() {
        return tDataInici;
    }

    public JLabel getlDataFi() {
        return lDataFi;
    }

    public JTextField gettDataFi() {
        return tDataFi;
    }

    public JButton getDesar() {
        return desar;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setlCodi(JLabel lCodi) {
        this.lCodi = lCodi;
    }

    public void settCodi(JTextField tCodi) {
        this.tCodi = tCodi;
    }

    public void setlDataInici(JLabel lDataInici) {
        this.lDataInici = lDataInici;
    }

    public void settDataInici(JTextField tDataInici) {
        this.tDataInici = tDataInici;
    }

    public void setlDataFi(JLabel lDataFi) {
        this.lDataFi = lDataFi;
    }

    public void settDataFi(JTextField tDataFi) {
        this.tDataFi = tDataFi;
    }

    public void setDesar(JButton desar) {
        this.desar = desar;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }
 
    
}
