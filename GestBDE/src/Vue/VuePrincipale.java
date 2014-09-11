/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controleur.Controler;
import Vue.pannel.ConnexionPannel;
import Vue.pannel.TableauDeBordPanel;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Antoine
 */
public class VuePrincipale extends javax.swing.JFrame {

    private Controler controler;
    private ConnexionPannel connexionPanel;
    private TableauDeBordPanel tableauDeBordPanel;
    public VuePrincipale(Controler controler) {
        initComponents();
        this.controler=controler;
        this.tableauDeBordPanel = new TableauDeBordPanel(controler);
        this.connexionPanel = new ConnexionPannel(this.controler);
        this.setContentPane(this.connexionPanel);
        this.setSize(this.connexionPanel.getPreferredSize());
        this.barreMenu.setVisible(false);
        this.validate();
    }

    
    public void navigateTableauDeBord(){
        this.setContentPane(this.tableauDeBordPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.barreMenu.setVisible(true);
        this.initTableauDeBord();
        this.validate();
    }
    
    public void initTableauDeBord(){
        tableauDeBordPanel.initTableauDeBord(controler.getListeBoisson(), controler.recupDettes());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        barreMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");
        barreMenu.add(jMenu1);

        jMenu2.setText("Edit");
        barreMenu.add(jMenu2);

        setJMenuBar(barreMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barreMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
