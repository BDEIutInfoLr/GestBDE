package Vue.modelPres;


import Modele.Dette;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utilisateur
 */
public class ModeleTableDette extends AbstractTableModel
{
    private List<Dette> listeDesDettes;
    private String[] nomColonnes;
    
    public ModeleTableDette(List<Dette> listeDesDettes)
    {
        this.listeDesDettes = listeDesDettes;
        this.nomColonnes = new String[]{"Eleve", "Dette"};
    }
     
    @Override
    public int getRowCount() {
        return this.listeDesDettes.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return this.listeDesDettes.get(rowIndex).getEleveEndete().getNom();
            case 1: return this.listeDesDettes.get(rowIndex).getMontant();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0 : return String.class;
            case 1 : return Double.class;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        return this.nomColonnes[columnIndex];
    }
    
}
