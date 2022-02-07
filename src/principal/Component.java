/*
 * Interfície que implementarà qualsevol component del taller
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author jma
 */
public interface Component {  
    
    public final static Scanner DADES = new Scanner(System.in);
    public void updateComponent(); 
    public void showComponent();     
    
}
