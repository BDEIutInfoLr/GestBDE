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
public class Dette {
    private int id;
    private int idDesVentes;
    private Eleve eleveEndete;
    private int montant;

    public int getId() {
        return id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Eleve getEleveEndete() {
        return eleveEndete;
    }

    public void setEleveEndete(Eleve eleveEndete) {
        this.eleveEndete = eleveEndete;
    }

    public Dette(int id, int idDesVentes, Eleve eleveEndete, int montant) {
        this.id = id;
        this.idDesVentes = idDesVentes;
        this.eleveEndete = eleveEndete;
        this.montant = montant;
    }
    
    
}
