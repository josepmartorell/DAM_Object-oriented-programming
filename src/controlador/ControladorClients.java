package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Client;
import persistencia.GestorPersistencia;
import principal.GestorTallerMecanicException;
import vista.MenuClients;
import vista.ClientForm;
import vista.ClientLlista;

/**
 *
 * @author fta
 */
public class ControladorClients implements ActionListener {

    private MenuClients menuClients;
    private ClientForm clientForm = null;
    private ClientLlista clientLlista = null;
    private int opcioSelec = 0;

    public ControladorClients() {

        menuClients = new MenuClients();
        afegirListenersMenu();

    }

    private void afegirListenersMenu() {

        for (JButton boto : menuClients.getMenuButtons()) {
            boto.addActionListener(this);
        }

    }

    private void afegirListenersForm() {

        clientForm.getDesar().addActionListener(this);
        clientForm.getSortir().addActionListener(this);

    }

    private void afegirListenersLlista() {

        clientLlista.getSortir().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Accions per al menú
        JButton[] botons = menuClients.getMenuButtons();

        for (int i = 0; i < botons.length; i++) {
            if (e.getSource() == botons[i]) {
                menuClients.getFrame().setVisible(false);
                opcioSelec = i;
                seleccionarOpcio(i);
            }
        }

        //Accions per al formulari de mestres
        if (clientForm != null) {

            if (e.getSource() == clientForm.getDesar()) {

                if (opcioSelec == 1) {//Nou recanvi

                    ControladorPrincipal.getTallerActual().getComponents().add(new Client(clientForm.gettNif().getText(), clientForm.gettNom().getText(), clientForm.gettTelefon().getText(), clientForm.gettCorreu().getText()));

                }

            } else if (e.getSource() == clientForm.getSortir()) { //Sortir

                clientForm.getFrame().setVisible(false);
                menuClients.getFrame().setVisible(true);

            }

        }

        if (clientLlista != null) {

            if (e.getSource() == clientLlista.getSortir()) {

                clientLlista.getFrame().setVisible(false);
                menuClients.getFrame().setVisible(true);

            }

        }

    }

    private void seleccionarOpcio(Integer opcio) {

        switch (opcio) {
            case 0: //sortir
                ControladorPrincipal.getMenuPrincipal().getFrame().setVisible(true);
                break;
            case 1: // alta
                  //if (ControladorPrincipal.getTallers()[0] != null) {
                  if (ControladorPrincipal.getTallerActual() != null) {//substitute
                    clientForm = new ClientForm();
                    afegirListenersForm();
                } else {
                    menuClients.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }
                break;
            case 2: // llista
                //if (ControladorPrincipal.getTallers()[0] != null) {
                if (ControladorPrincipal.getTallerActual() != null) {//substitute
                    clientLlista = new ClientLlista();
                    afegirListenersLlista();
                } else {
                    menuClients.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
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
                
                menuClients.getFrame().setVisible(true);
                
                if (ControladorPrincipal.getTallerActual() != null) {
                    
                    int tipusMissatge = JOptionPane.QUESTION_MESSAGE;
                    int codi = JOptionPane.showOptionDialog(null, "Selecciona un mètode", "Desar taller", 0, tipusMissatge, null, ControladorPrincipal.getMETODESPERSISTENCIA(), "XML");
                    
                    if (codi != JOptionPane.CLOSED_OPTION) {
                        
                        GestorPersistencia gestor = new GestorPersistencia();
                        
                        try {                            
                            gestor.desarTaller(ControladorPrincipal.getMETODESPERSISTENCIA()[codi], ControladorPrincipal.getTallerActual().getCif(), ControladorPrincipal.getTallerActual());
                        } catch (GestorTallerMecanicException e) {                            
                            JOptionPane.showMessageDialog(menuClients.getFrame(), e.getMessage());                            
                        }
                        
                    }
                    
                } else {                    
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de seleccionar un taller");                
                }

                break;
        }

    }

}
