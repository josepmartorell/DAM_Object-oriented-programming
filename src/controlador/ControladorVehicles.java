/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Vehicle;
import persistencia.GestorPersistencia;
import principal.Component;
import principal.GestorTallerMecanicException;
import vista.MenuVehicles;
import vista.UpdateVehicleForm;
import vista.VehicleForm;
import vista.VehicleLlista;

/**
 *
 * @author jtech
 */
public class ControladorVehicles implements ActionListener{
    
    private MenuVehicles menuVehicles;
    private VehicleForm vehicleForm = null;
    private UpdateVehicleForm updateVehicleForm = null;
    private VehicleLlista vehicleLlista = null;
    private int opcioSelec = 0;
    private String input;
    private String VAR1;
    private String VAR2;
    private String VAR3;
    private String VAR4;

    public ControladorVehicles() {
        
        menuVehicles = new MenuVehicles();
        afegirListenersMenu();

    }

    private void afegirListenersMenu() {

        for (JButton boto : menuVehicles.getMenuButtons()) {
            boto.addActionListener(this);
        }

    }
    
    private void afegirListenersForm() {

        vehicleForm.getDesar().addActionListener(this);
        vehicleForm.getSortir().addActionListener(this);

    }
    
    private void afegirListenersUpdateForm() {

        updateVehicleForm.getDesar().addActionListener(this);
        updateVehicleForm.getSortir().addActionListener(this);

    }

    private void afegirListenersLlista() {

        vehicleLlista.getSortir().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        //Accions per al menú
        JButton[] botons = menuVehicles.getMenuButtons();

        for (int i = 0; i < botons.length; i++) {
            if (e.getSource() == botons[i]) {
                menuVehicles.getFrame().setVisible(false);
                opcioSelec = i;
                seleccionarOpcio(i);
            }
        }

        //Accions per al formulari de vehicles
        if (vehicleForm != null) {

            if (e.getSource() == vehicleForm.getDesar()) {

                if (opcioSelec == 1) {//Nou recanvi

                    ControladorPrincipal.getTallerActual().getComponents().add(new Vehicle(vehicleForm.gettMatricula().getText(), vehicleForm.gettMarca().getText(), vehicleForm.gettModel().getText(), vehicleForm.gettColor().getText()));

                }

            } else if (e.getSource() == vehicleForm.getSortir()) { //Sortir

                vehicleForm.getFrame().setVisible(false);
                menuVehicles.getFrame().setVisible(true);

            }

        }
        
        //Accions per al formulari per a modificar vehicles
        if (updateVehicleForm != null) {

            if (e.getSource() == updateVehicleForm.getDesar()) {

                if (opcioSelec == 3) {//Modificar vehicle
                    String matricula = updateVehicleForm.gettMatricula().getText();
                    String marca = updateVehicleForm.gettMarca().getText();
                    String model = updateVehicleForm.gettModel().getText();
                    String color = updateVehicleForm.gettColor().getText();
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Vehicle){
                            if(((Vehicle) component).getMatricula().equals(input)){
                                ((Vehicle)component).setMatricula(matricula);
                                ((Vehicle)component).setMarca(marca);
                                ((Vehicle)component).setModel(model);
                                ((Vehicle)component).setColor(color);
                            }    
                        }
                    }
                }     

            } else if (e.getSource() == updateVehicleForm.getSortir()) { //Sortir

               updateVehicleForm.getFrame().setVisible(false);
               menuVehicles.getFrame().setVisible(true);

            }

        }

        if (vehicleLlista != null) {

            if (e.getSource() == vehicleLlista.getSortir()) {

                vehicleLlista.getFrame().setVisible(false);
                menuVehicles.getFrame().setVisible(true);

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
                    vehicleForm = new VehicleForm();
                    afegirListenersForm();
                } else {
                    menuVehicles.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 2: // llista
                if (ControladorPrincipal.getTallers()[0] != null) {
                    vehicleLlista = new VehicleLlista();
                    afegirListenersLlista();
                } else {
                    menuVehicles.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de seleccionar un taller");
                }

                break;
            case 3: // modificar
                if (ControladorPrincipal.getTallerActual() != null) {
                    int i = 0;      
                    int totalVehicles = 0;
                    int pointer = 0;

                    input = JOptionPane.showInputDialog("Introdueixi la matricula del vehicle que es vol modificar:");

                    for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                        if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Vehicle) {
                            totalVehicles++;
                        }  
                    }

                    String[][] data = new String[totalVehicles][4];
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Vehicle){
                            if(((Vehicle) component).getMatricula().equals(input)){
                                data[i][0] = ((Vehicle)component).getMatricula();
                                data[i][1] = ((Vehicle)component).getMarca();
                                data[i][2] = ((Vehicle)component).getModel();
                                data[i][3] = ((Vehicle)component).getColor();
                                pointer = i;
                            }
                            i++;      
                        }
                    }
                    this.VAR1 = data[pointer][0];
                    this.VAR2 = data[pointer][1];
                    this.VAR3 = data[pointer][2];
                    this.VAR4 = data[pointer][3];

                    updateVehicleForm = new UpdateVehicleForm("Vehicle", VAR1, VAR2, VAR3, VAR4);
                    afegirListenersUpdateForm();
                } else {
                    menuVehicles.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break; 
            case 4: // eliminar 
                /* 1-pedimos el nif del cliente a borrar y lo almacenamos en la variable input
                   2-recorremos el arraylist hasta encontrar el elemento coincidente y almacenamos la posicion en index 
                   3-fuera del ciclo for eliminamos el comoponente del arraylist con el método remove(int index) de la misma clase arraylist 
                */ 
                if (ControladorPrincipal.getTallerActual() != null) {
                    int index = 0;

                    input = JOptionPane.showInputDialog("Introdueixi la matricula del vehicle que es vol eliminar:");

                    for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                        if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Vehicle) {
                            if(((Vehicle) ControladorPrincipal.getTallerActual().getComponents().get(j)).getMatricula().equals(input)){
                                index = j;
                            }


                        }  
                    }
                    ControladorPrincipal.getTallerActual().getComponents().remove(index);
                    menuVehicles.getFrame().setVisible(true);
                } else {
                    menuVehicles.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de seleccionar un taller");
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
                
                menuVehicles.getFrame().setVisible(true);
                
                if (ControladorPrincipal.getTallerActual() != null) {
                    
                    int tipusMissatge = JOptionPane.QUESTION_MESSAGE;
                    int codi = JOptionPane.showOptionDialog(null, "Selecciona un mètode", "Desar taller", 0, tipusMissatge, null, ControladorPrincipal.getMETODESPERSISTENCIA(), "XML");
                    
                    if (codi != JOptionPane.CLOSED_OPTION) {
                        
                        GestorPersistencia gestor = new GestorPersistencia();
                        
                        try {                            
                            gestor.desarTaller(ControladorPrincipal.getMETODESPERSISTENCIA()[codi], ControladorPrincipal.getTallerActual().getCif(), ControladorPrincipal.getTallerActual());
                        } catch (GestorTallerMecanicException e) {                            
                            JOptionPane.showMessageDialog(menuVehicles.getFrame(), e.getMessage());                            
                        }
                        
                    }
                    
                } else {                    
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de seleccionar un taller");                
                }

                break;
        }

    }
    
    
    
}

