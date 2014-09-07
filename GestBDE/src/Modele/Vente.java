/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class Vente {
    private int id;
    private ArrayList<Produit> prodVendu;
    private String dateVente;

    public Vente(int id, ArrayList<Produit> prodVendu, String dateVente) {
        this.id = id;
        this.prodVendu = prodVendu;
        this.dateVente = dateVente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produit> getProdVendu() {
        return prodVendu;
    }

    public void setProdVendu(ArrayList<Produit> prodVendu) {
        this.prodVendu = prodVendu;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }
    
}
