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
public class VehicleForm {
    
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

    public VehicleForm() {
        
        frame = new JFrame("Vehicle Taller");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lMatricula = new JLabel("Matricula");
        tMatricula = new JTextField(10);
        lMarca = new JLabel("Marca");
        tMarca = new JTextField(20);
        lModel = new JLabel("Model");
        tModel = new JTextField(20);
        lColor = new JLabel("Color");
        tColor = new JTextField(10);

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
    
    public VehicleForm(String matricula, String marca, String model, String color){
        this();
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

    public JLabel getlMatricula() {
        return lMatricula;
    }

    public JTextField gettMatricula() {
        return tMatricula;
    }

    public JLabel getlMarca() {
        return lMarca;
    }

    public JTextField gettMarca() {
        return tMarca;
    }

    public JLabel getlModel() {
        return lModel;
    }

    public JTextField gettModel() {
        return tModel;
    }

    public JLabel getlColor() {
        return lColor;
    }

    public JTextField gettColor() {
        return tColor;
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

    public void setlMatricula(JLabel lMatricula) {
        this.lMatricula = lMatricula;
    }

    public void settMatricula(JTextField tMatricula) {
        this.tMatricula = tMatricula;
    }

    public void setlMarca(JLabel lMarca) {
        this.lMarca = lMarca;
    }

    public void settMarca(JTextField tMarca) {
        this.tMarca = tMarca;
    }

    public void setlModel(JLabel lModel) {
        this.lModel = lModel;
    }

    public void settModel(JTextField tModel) {
        this.tModel = tModel;
    }

    public void setlColor(JLabel lColor) {
        this.lColor = lColor;
    }

    public void settColor(JTextField tColor) {
        this.tColor = tColor;
    }

    public void setDesar(JButton desar) {
        this.desar = desar;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }
    
    

    
    
    
    
    
}
