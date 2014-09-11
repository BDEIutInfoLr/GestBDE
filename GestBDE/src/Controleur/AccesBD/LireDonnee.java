/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur.AccesBD;

import Modele.Boisson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
   
    
    
}
