/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestbde;

import Controleur.AccesBD.GestionSQLite;
import Controleur.Controler;
import Vue.VuePrincipale;

/**
 *
 * @author Antoine
 */
public class GestBDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controler controler = new Controler();
        VuePrincipale vue = new VuePrincipale(controler);
        controler.setVue(vue);
        vue.setVisible(true);
    }
    
}
