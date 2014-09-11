/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Controleur.AccesBD.CreerDonnee;
import Controleur.AccesBD.LireDonnee;
import Modele.Boisson;
import Modele.Confiserie;
import Modele.Dette;
import Modele.Produit;
import Vue.VuePrincipale;
import java.util.ArrayList;

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
        this.dataReader = new LireDonnee();
    }

    public void setVue(VuePrincipale vue) {
        this.vue = vue;

    }

    public ArrayList<Dette> recupDettes() {
        return this.dataReader.recupererDettes();
    }

    public ArrayList<Produit> recupStock() {
        return this.dataReader.recupererStock();
    }

    public void Connexion(String id, String mdp) {
        if (dataReader.Connexion(id, mdp)) {
            this.vue.navigateTableauDeBord();
            System.out.println(mdp);
        }
    }

    public ArrayList<Boisson> getListeBoisson() {
        return dataReader.recupererListeBoisson();
    }

    public ArrayList<Confiserie> getListeConfiserie() {
        return dataReader.recupererListeConfiserie();
    }
}
