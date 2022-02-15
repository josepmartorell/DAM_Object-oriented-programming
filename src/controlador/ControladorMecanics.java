/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Mecanic;
import vista.MecanicForm;
import vista.MecanicLlista;
import vista.MenuMecanics;

/**
 *
 * @author jtech
 */
public class ControladorMecanics implements ActionListener{
    
    private MenuMecanics menuMecanics;
    private MecanicForm mecanicForm = null;
    private MecanicLlista mecanicLlista = null;
    private int opcioSelec = 0;
    
    
    public  ControladorMecanics(){
        
        menuMecanics = new MenuMecanics();
        afegirListenersMenu();
    
    }
    
    private void afegirListenersMenu() {

        for (JButton boto : menuMecanics.getMenuButtons()) {
            boto.addActionListener(this);
        }
      
    }
    
    private void afegirListenersForm() {

        mecanicForm.getDesar().addActionListener(this);
        mecanicForm.getSortir().addActionListener(this);

    }
    
    private void afegirListenersLlista() {

        mecanicLlista.getSortir().addActionListener(this);

    }
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        //Accions per al menú
        JButton[] botons = menuMecanics.getMenuButtons();
        for(int i = 0; i < botons.length; i++){
            if(e.getSource() == botons[i]){
                menuMecanics.getFrame().setVisible(false);
                opcioSelec = i;
                seleccionarOpcio(i);      
            
            }     
        }
        
        //Accions per al formulari de clients
        if(mecanicForm != null){
            if(e.getSource() == mecanicForm.getDesar()){
                if(opcioSelec == 1){
                    ControladorPrincipal.getTallerActual().getComponents().add(new Mecanic(mecanicForm.gettNif().getText(), mecanicForm.gettNom().getText(), mecanicForm.gettTelefon().getText(), mecanicForm.gettCorreu().getText()));                
                }
            
            }else if(e.getSource() == mecanicForm.getSortir()){
                mecanicForm.getFrame().setVisible(false);
                menuMecanics.getFrame().setVisible(true);
            
            }
        
        }
        
        if(mecanicLlista != null){
            if (e.getSource() == mecanicLlista.getSortir()){
                mecanicLlista.getFrame().setVisible(false);
                menuMecanics.getFrame().setVisible(true);
            
            }
        
        }
        
    }
    
    public void seleccionarOpcio(Integer opcio){
        
        switch (opcio){
            case 0: //Sortir
                ControladorPrincipal.getMenuPrincipal().getFrame().setVisible(true);
                break;
            case 1: //Alta
                if(ControladorPrincipal.getTallers()[0] != null){
                    mecanicForm = new MecanicForm();
                    afegirListenersForm();                    
                } else {
                    menuMecanics.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }
                break;
            case 2: //Llista
                if (ControladorPrincipal.getTallers()[0] != null) {
                    mecanicLlista = new MecanicLlista();
                    afegirListenersLlista();                    
                } else {
                    menuMecanics.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }
                break;
                       
        }
       
    }    
            
}

