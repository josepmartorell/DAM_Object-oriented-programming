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
import persistencia.GestorPersistencia;
import principal.GestorTallerMecanicException;
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
            case 3: //desar
                /*
                TODO
                
                Es comprova si s'ha seleccionat el taller, mostrant, si correspon, un missatges d'error (JOptionPane.showMessageDialog)
                Si s'ha seleccionat el taller:
                    - Es mostra un dialog (JOptionPane.showOptionDialog) amb botons, on cadascun d'ells és un mètode de càrrega
                      (atribut de Controlador Principal: ara XML i Serial)
                    - Un cop escollit el mètode, es desa el taller cridant a desarTaller del gestor de persistència.
                 */
                
                menuMecanics.getFrame().setVisible(true);
                
                if (ControladorPrincipal.getTallerActual() != null) {
                    
                    int tipusMissatge = JOptionPane.QUESTION_MESSAGE;
                    int codi = JOptionPane.showOptionDialog(null, "Selecciona un mètode", "Desar taller", 0, tipusMissatge, null, ControladorPrincipal.getMETODESPERSISTENCIA(), "XML");
                    
                    if (codi != JOptionPane.CLOSED_OPTION) {
                        
                        GestorPersistencia gestor = new GestorPersistencia();
                        
                        try {                            
                            gestor.desarTaller(ControladorPrincipal.getMETODESPERSISTENCIA()[codi], ControladorPrincipal.getTallerActual().getCif(), ControladorPrincipal.getTallerActual());
                        } catch (GestorTallerMecanicException e) {                            
                            JOptionPane.showMessageDialog(menuMecanics.getFrame(), e.getMessage());                            
                        }
                        
                    }
                    
                } else {                    
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de seleccionar un taller");                
                }

                break;
                       
        }
       
    }    
            
}

