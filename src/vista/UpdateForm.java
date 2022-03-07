/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
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
public class UpdateForm {
    
        private JFrame frame;
    
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lCif;
    private JTextField tCif;
    private JLabel lNom;
    private JTextField tNom;
    private JLabel lAdreca;
    private JTextField tAdreca;
    private JLabel lNif;
    private JTextField tNif;
    private JLabel lTelefon;
    private JTextField tTelefon;
    private JLabel lCorreu;
    private JTextField tCorreu;

    private JButton desar;   
    private JButton sortir;   

    public UpdateForm() {
        
        //Definició de la finestra del menú
        frame = new JFrame("Modificar Taller");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lCif = new JLabel("CIF");
        tCif = new JTextField(ControladorPrincipal.getTallerActual().getCif());
        tCif.setEditable(false);
        tCif.setBackground(Color.white);
        lNom = new JLabel("Nom");
        tNom = new JTextField(ControladorPrincipal.getTallerActual().getNom());
        lAdreca = new JLabel("Adreça");
        tAdreca = new JTextField(ControladorPrincipal.getTallerActual().getAdreca());

        //Creació dels botons del formulari
        desar = new JButton("Desar");
        sortir = new JButton("Sortir");

        //Addició del tot el formulari a la finestra
        frame.add(lCif);
        frame.add(tCif);
        frame.add(lNom);
        frame.add(tNom);
        frame.add(lAdreca);
        frame.add(tAdreca);
        frame.add(desar);       
        frame.add(sortir);

        showFinestra();
    }
    
    public UpdateForm(String cif, String nom, String adreca){
        this();
        tCif.setText(cif);
        tNom.setText(nom);
        tAdreca.setText(adreca);
    }
    
    //TODO
    public UpdateForm(String object, String VAR1, String VAR2, String VAR3, String VAR4) {
        
        //Definició de la finestra del menú
        frame = new JFrame("Modificar " + object);
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lNif = new JLabel("NIF");
        tNif = new JTextField(VAR1);
        tNif.setEditable(false);
        tNif.setBackground(Color.white);
        lNom = new JLabel("Nom");
        tNom = new JTextField(VAR2);
        lTelefon = new JLabel("Telefon");
        tTelefon = new JTextField(VAR3);
        lCorreu = new JLabel("Correu");
        tCorreu = new JTextField(VAR4);

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
    
    public UpdateForm(String nif, String nom, String telefon, String correu){
        tCif.setText(nif);
        tNom.setText(nom);
        tNom.setText(telefon);
        tNom.setText(correu);
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

    public JLabel getlCif() {
        return lCif;
    }

    public void setlCif(JLabel lCif) {
        this.lCif = lCif;
    }

    public JTextField gettCif() {
        return tCif;
    }

    public void settCif(JTextField tCif) {
        this.tCif = tCif;
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

    public JLabel getlAdreca() {
        return lAdreca;
    }

    public void setlAdreca(JLabel lAdreca) {
        this.lAdreca = lAdreca;
    }

    public JTextField gettAdreca() {
        return tAdreca;
    }

    public void settAdreca(JTextField tAdreca) {
        this.tAdreca = tAdreca;
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

    public void settNif(JTextField tNif) {
        this.tNif = tNif;
    }

    public JLabel getlTelefon() {
        return lTelefon;
    }

    public void setlTelefon(JLabel lTelefon) {
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

    public void settCorreu(JTextField tCorreu) {
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
