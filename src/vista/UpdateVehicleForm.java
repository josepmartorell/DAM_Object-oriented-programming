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
public class UpdateVehicleForm {
    
    private JFrame frame;
    
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lMatricula;
    private JTextField tMatricula;
    private JLabel lMarca;
    private JTextField tMarca;
    private JLabel lModel;
    private JTextField tModel;
    private JLabel lColor;
    private JTextField tColor;

    private JButton desar;   
    private JButton sortir;  
    
    public UpdateVehicleForm(String object, String VAR1, String VAR2, String VAR3, String VAR4) {
        
        //Definició de la finestra
        frame = new JFrame("Modificar Vehicle");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lMatricula = new JLabel("MATRICULA");
        tMatricula = new JTextField(VAR1);
        tMatricula.setEditable(false);
        tMatricula.setBackground(Color.white);
        lMarca = new JLabel("Marca");
        tMarca = new JTextField(VAR2);
        lModel = new JLabel("Model");
        tModel = new JTextField(VAR3);
        lColor = new JLabel("Color");
        tColor = new JTextField(VAR4);

        //Creació dels botons del formulari
        desar = new JButton("Desar");
        sortir = new JButton("Sortir");

        //Addició del tot el formulari a la finestra
        frame.add(lMatricula);
        frame.add(tMatricula);
        frame.add(lMarca);
        frame.add(tMarca);
        frame.add(lModel);
        frame.add(tModel);
        frame.add(lColor);
        frame.add(tColor);
        frame.add(desar);       
        frame.add(sortir);

        showFinestra();
    }
    
    public UpdateVehicleForm(String matricula, String marca, String model, String color){
        tMatricula.setText(matricula);
        tMarca.setText(marca);
        tModel.setText(model);
        tColor.setText(color);
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

    public JLabel getlMatricula() {
        return lMatricula;
    }

    public void setlMatricula(JLabel lMatricula) {
        this.lMatricula = lMatricula;
    }

    public JTextField gettMatricula() {
        return tMatricula;
    }

    public void settMatricula(JTextField tMatricula) {
        this.tMatricula = tMatricula;
    }

    public JLabel getlMarca() {
        return lMarca;
    }

    public void setlMarca(JLabel lMarca) {
        this.lMarca = lMarca;
    }

    public JTextField gettMarca() {
        return tMarca;
    }

    public void settMarca(JTextField tMarca) {
        this.tMarca = tMarca;
    }

    public JLabel getlModel() {
        return lModel;
    }

    public void setlModel(JLabel lModel) {
        this.lModel = lModel;
    }

    public JTextField gettModel() {
        return tModel;
    }

    public void settModel(JTextField tModel) {
        this.tModel = tModel;
    }

    public JLabel getlColor() {
        return lColor;
    }

    public void setlColor(JLabel lColor) {
        this.lColor = lColor;
    }

    public JTextField gettColor() {
        return tColor;
    }

    public void settColor(JTextField tColor) {
        this.tColor = tColor;
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
