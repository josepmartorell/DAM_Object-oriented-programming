/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import javax.swing.table.AbstractTableModel;
import model.Client;
import principal.Component;

/**
 *
 * @author jtech
 */
public class ClientTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"Nif", "Nom", "Telefon", "Correu"};

    private String[][] data;

    public ClientTableModel() {
        
        int i = 0;
        
        int totalClients = 0;

        for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++) {

            if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Client) {
                totalClients++;
            }           
        }

        data = new String[totalClients][4];
        
        for (Component component : ControladorPrincipal.getTallerActual().getComponents()) {
            if (component instanceof Client) {
                data[i][0] = ((Client)component).getNif();
                data[i][1] = ((Client)component).getNom();
                data[i][2] = ((Client)component).getTelefon();
                data[i][3] = ((Client)component).getCorreu();
                i++;
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }
    
}
