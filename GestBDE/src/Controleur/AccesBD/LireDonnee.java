/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur.AccesBD;

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
        String sql = "SELECT IDENTIFIANT, MDP FROM ADMIN";
        try {
            return !accesBD.interrogerBase(sql).isEmpty();
        } catch (Exception e) {
            System.out.println(e);
        };
        return false;
    }
    
    
}