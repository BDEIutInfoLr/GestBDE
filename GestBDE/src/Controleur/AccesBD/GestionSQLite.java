/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur.AccesBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author utilisateur
 */
public class GestionSQLite {
    public static void init()
    {
        Connection c = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:GestBDE.db");
        }
        catch(Exception e)
        {
            
        }
    }
}
