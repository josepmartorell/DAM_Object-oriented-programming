package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Recanvi;
import persistencia.GestorPersistencia;
import principal.Component;
import principal.GestorTallerMecanicException;
import vista.MenuRecanvis;
import vista.RecanviForm;
import vista.RecanviLlista;
import vista.UpdateRecanviForm;

/**
 *
 * @author jtech
 */
public class ControladorRecanvis implements ActionListener {

    private MenuRecanvis menuRecanvis;
    private RecanviForm recanviForm = null;
    private UpdateRecanviForm updateRecanviForm = null;
    private RecanviLlista recanviLlista = null;
    private int opcioSelec = 0;
    private String input;
    private String VAR1;
    private String VAR2;
    private String VAR3;
    private String VAR4;

    public ControladorRecanvis() {

        menuRecanvis = new MenuRecanvis();
        afegirListenersMenu();

    }

    private void afegirListenersMenu() {

        for (JButton boto : menuRecanvis.getMenuButtons()) {
            boto.addActionListener(this);
        }

    }

    private void afegirListenersForm() {

        recanviForm.getDesar().addActionListener(this);
        recanviForm.getSortir().addActionListener(this);

    }
    
    private void afegirListenersUpdateForm() {

        updateRecanviForm.getDesar().addActionListener(this);
        updateRecanviForm.getSortir().addActionListener(this);

    }

    private void afegirListenersLlista() {

        recanviLlista.getSortir().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Accions per al menú
        JButton[] botons = menuRecanvis.getMenuButtons();

        for (int i = 0; i < botons.length; i++) {
            if (e.getSource() == botons[i]) {
                menuRecanvis.getFrame().setVisible(false);
                opcioSelec = i;
                seleccionarOpcio(i);
            }
        }

        //Accions per al formulari de recanvis
        if (recanviForm != null) {

            if (e.getSource() == recanviForm.getDesar()) {

                if (opcioSelec == 1) {//Nou recanvi

                    ControladorPrincipal.getTallerActual().getComponents().add(new Recanvi(recanviForm.gettCodi().getText(), recanviForm.gettNom().getText(), recanviForm.gettFabricant().getText(), Double.parseDouble(recanviForm.gettPreu().getText())));

                }

            } else if (e.getSource() == recanviForm.getSortir()) { //Sortir

                recanviForm.getFrame().setVisible(false);
                menuRecanvis.getFrame().setVisible(true);

            }

        }
        
        //Accions per al formulari per a modificar recanvis
        if (updateRecanviForm != null) {

            if (e.getSource() == updateRecanviForm.getDesar()) {

                if (opcioSelec == 3) {//Modificar recanvi
                    String codi = updateRecanviForm.gettCodi().getText();
                    String nom = updateRecanviForm.gettNom().getText();
                    String fabricant = updateRecanviForm.gettFabricant().getText();
                    double preu = Double.parseDouble(updateRecanviForm.gettPreu().getText());
                    for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                        if (component instanceof Recanvi){
                            if(((Recanvi) component).getCodi().equals(input)){
                                ((Recanvi)component).setCodi(codi);
                                ((Recanvi)component).setNom(nom);
                                ((Recanvi)component).setFabricant(fabricant);
                                ((Recanvi)component).setPreu(preu);
                            }    
                        }
                    }
                }     

            } else if (e.getSource() == updateRecanviForm.getSortir()) { //Sortir

               updateRecanviForm.getFrame().setVisible(false);
               menuRecanvis.getFrame().setVisible(true);

            }

        }

        if (recanviLlista != null) {

            if (e.getSource() == recanviLlista.getSortir()) {

                recanviLlista.getFrame().setVisible(false);
                menuRecanvis.getFrame().setVisible(true);

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
                    recanviForm = new RecanviForm();
                    afegirListenersForm();
                } else {
                    menuRecanvis.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 2: // llista
                if (ControladorPrincipal.getTallerActual() != null) {
                    recanviLlista = new RecanviLlista();
                    afegirListenersLlista();
                } else {
                    menuRecanvis.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break;
            case 3: // modificar
                if (ControladorPrincipal.getTallerActual() != null) {
                    int i = 0;      
                    int totalRecanvis = 0;
                    int pointer = 0;
                    boolean match = false;

                    input = JOptionPane.showInputDialog("Introdueixi el codi del recanvi que es vol modificar:");
                    /**/
                    if(input != null){

                        input = (String)input;
                        //El usuario coloco algo que no sea solo espacios
                        if(!input.trim().equals("")){

                            //Aqui deberias seguir tu codigo al validar que todo es correcto.
                            for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                                if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Recanvi) {
                                    totalRecanvis++;
                                }  
                            }

                            String[][] data = new String[totalRecanvis][4];
                            for (Component component: ControladorPrincipal.getTallerActual().getComponents()){
                                if (component instanceof Recanvi){
                                    //si coincideix el codi omplim el array amb les dedes del recanvi y establim el boolean match a valor true
                                    if(((Recanvi) component).getCodi().equals(input)){
                                        match = true;
                                        data[i][0] = ((Recanvi)component).getCodi();
                                        data[i][1] = ((Recanvi)component).getNom();
                                        data[i][2] = ((Recanvi)component).getFabricant();
                                        data[i][3] = String.valueOf(((Recanvi)component).getPreu());

                                        pointer = i++;
                                    }
                           
                                }
                            }
                            if(match){
                                this.VAR1 = data[pointer][0];
                                this.VAR2 = data[pointer][1];
                                this.VAR3 = data[pointer][2];
                                this.VAR4 = data[pointer][3];

                                updateRecanviForm = new UpdateRecanviForm("Vehicle", VAR1, VAR2, VAR3, VAR4);
                                afegirListenersUpdateForm();                        
                            }else{
                                //El codigo introducido no coincide.
                                JOptionPane.showMessageDialog(menuRecanvis.getFrame(),"Codi erroni, premeu aceptar i torneu a introduir el codi:");
                                seleccionarOpcio(3);
                            }


                        }else{
                           //El usuario coloco solo espacios en blanco o tabulaciones.
                            JOptionPane.showMessageDialog(menuRecanvis.getFrame(),"Camp obligatori, premeu aceptar i torneu a introduir el codi:");
                            seleccionarOpcio(3);
                        }

                     }else{
                        //El usuario le dio al boton cancelar.
                        menuRecanvis.getFrame().setVisible(true);
                     }
                    /**/


                } else {
                    menuRecanvis.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de seleccionar un taller");
                }
                break; 
            case 4: // eliminar 
                /* 1-pedimos el nif del cliente a borrar y lo almacenamos en la variable input
                   2-recorremos el arraylist hasta encontrar el elemento coincidente y almacenamos la posicion en index 
                   3-fuera del ciclo for eliminamos el comoponente del arraylist con el método remove(int index) de la misma clase arraylist 
                */ 
                if (ControladorPrincipal.getTallerActual() != null) {
                    int index = 0;

                    input = JOptionPane.showInputDialog("Introdueixi el codi del recanvi que es vol eliminar:");

                    for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++){
                        if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Recanvi) {
                            if(((Recanvi) ControladorPrincipal.getTallerActual().getComponents().get(j)).getCodi().equals(input)){
                                index = j;
                            }


                        }  
                    }
                    ControladorPrincipal.getTallerActual().getComponents().remove(index);
                    menuRecanvis.getFrame().setVisible(true);
                } else {
                    menuRecanvis.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de seleccionar un taller");
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
                
                menuRecanvis.getFrame().setVisible(true);
                
                if (ControladorPrincipal.getTallerActual() != null) {
                    
                    int tipusMissatge = JOptionPane.QUESTION_MESSAGE;
                    int codi = JOptionPane.showOptionDialog(null, "Selecciona un mètode", "Desar taller", 0, tipusMissatge, null, ControladorPrincipal.getMETODESPERSISTENCIA(), "XML");
                    
                    if (codi != JOptionPane.CLOSED_OPTION) {
                        
                        GestorPersistencia gestor = new GestorPersistencia();
                        
                        try {                            
                            gestor.desarTaller(ControladorPrincipal.getMETODESPERSISTENCIA()[codi], ControladorPrincipal.getTallerActual().getCif(), ControladorPrincipal.getTallerActual());
                        } catch (GestorTallerMecanicException e) {                            
                            JOptionPane.showMessageDialog(menuRecanvis.getFrame(), e.getMessage());                            
                        }
                        
                    }
                    
                } else {                    
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de seleccionar un taller");                
                }

                break;
        }

    }

}
