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
public class MecanicForm {
    
    private JFrame frame;
    
    private final int AMPLADA = 300;
    private final int ALCADA = 200;
    
    JLabel lNif;
    JTextField tNif;
    JLabel lNom;
    JTextField tNom;
    JLabel lTelefon;
    JTextField tTelefon;
    JLabel lCorreu;
    JTextField tCorreu;
    
    JButton desar;
    JButton sortir;
    
    public MecanicForm() {
    
        frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1));

        lNif = new JLabel("Nif");
        tNif = new JTextField(10);
        lNom = new JLabel("Nom");
        tNom = new JTextField(10);
        lTelefon = new JLabel("Telefon");
        tTelefon = new JTextField(10);
        lCorreu = new JLabel("Correu");
        tCorreu = new JTextField(10);
        
        desar = new JButton("Desar");
        sortir = new JButton("Sortir");
        
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
    
    
    public MecanicForm(String nif, String nom, String telefon, String correu){
        this();
        tNif.setText(nif);
        tNom.setText(nom);
        tTelefon.setText(telefon);
        tCorreu.setText(correu);
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

    public JLabel getlNif() {
        return lNif;
    }

    public JTextField gettNif() {
        return tNif;
    }

    public JLabel getlNom() {
        return lNom;
    }

    public JTextField gettNom() {
        return tNom;
    }

    public JLabel getlTelefon() {
        return lTelefon;
    }

    public JTextField gettTelefon() {
        return tTelefon;
    }

    public JLabel getlCorreu() {
        return lCorreu;
    }

    public JTextField gettCorreu() {
        return tCorreu;
    }

    public JButton getDesar() {
        return desar;
    }

    public JButton getSortir() {
        return sortir;
    }
  
    
}
