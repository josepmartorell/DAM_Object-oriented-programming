package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Client;
import persistencia.GestorPersistencia;
import principal.Component;
import principal.GestorTallerMecanicException;
import vista.MenuClients;
import vista.ClientForm;
import vista.ClientLlista;
import vista.UpdateForm;

/**
 *
 * @author fta
 */
public class ControladorClients implements ActionListener {

    private MenuClients menuClients;
    private ClientForm clientForm = null;
    private UpdateForm updateForm = null;
    private ClientLlista clientLlista = null;
    private int opcioSelec = 0;
    private String input;
    private String VAR1;
    private String VAR2;
    private String VAR3;
    private String VAR4;

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
    
    private void afegirListenersUpdateForm() {

        updateForm.getDesar().addActionListener(this);
        updateForm.getSortir().addActionListener(this);

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

        //Accions per al formulari de clients
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
        
        //Accions per al formulari per a modificar clients
        if (updateForm != null) {

            if (e.getSource() == updateForm.getDesar()) {

                if (opcioSelec == 3) {//Modificar taller
                    String nif = updateForm.gettNif().getText();
                    String nom = updateForm.gettNom().getText();
                    String telefon = updateForm.gettTelefon().getText();
                    String correu = updateForm.gettCorreu().getText();
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Client){
                            if(((Client) component).getNif().equals(input)){
                                ((Client)component).setNif(nif);
                                ((Client)component).setNom(nom);
                                ((Client)component).setTelefon(telefon);
                                ((Client)component).setCorreu(correu);
                            }     
                        }
                    }
                }    

            } else if (e.getSource() == updateForm.getSortir()) { //Sortir

               updateForm.getFrame().setVisible(false);
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
                  if (ControladorPrincipal.getTallerActual() != null) {
                    clientForm = new ClientForm();
                    afegirListenersForm();
                } else {
                    menuClients.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 2: // llista
                if (ControladorPrincipal.getTallerActual() != null) {
                    clientLlista = new ClientLlista();
                    afegirListenersLlista();
                } else {
                    menuClients.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de seleccionar un taller");
                }

                break;
            case 3: // modificar
                if (ControladorPrincipal.getTallerActual() != null) {
                    int i = 0;      
                    int totalClients = 0;
                    int pointer = 0;

                    input = JOptionPane.showInputDialog("Introdueixi el nif del client que es vol modificar:");

                    for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                        if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Client) {
                            totalClients++;
                        }  
                    }

                    String[][] data = new String[totalClients][4];
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Client){
                            if(((Client) component).getNif().equals(input)){
                                data[i][0] = ((Client)component).getNif();
                                data[i][1] = ((Client)component).getNom();
                                data[i][2] = ((Client)component).getTelefon();
                                data[i][3] = ((Client)component).getCorreu();
                                pointer = i;
                            }
                            i++;      
                        }
                    }
                    this.VAR1 = data[pointer][0];
                    this.VAR2 = data[pointer][1];
                    this.VAR3 = data[pointer][2];
                    this.VAR4 = data[pointer][3];

                    updateForm = new UpdateForm("Client", VAR1, VAR2, VAR3, VAR4);
                    afegirListenersUpdateForm();
                } else {
                    menuClients.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 4: // eliminar 
                /* 1-pedimos el nif del cliente a borrar y lo almacenamos en la variable input
                   2-recorremos el arraylist hasta encontrar el elemento coincidente y almacenamos la posicion en index 
                   3-fuera del ciclo for eliminamos el comoponente del arraylist con el método remove(int index) de la misma clase arraylist 
                */ 
                if (ControladorPrincipal.getTallerActual() != null) {
                    int index = 0;

                    input = JOptionPane.showInputDialog("Introdueixi el nif del client que es vol eliminar:");

                    for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                        if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Client) {
                            if(((Client) ControladorPrincipal.getTallerActual().getComponents().get(j)).getNif().equals(input)){
                                index = j;
                            }


                        }  
                    }
                    ControladorPrincipal.getTallerActual().getComponents().remove(index);
                    menuClients.getFrame().setVisible(true);
                } else {
                    menuClients.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuClients.getFrame(), "Abans s'ha de seleccionar un taller");
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


