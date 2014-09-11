/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.modelPres;

import Controleur.Controler;
import Modele.Confiserie;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author utilisateur
 */
public class ModeleTableVenteConfiserie extends AbstractTableModel {
    
    private ArrayList<Confiserie> listeConfiserie;
    private ArrayList<String> colonnes;

    public ModeleTableVenteConfiserie(ArrayList<Confiserie> listeConfiserie){
        this.listeConfiserie = listeConfiserie;
        
        colonnes = new ArrayList<>();
        colonnes.add("Nom");
        colonnes.add("Quantité");
        
    }
    @Override
    public int getRowCount() {
        return listeConfiserie.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return listeConfiserie.get(rowIndex).getNomProduit();
        } else {
           return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        return this.colonnes.get(columnIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex == 1;
    }

}
