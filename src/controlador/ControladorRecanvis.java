package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Recanvi;
import persistencia.GestorPersistencia;
import principal.GestorTallerMecanicException;
import vista.MenuRecanvis;
import vista.RecanviForm;
import vista.RecanviLlista;

/**
 *
 * @author fta
 */
public class ControladorRecanvis implements ActionListener {

    private MenuRecanvis menuRecanvis;
    private RecanviForm recanviForm = null;
    private RecanviLlista recanviLlista = null;
    private int opcioSelec = 0;

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

        //Accions per al formulari de mestres
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
                  //if (ControladorPrincipal.getTallers()[0] != null) {
                  if (ControladorPrincipal.getTallerActual() != null) {//substitute
                    recanviForm = new RecanviForm();
                    afegirListenersForm();
                } else {
                    menuRecanvis.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
                }
                break;
            case 2: // llista
                //if (ControladorPrincipal.getTallers()[0] != null) {
                if (ControladorPrincipal.getTallerActual() != null) {//substitute
                    recanviLlista = new RecanviLlista();
                    afegirListenersLlista();
                } else {
                    menuRecanvis.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuRecanvis.getFrame(), "Abans s'ha de crear al menys un taller en el menú de tallers.");
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
