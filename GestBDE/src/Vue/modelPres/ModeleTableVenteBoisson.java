/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.modelPres;

import Controleur.Controler;
import Modele.Boisson;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author utilisateur
 */
public class ModeleTableVenteBoisson extends AbstractTableModel {

    private ArrayList<Boisson> listeBoisson;
    private ArrayList<String> colonnes;
    private Controler controler;

    public ModeleTableVenteBoisson(ArrayList<Boisson> listeBoisson, Controler controler){
        this.controler=controler;
        this.listeBoisson = listeBoisson;
        
        colonnes = new ArrayList<>();
        colonnes.add("Nom");
        colonnes.add("Quantité");
        
    }
    @Override
    public int getRowCount() {
        return listeBoisson.size();
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
