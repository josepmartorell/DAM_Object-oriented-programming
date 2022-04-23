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
public class MenuReparacions {
    
    JFrame frame;
    
    private JButton[] menuButtons = new JButton[11];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    public MenuReparacions() {
        
        frame = new JFrame("Menu Reparacions");
        frame.setLayout(new GridLayout(0, 1));
        
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Alta"); 
        menuButtons[2] = new JButton("2. Modificar"); 
        menuButtons[3] = new JButton("3. Assignar client o clienta"); 
        menuButtons[4] = new JButton("4. Assignar vehícle"); 
        menuButtons[5] = new JButton("5. Assignar mecanics");
        menuButtons[6] = new JButton("6. Assignar recanvis"); 
        menuButtons[7] = new JButton("7. Calcular preu");
        menuButtons[8] = new JButton("8. Llista de reparacions"); 
        menuButtons[9] = new JButton("9. Seleccionar reparació");
        menuButtons[10] = new JButton("10. Desar reparació"); 
        
        for (JButton boto: menuButtons){
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

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }
    
    
    
    
    
}


