/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import javax.swing.table.AbstractTableModel;
import model.Mecanic;
import principal.Component;

/**
 *
 * @author jtech
 */
public class MecanicTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Nif", "Nom", "Telefon", "Correu"};

    private String[][] data;

    public MecanicTableModel() {
        
        int i = 0;
        
        int totalMecanics = 0;

        for (int j = 0; j < ControladorPrincipal.getTallerActual().getComponents().size(); j++) {

            if (ControladorPrincipal.getTallerActual().getComponents().get(j) instanceof Mecanic) {
                totalMecanics++;
            }           
        }

        data = new String[totalMecanics][4];
        
        for (Component component : ControladorPrincipal.getTallerActual().getComponents()) {
            if (component instanceof Mecanic) {
                data[i][0] = ((Mecanic)component).getNif();
                data[i][1] = ((Mecanic)component).getNom();
                data[i][2] = ((Mecanic)component).getTelefon();
                data[i][3] = ((Mecanic)component).getCorreu();
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

