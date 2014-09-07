/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.accesbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssinigag
 */
public class AccesBD {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String dbpath = "../GestBDE.db";

    /**
     * Creates a new instance of Sqlite
     */
    public AccesBD() {
        // driver to load
        try {
            Class.forName("org.sqlite.JDBC");

        } catch (Exception e) {
            System.out.println("DB ERROR: " + e);

        }

    }

    private Connection getConnection()
            throws SQLException {
        Connection cnx = DriverManager.getConnection("jdbc:sqlite:GestBDE.db");
        return cnx;
    }

    public int mettreAJourBase(String ordreSQL) throws SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        int nb = stmt.executeUpdate(ordreSQL);
        return nb;
    }

    public List interrogerBase(String requeteSQL) throws SQLException {
        List resultats = new ArrayList();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(requeteSQL);      
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        List enregistrement;
        for (; rs.next(); resultats.add(enregistrement)) {
            enregistrement = new ArrayList();
            for (int i = 1; i <= columnCount; i++) {
                String col = rs.getString(i);
                if (rs.wasNull()) {
                    enregistrement.add(null);
                } else {
                    enregistrement.add(col);
                }
            }
        }
        rs.close();
        stmt.close();
        con.close();
        return resultats;
    }    
}
