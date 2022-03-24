/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import javax.swing.table.AbstractTableModel;
import model.Recanvi;
import model.Reparacio;
import principal.Component;

/**
 *
 * @author jtech
 */
public class ReparacioTableModel extends AbstractTableModel{
    
        private final String[] columnNames = {"Codi", "Data Inici", "Data Fi"};

    private String[][] data;

    public ReparacioTableModel() {
        
        int i = 0;
        
        int totalReparacions = 0;

        for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++) {

            if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Reparacio) {
                totalReparacions++;
            }           
        }

        data = new String[totalReparacions][3];
        
        for (Component component : ControladorPrincipal.getTallerActual().getComponents()) {
            if (component instanceof Reparacio) {
                data[i][0] = ((Reparacio)component).getCodi();
                data[i][1] = ((Reparacio)component).getDataInici();
                data[i][2] = ((Reparacio)component).getDataFi();
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
        return columnNames.length;
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
