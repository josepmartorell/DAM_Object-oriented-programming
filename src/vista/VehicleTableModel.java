/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import javax.swing.table.AbstractTableModel;
import model.Vehicle;
import principal.Component;

/**
 *
 * @author jtech
 */
public class VehicleTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"Matricula", "Marca", "Model", "Color"};

    private String[][] data;
    

    public VehicleTableModel() {
        
        int i = 0;
        
        int totalRecanvis = 0;

        for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++) {

            if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Vehicle) {
                totalRecanvis++;
            }           
        }

        data = new String[totalRecanvis][4];
        
        for (Component component : ControladorPrincipal.getTallerActual().getComponents()) {
            if (component instanceof Vehicle) {
                data[i][0] = ((Vehicle)component).getMatricula();
                data[i][1] = ((Vehicle)component).getMarca();
                data[i][2] = ((Vehicle)component).getModel();
                data[i][3] = ((Vehicle)component).getColor();
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

