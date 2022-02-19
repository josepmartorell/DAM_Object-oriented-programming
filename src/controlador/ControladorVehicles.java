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
import vista.MenuVehicles;
import vista.VehicleForm;
import vista.VehicleLlista;

/**
 *
 * @author jtech
 */
public class ControladorVehicles implements ActionListener{
    
    private MenuVehicles menuVehicles;
    private VehicleForm vehicleForm = null;
    private VehicleLlista vehicleLlista = null;
    private int opcioSelec = 0;

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

        //Accions per al formulari de recanvis
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
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }
                break;
            case 2: // llista
                if (ControladorPrincipal.getTallers()[0] != null) {
                    vehicleLlista = new VehicleLlista();
                    afegirListenersLlista();
                } else {
                    menuVehicles.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuVehicles.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }

                break;
        }

    }
    
    
    
}

