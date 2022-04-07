/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Client;
import model.Reparacio;
import model.Taller;
import persistencia.GestorPersistencia;
import principal.Component;
import principal.GestorTallerMecanicException;
import vista.MenuReparacions;
import vista.ReparacioForm;
import vista.ReparacioLlista;
import vista.UpdateReparacioForm;

/**
 *
 * @author jtech
 */
public class ControladorReparacions implements ActionListener{
    
    private MenuReparacions menuReparacions;
    private ReparacioForm reparacioForm = null;
    private UpdateReparacioForm updateReparacioForm = null;
    private ReparacioLlista reparacioLlista = null;
    private int opcioSelec = 0;
    private String input;
    private String VAR1;
    private String VAR2;
    private String VAR3;
    private Taller taller;
    private Client client;
    private Reparacio reparacio;
    private int index;

    public ControladorReparacions() {
        menuReparacions = new MenuReparacions();
        afegirListenersMenu();
        
        
    }
    
    private void afegirListenersMenu() {

        for (JButton boto : menuReparacions.getMenuButtons()) {
            boto.addActionListener(this);
        }

    }
    
    private void afegirListenersForm() {

        reparacioForm.getDesar().addActionListener(this);
        reparacioForm.getSortir().addActionListener(this);
   

    }
    
    private void afegirListenersUpdateForm() {

        updateReparacioForm.getDesar().addActionListener(this);
        updateReparacioForm.getSortir().addActionListener(this);

    }
    
    private void afegirListenersLlista() {

        reparacioLlista.getSortir().addActionListener(this);

    }
    
        @Override
    public void actionPerformed(ActionEvent e) {

        //Accions per al menú
        JButton[] botons = menuReparacions.getMenuButtons();

        for (int i = 0; i < botons.length; i++) {
            if (e.getSource() == botons[i]) {
                menuReparacions.getFrame().setVisible(false);
                opcioSelec = i;
                seleccionarOpcio(i);
            }
        }

        //Accions per al formulari de recanvis
        if (reparacioForm != null) {

            if (e.getSource() == reparacioForm.getDesar()) {

                if (opcioSelec == 1) {//Nou recanvi

                    ControladorPrincipal.getTallerActual().getComponents().add(new Reparacio(reparacioForm.gettCodi().getText(), reparacioForm.gettDataInici().getText(), reparacioForm.gettDataFi().getText()));

                }

            } else if (e.getSource() == reparacioForm.getSortir()) { //Sortir

                reparacioForm.getFrame().setVisible(false);
                menuReparacions.getFrame().setVisible(true);

            }

        }
        
        //Accions per al formulari per a modificar recanvis
        if (updateReparacioForm != null) {

            if (e.getSource() == updateReparacioForm.getDesar()) {

                if (opcioSelec == 2) {//Modificar reparacio
                    String codi = updateReparacioForm.gettCodi().getText();
                    String dataInici = updateReparacioForm.gettDataInici().getText();
                    String dataFi = updateReparacioForm.gettDataFi().getText();
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Reparacio){
                            if(((Reparacio) component).getCodi().equals(input)){
                                ((Reparacio)component).setCodi(codi);
                                ((Reparacio)component).setDataInici(dataInici);
                                ((Reparacio)component).setDataFi(dataFi);
                            }    
                        }
                    }
                }     

            } else if (e.getSource() == updateReparacioForm.getSortir()) { //Sortir

               updateReparacioForm.getFrame().setVisible(false);
               menuReparacions.getFrame().setVisible(true);

            }

        }

        if (reparacioLlista != null) {

            if (e.getSource() == reparacioLlista.getSortir()) {

                reparacioLlista.getFrame().setVisible(false);
                menuReparacions.getFrame().setVisible(true);

            }

        }

    }
    
    private void seleccionarOpcio(Integer opcio) {

        switch (opcio) {
            case 0: //sortir
                ControladorPrincipal.getMenuPrincipal().getFrame().setVisible(true);
                break;
            case 1: // alta
                if (ControladorPrincipal.getTallers()[0] != null) {
                    reparacioForm = new ReparacioForm();
                    afegirListenersForm();
                } else {
                    menuReparacions.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 2: // modificar
                if (ControladorPrincipal.getTallerActual() != null) {
                    int i = 0;      
                    int totalReparacions = 0;
                    int pointer = 0;
                    boolean match = false;

                    input = JOptionPane.showInputDialog("Introdueixi el codi de la reparació que es vol modificar:");
                    /**/
                    if(input != null){

                        input = (String)input;
                        //El usuario coloco algo que no sea solo espacios
                        if(!input.trim().equals("")){

                            //calculamos el total de filas para asignar el espacio de memoria en el array de doble entrada.
                            for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                                if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Reparacio) {
                                    totalReparacions++;
                                }  
                            }

                            String[][] data = new String[totalReparacions][3];
                            for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                                if (component instanceof Reparacio){
                                    //si coincideix el codi omplim el array amb les dedes de la reparació y establim el boolean match a valor true
                                    if(((Reparacio) component).getCodi().equals(input)){
                                        match = true;
                                        data[i][0] = ((Reparacio)component).getCodi();
                                        data[i][1] = ((Reparacio)component).getDataInici();
                                        data[i][2] = ((Reparacio)component).getDataFi();

                                        pointer = i++;
                                    }
                           
                                }
                            }
                            if(match){
                                this.VAR1 = data[pointer][0];
                                this.VAR2 = data[pointer][1];
                                this.VAR3 = data[pointer][2];

                                updateReparacioForm = new UpdateReparacioForm("Reparació", VAR1, VAR2, VAR3);
                                afegirListenersUpdateForm();                        
                            }else{
                                //El codigo introducido no coincide.
                                JOptionPane.showMessageDialog(menuReparacions.getFrame(),"Codi erroni, premeu aceptar i torneu a introduir el codi:");
                                seleccionarOpcio(3);
                            }


                        }else{
                           //El usuario coloco solo espacios en blanco o tabulaciones.
                            JOptionPane.showMessageDialog(menuReparacions.getFrame(),"Camp obligatori, premeu aceptar i torneu a introduir el codi:");
                            seleccionarOpcio(3);
                        }

                     }else{
                        //El usuario le dio al boton cancelar.
                        menuReparacions.getFrame().setVisible(true);
                     }
                    /**/


                } else {
                    menuReparacions.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
                //TODO/->
            case 3: //assignar client
                taller = ControladorPrincipal.getTallerActual();
                if(taller != null){
                    if(reparacio != null){
                        input = JOptionPane.showInputDialog("Introdueixi el nif del client que es vol assignar:");
                        if(input != null){//START
                            for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                                if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Client) {
                                    if(((Client) ControladorPrincipal.getTallerActual().getComponents().get(j)).getNif().equals(input)){
                                        index = j;
                                    }
                                }  
                            }
                            client = (Client) ControladorPrincipal.getTallerActual().getComponents().get(index);
                            reparacio.setClient(client);
                            JOptionPane.showMessageDialog(menuReparacions.getFrame(), "operacio exitosa.");
                            menuReparacions.getFrame().setVisible(true);//STOP
                        }else{
                                //El usuario le dio al boton cancelar.
                                menuReparacions.getFrame().setVisible(true);
                             }
                    }else {
                        menuReparacions.getFrame().setVisible(true);
                        JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar una reparació");
                    }
                }  else {
                    menuReparacions.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;             
                //TODO/<-
            case 7: // llista
                if (ControladorPrincipal.getTallerActual() != null) {
                    reparacioLlista = new ReparacioLlista();
                    afegirListenersLlista();
                } else {
                    menuReparacions.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar un taller");
                }

                break;
            case 8:
                // en esta opción reciclamos el método selectComponent de la clase Taller que devuelve un int del puntero del componente
                taller = ControladorPrincipal.getTallerActual();
                if(taller != null){
                    taller = ControladorPrincipal.getTallerActual();
                    input = JOptionPane.showInputDialog("Introdueixi el codi de la reparació:");
                    int selReparacio = taller.selectComponent(4, input);
                    reparacio = (Reparacio) taller.getComponents().get(selReparacio);
                    menuReparacions.getFrame().setVisible(true);
                } else {
                    menuReparacions.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 9: //desar
                /*
                TODO
                
                Es comprova si s'ha seleccionat el taller, mostrant, si correspon, un missatges d'error (JOptionPane.showMessageDialog)
                Si s'ha seleccionat el taller:
                    - Es mostra un dialog (JOptionPane.showOptionDialog) amb botons, on cadascun d'ells és un mètode de càrrega
                      (atribut de Controlador Principal: ara XML i Serial)
                    - Un cop escollit el mètode, es desa el taller cridant a desarTaller del gestor de persistència.
                 */
                
                menuReparacions.getFrame().setVisible(true);
                
                if (ControladorPrincipal.getTallerActual() != null) {
                    
                    int tipusMissatge = JOptionPane.QUESTION_MESSAGE;
                    int codi = JOptionPane.showOptionDialog(null, "Selecciona un mètode", "Desar taller", 0, tipusMissatge, null, ControladorPrincipal.getMETODESPERSISTENCIA(), "XML");
                    
                    if (codi != JOptionPane.CLOSED_OPTION) {
                        
                        GestorPersistencia gestor = new GestorPersistencia();
                        
                        try {                            
                            gestor.desarTaller(ControladorPrincipal.getMETODESPERSISTENCIA()[codi], ControladorPrincipal.getTallerActual().getCif(), ControladorPrincipal.getTallerActual());
                        } catch (GestorTallerMecanicException e) {                            
                            JOptionPane.showMessageDialog(menuReparacions.getFrame(), e.getMessage());                            
                        }
                        
                    }
                    
                } else {                    
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de seleccionar un taller");                
                }

                break;

        }

    }

    
    
    
}
