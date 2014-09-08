/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Controleur.AccesBD.CreerDonnee;
import Controleur.AccesBD.LireDonnee;
import Vue.VuePrincipale;

/**
 *
 * @author Antoine
 */
public class Controler {

    private VuePrincipale vue;
    private CreerDonnee dataRecorder;
    private LireDonnee dataReader;

    public Controler() {
        this.dataRecorder = new CreerDonnee();
    }

    public void setVue(VuePrincipale vue) {
        this.vue = new VuePrincipale(this);

    }

    public void Connexion(String id, String mdp) {
        if (dataReader.Connexion(id, mdp)){
            
        }
    }
}
