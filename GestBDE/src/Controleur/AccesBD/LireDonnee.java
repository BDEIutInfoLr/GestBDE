/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur.AccesBD;

import Modele.Boisson;
import Modele.Confiserie;
import Modele.Dette;
import Modele.Eleve;
import Modele.Produit;
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
                                                                   + "ORDER BY NOM_PRODUIT");
            for (List<String> row : resultats) {
                String nomProduit = row.get(0);
                double prixVente = Double.parseDouble(row.get(1));
                int stock = Integer.parseInt(row.get(2));
                
                lesBoissons.add(new Boisson(nomProduit,prixVente,stock));
            }
        } catch (SQLException e) {
            System.out.println("Erreur recuperation de la liste des boissons disponible");
        }

        return lesBoissons;
    }        
   
    public ArrayList<Confiserie> recupererListeConfiserie(){
        ArrayList<Confiserie> lesConfiserie = new ArrayList<>();
        try {
            List<List<String>> resultats = monAccesBD.interrogerBase("SELECT NOM_PRODUIT, PRIX_VENTE, STOCK "
                                                                   + "FROM PRODUIT "
                                                                   + "WHERE CATEGORIE = 'CONFISERIE' "
                                                                   + "ORDER BY NOM_PRODUIT");
            for (List<String> row : resultats) {
                String nomProduit = row.get(0);
                double prixVente = Double.parseDouble(row.get(1));
                int stock = Integer.parseInt(row.get(2));
                
                lesConfiserie.add(new Confiserie(nomProduit,prixVente,stock));
            }
        } catch (SQLException e) {
            System.out.println("Erreur recuperation de la liste des confiseries disponible");
        }

        return lesConfiserie;
    }
    
    
    public ArrayList<Dette> recupererDettes()
    {
        String sql = "select D.ID_DETTE, D.ID_ELEVE_DETTE, D.ID_VENTE, D.CREANCE, E.NOM, E.PRENOM "
                + "FROM DETTE D, ELEVE E "
                + "Where e.id_eleve = D.Id_eleve_dette";
        ArrayList<Dette> retour = new ArrayList<>();
        try {
            List<List<String>> listResultats = this.monAccesBD.interrogerBase(sql);
            if(listResultats != null)
            {
                for(List<String> ls : listResultats)
                {
                    int id = Integer.parseInt(ls.get(0));
                    int idVentes = Integer.parseInt(ls.get(2));
                    Eleve e = new Eleve(Integer.parseInt(ls.get(2)), ls.get(4), ls.get(5));
                    double montant = Double.parseDouble(ls.get(3));
                    retour.add(new Dette( id, idVentes, e, montant));
                }
                System.out.println("test");
                return retour;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LireDonnee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
    
    public ArrayList<Produit> recupererStock()
    {
        String sql = "SELECT id_produit, nom_produit, prix_vente, prix_achat, chemin_icone, categorie, stock FROM produit ORDER BY CATEGORIE, STOCK DESC";
        try {
            ArrayList<Produit> produits = new ArrayList<>();
            List<List<String>> resultats = this.monAccesBD.interrogerBase(sql);
            for(List<String> ls : resultats)
            {
                int id = Integer.parseInt(ls.get(0));
                String nom = ls.get(1);
                double prixVente = Double.parseDouble(ls.get(2));
                double prixAchat = Double.parseDouble(ls.get(3));
                String cheminIcone = ls.get(4);
                int stock = Integer.parseInt(ls.get(6));
                produits.add(new Produit(id, nom, prixVente, prixAchat, cheminIcone, stock));
                
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(LireDonnee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
