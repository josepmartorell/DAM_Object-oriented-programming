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
import principal.Component;
import principal.GestorTallerMecanicException;
import vista.MecanicForm;
import vista.MecanicLlista;
import vista.MenuMecanics;
import vista.UpdateForm;

/**
 *
 * @author jtech
 */
public class ControladorMecanics implements ActionListener{
    
    private MenuMecanics menuMecanics;
    private MecanicForm mecanicForm = null;
    private UpdateForm updateForm = null;
    private MecanicLlista mecanicLlista = null;
    private int opcioSelec = 0;
    private String input;
    private String VAR1;
    private String VAR2;
    private String VAR3;
    private String VAR4;

    
    
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
    
    private void afegirListenersUpdateForm() {

        updateForm.getDesar().addActionListener(this);
        updateForm.getSortir().addActionListener(this);

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
        
        //Accions per al formulari de mecanics
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
        
        //Accions per al formulari per a modificar mecanics
        if (updateForm != null) {

            if (e.getSource() == updateForm.getDesar()) {

                if (opcioSelec == 3) {//Modificar mecanic
                    String nif = updateForm.gettNif().getText();
                    String nom = updateForm.gettNom().getText();
                    String telefon = updateForm.gettTelefon().getText();
                    String correu = updateForm.gettCorreu().getText();
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Mecanic){
                            if(((Mecanic) component).getNif().equals(input)){
                                ((Mecanic)component).setNif(nif);
                                ((Mecanic)component).setNom(nom);
                                ((Mecanic)component).setTelefon(telefon);
                                ((Mecanic)component).setCorreu(correu);
                            }    
                        }
                    }
                }     

            } else if (e.getSource() == updateForm.getSortir()) { //Sortir

               updateForm.getFrame().setVisible(false);
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
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 2: //Llista
                if (ControladorPrincipal.getTallers()[0] != null) {
                    mecanicLlista = new MecanicLlista();
                    afegirListenersLlista();                    
                } else {
                    menuMecanics.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 3: // modificar
                if (ControladorPrincipal.getTallerActual() != null) {
                    int i = 0;      
                    int totalMecanics = 0;
                    int pointer = 0;
                    boolean match = false;

                    input = JOptionPane.showInputDialog("Introdueixi el nif del mecanic que es vol modificar:");
                    /**/
                    if(input != null){

                        input = (String)input;
                        //El usuario coloco algo que no sea solo espacios
                        if(!input.trim().equals("")){

                            //Aqui deberias seguir tu codigo al validar que todo es correcto.
                            for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                                if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Mecanic) {
                                    totalMecanics++;
                                }  
                            }

                            String[][] data = new String[totalMecanics][4];
                            for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                                if (component instanceof Mecanic){
                                    //si coincideix el codi omplim el array amb les dedes del mecanic y establim el boolean match a valor true
                                    if(((Mecanic) component).getNif().equals(input)){
                                        match = true;
                                        data[i][0] = ((Mecanic)component).getNif();
                                        data[i][1] = ((Mecanic)component).getNom();
                                        data[i][2] = ((Mecanic)component).getTelefon();
                                        data[i][3] = ((Mecanic)component).getCorreu();

                                        pointer = i++;
                                    }
                           
                                }
                            }
                            if(match){
                                this.VAR1 = data[pointer][0];
                                this.VAR2 = data[pointer][1];
                                this.VAR3 = data[pointer][2];
                                this.VAR4 = data[pointer][3];

                                updateForm = new UpdateForm("Mecanic", VAR1, VAR2, VAR3, VAR4);
                                afegirListenersUpdateForm();                        
                            }else{
                                //El nif introducido no coincide.
                                JOptionPane.showMessageDialog(menuMecanics.getFrame(),"Nif erroni, premeu aceptar i torneu a introduir el nif:");
                                seleccionarOpcio(3);
                            }


                        }else{
                           //El usuario coloco solo espacios en blanco o tabulaciones.
                            JOptionPane.showMessageDialog(menuMecanics.getFrame(),"Camp obligatori, premeu aceptar i torneu a introduir el nif:");
                            seleccionarOpcio(3);
                        }

                     }else{
                        //El usuario le dio al boton cancelar.
                        menuMecanics.getFrame().setVisible(true);
                     }
                    /**/


                } else {
                    menuMecanics.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break; 
            case 4: // eliminar 
                /* 1-pedimos el nif del cliente a borrar y lo almacenamos en la variable input
                   2-recorremos el arraylist hasta encontrar el elemento coincidente y almacenamos la posicion en index 
                   3-fuera del ciclo for eliminamos el comoponente del arraylist con el método remove(int index) de la misma clase arraylist 
                */ 
                if (ControladorPrincipal.getTallerActual() != null) {
                    int index = 0;

                    input = JOptionPane.showInputDialog("Introdueixi el nif del mecanic que es vol eliminar:");

                    for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                        if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Mecanic) {
                            if(((Mecanic) ControladorPrincipal.getTallerActual().getComponents().get(j)).getNif().equals(input)){
                                index = j;
                            }


                        }  
                    }
                    ControladorPrincipal.getTallerActual().getComponents().remove(index);
                    menuMecanics.getFrame().setVisible(true);
                } else {
                    menuMecanics.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuMecanics.getFrame(), "Abans s'ha de seleccionar un taller");
                }            
                break; 
            case 5: //desar
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

