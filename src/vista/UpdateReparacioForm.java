/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jtech
 */
public class UpdateReparacioForm {
    
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
    
    public UpdateReparacioForm(String object, String VAR1, String VAR2, String VAR3) {
        
        //Definició de la finestra
        frame = new JFrame("Modificar " + object);
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lCodi = new JLabel("CODI");
        tCodi = new JTextField(VAR1);
        tCodi.setEditable(false);
        tCodi.setBackground(Color.white);
        lDataInici = new JLabel("Data Inici");
        tDataInici = new JTextField(VAR2);
        lDataFi = new JLabel("Data Fi");
        tDataFi = new JTextField(VAR3);

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
    
    public UpdateReparacioForm(String codi, String dataInici, String dataFi){
        tCodi.setText(codi);
        tDataInici.setText(dataInici);
        tDataFi.setText(dataFi);
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

    public JLabel getlCodi() {
        return lCodi;
    }

    public void setlCodi(JLabel lCodi) {
        this.lCodi = lCodi;
    }

    public JTextField gettCodi() {
        return tCodi;
    }

    public void settCodi(JTextField tCodi) {
        this.tCodi = tCodi;
    }

    public JLabel getlDataInici() {
        return lDataInici;
    }

    public void setlDataInici(JLabel lDataInici) {
        this.lDataInici = lDataInici;
    }

    public JTextField gettDataInici() {
        return tDataInici;
    }

    public void settDataInici(JTextField tDataInici) {
        this.tDataInici = tDataInici;
    }

    public JLabel getlDataFi() {
        return lDataFi;
    }

    public void setlDataFi(JLabel lDataFi) {
        this.lDataFi = lDataFi;
    }

    public JTextField gettDataFi() {
        return tDataFi;
    }

    public void settDataFi(JTextField tDataFi) {
        this.tDataFi = tDataFi;
    }

    public JButton getDesar() {
        return desar;
    }

    public void setDesar(JButton desar) {
        this.desar = desar;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }

    
}

