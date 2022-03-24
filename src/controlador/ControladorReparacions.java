/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Reparacio;
import persistencia.GestorPersistencia;
import principal.GestorTallerMecanicException;
import vista.MenuReparacions;
import vista.ReparacioForm;
import vista.ReparacioLlista;

/**
 *
 * @author jtech
 */
public class ControladorReparacions implements ActionListener{
    
    private MenuReparacions menuReparacions;
    private ReparacioForm reparacioForm = null;
    private ReparacioLlista reparacioLlista = null;
    private int opcioSelec = 0;

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
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }
                break;
            case 7: // llista
                if (ControladorPrincipal.getTallers()[0] != null) {
                    reparacioLlista = new ReparacioLlista();
                    afegirListenersLlista();
                } else {
                    menuReparacions.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuReparacions.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }

                break;
            case 8: //desar
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
