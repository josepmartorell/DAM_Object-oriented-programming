/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jtech
 */
public class MenuClients {
    
    private JFrame frame;

    private JButton[] menuButtons = new JButton[6];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    public MenuClients() {
        
        //Definició de la finestra del menú
        frame = new JFrame("Menú Clients");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels botons a la llista
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Alta Client");
        menuButtons[2] = new JButton("2. Llistar Clients");
        menuButtons[3] = new JButton("3. Modificar Clients");
        menuButtons[4] = new JButton("4. Eliminar Clients");
        menuButtons[5] = new JButton("5. Desar Client");
        
        //Addició dels botons a la finestra
        for (JButton boto : menuButtons) {
            frame.add(boto);
        }
        
        showFinestra();
    }
    
    private void showFinestra(){
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }
    
}