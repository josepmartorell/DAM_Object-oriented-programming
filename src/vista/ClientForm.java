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
public class ClientForm {
    
    private JFrame frame;
    
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lNif;
    private JTextField tNif;
    private JLabel lNom;
    private JTextField tNom;
    private JLabel lTelefon;
    private JTextField tTelefon;
    private JLabel lCorreu;
    private JTextField tCorreu;

    private JButton desar;   
    private JButton sortir;   

    public ClientForm() {

        frame = new JFrame("Client Taller");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lNif = new JLabel("Nif");
        tNif = new JTextField(10);
        lNom = new JLabel("Nom");
        tNom = new JTextField(20);
        lTelefon = new JLabel("Telefon");
        tTelefon = new JTextField(20);
        lCorreu = new JLabel("Correu");
        tCorreu = new JTextField(10);

        //Creació dels botons del formulari
        desar = new JButton("Desar");
        sortir = new JButton("Sortir");

        //Addició del tot el formulari a la finestra
        frame.add(lNif);
        frame.add(tNif);
        frame.add(lNom);
        frame.add(tNom);
        frame.add(lTelefon);
        frame.add(tTelefon);
        frame.add(lCorreu);
        frame.add(tCorreu);
        frame.add(desar);       
        frame.add(sortir);

        showFinestra();
    }
    
    public ClientForm(String codi, String nom, String fabricant, double preu){
        this();
        tNif.setText(codi);
        tNom.setText(nom);
        tTelefon.setText(fabricant);
        tCorreu.setText(String.valueOf(preu));
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

    public JLabel getlNif() {
        return lNif;
    }

    public void setlNif(JLabel lNif) {
        this.lNif = lNif;
    }

    public JTextField gettNif() {
        return tNif;
    }

    public void settNif(JTextField tCodi) {
        this.tNif = tNif;
    }

    public JLabel getlNom() {
        return lNom;
    }

    public void setlNom(JLabel lNom) {
        this.lNom = lNom;
    }

    public JTextField gettNom() {
        return tNom;
    }

    public void settNom(JTextField tNom) {
        this.tNom = tNom;
    }

    public JLabel getlTelefon() {
        return lTelefon;
    }

    public void setlTelefon(JLabel lFabricant) {
        this.lTelefon = lTelefon;
    }

    public JTextField gettTelefon() {
        return tTelefon;
    }

    public void settTelefon(JTextField tTelefon) {
        this.tTelefon = tTelefon;
    }

    public JLabel getlCorreu() {
        return lCorreu;
    }

    public void setlCorreu(JLabel lCorreu) {
        this.lCorreu = lCorreu;
    }

    public JTextField gettCorreu() {
        return tCorreu;
    }

    public void settPreu(JTextField tCorreu) {
        this.tCorreu = tCorreu;
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
