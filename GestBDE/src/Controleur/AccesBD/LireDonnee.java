/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur.AccesBD;

import Modele.Boisson;
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
    private AccesBD monAccesBD;

    public LireDonnee() {
        this.monAccesBD = new AccesBD();
    }
    
    public boolean Connexion(String id, String mdp){
        String sql = "SELECT ID_ADMIN FROM ADMIN WHERE LOGIN = '" + id +"' AND MDP = '" + mdp + "'";
        try {
            return !monAccesBD.interrogerBase(sql).isEmpty();
        } catch (Exception e) {
            System.out.println(e);
        };
        return false;
    }
    
    public ArrayList<Boisson> recupererListeBoisson(){
        ArrayList<Boisson> lesBoissons = new ArrayList<>();
        try {
            List<List<String>> resultats = monAccesBD.interrogerBase("SELECT NOM_PRODUIT, PRIX_VENTE, STOCK "
                                                                   + "FROM PRODUIT "
                                                                   + "WHERE CATEGORIE = 'BOISSON' "
                                                                   + "AND ORDRE BY NOM_PRODUIT");
            for (List<String> row : resultats) {
                String nomProduit = row.get(0);
                double prixVente = Double.parseDouble(row.get(1));
                int stock = Integer.parseInt(row.get(2));
                
                lesBoissons.add(new Boisson(nomProduit,prixVente,stock));
            }
        } catch (SQLException e) {
            System.out.println("Erreur recuperation de la liste des series disponible");
        }

        return lesBoissons;
    }        
   
    public ArrayList<Dette> recupererDettes()
    {
        String sql = "select D.ID_DETTE, D.ID_ELEVE_DETTE, D.ID_VENTE, D.CREANCE, E.NOM, E.PRENOM FROM DETTE D, ELEVE E";
        ArrayList<Dette> retour = new ArrayList<>();
        try {
            List<List<String>> listResultats = this.monAccesBD.interrogerBase(sql);
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
