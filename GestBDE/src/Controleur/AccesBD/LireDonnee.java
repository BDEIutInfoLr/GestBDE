/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur.AccesBD;

import Modele.Dette;
import Modele.Eleve;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utilisateur
 */
public class LireDonnee {
    private AccesBD accesBD;

    public LireDonnee() {
        this.accesBD = new AccesBD();
    }
    
    public boolean Connexion(String id, String mdp){
        String sql = "SELECT ID_ADMIN FROM ADMIN WHERE LOGIN = '" + id +"' AND MDP = '" + mdp + "'";
        try {
            return !accesBD.interrogerBase(sql).isEmpty();
        } catch (Exception e) {
            System.out.println(e);
        };
        return false;
    }
    
    public ArrayList<Dette> recupererDettes()
    {
        String sql = "select D.ID_DETTE, D.ID_ELEVE_DETTE, D.ID_VENTE, D.CREANCE, E.NOM, E.PRENOM FROM DETTE D, ELEVE E";
        ArrayList<Dette> retour = new ArrayList<>();
        try {
            List<List<String>> listResultats = this.accesBD.interrogerBase(sql);
            for(List<String> ls : listResultats)
            {
                int id = Integer.parseInt(ls.get(0));
                int idVentes = Integer.parseInt(ls.get(2));
                Eleve e = new Eleve(Integer.parseInt(ls.get(2)), ls.get(4), ls.get(5));
                int montant = Integer.parseInt(ls.get(3));
                retour.add(new Dette( id, idVentes, e, montant));
            }
            return retour;
        } catch (SQLException ex) {
            Logger.getLogger(LireDonnee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
