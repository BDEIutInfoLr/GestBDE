/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.modelPres;

import Modele.Produit;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author utilisateur
 */
public class ModeleTableStock extends AbstractTableModel
{
    private String[] columnNames;
    private ArrayList<Produit> produitsDisponibles;
    
    public ModeleTableStock(ArrayList<Produit> produitsDisponibles)
    {
        this.columnNames = new String[]{"Produit", "Quantité"};
        this.produitsDisponibles = produitsDisponibles;
    }

    @Override
    public int getRowCount() {
        return this.produitsDisponibles.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return this.produitsDisponibles.get(rowIndex).getNomProduit();
            case 1: return this.produitsDisponibles.get(rowIndex).getStock();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        return this.columnNames[columnIndex];
    }
}
