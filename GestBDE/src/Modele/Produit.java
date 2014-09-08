/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

/**
 *
 * @author Antoine
 */
public class Produit {
    
    private int id;
    private String nomProduit;
    private double prixVente;
    private double prixAchat;
    private String cheminIcone;
    

    public String getNomProduit() {
        return nomProduit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Produit(String nomProduit, double prixVente, double prixAchat) {
        this.nomProduit = nomProduit;
        this.prixVente = prixVente;
        this.prixAchat = prixAchat;
    }

}
