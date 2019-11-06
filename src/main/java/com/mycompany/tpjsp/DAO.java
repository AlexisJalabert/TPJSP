/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpjsp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO {
    private final DataSource mySource;
    
    public DAO(DataSource datasource) {
        this.mySource = datasource;
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public List<CodeDiscount> allData() throws Exception {
        List<CodeDiscount> resultat = new LinkedList();
        String sql = "SELECT * FROM DISCOUNT_CODE";
        try (Connection myConnection = mySource.getConnection();
             PreparedStatement stmt = myConnection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String code = rs.getString("DISCOUNT_CODE");
                float taux = rs.getFloat("RATE");
                CodeDiscount element = new CodeDiscount(code, taux);
                resultat.add(element);
            }
        }
        return resultat;
    }
    
    public int ajouterCodeDiscount(String code, float taux) throws Exception {
        int resultat = 0;
        String sql = "INSERT INTO DISCOUNT_CODE VALUES (?,?)";
        try (Connection myConnection = mySource.getConnection();
                PreparedStatement stmt = myConnection.prepareStatement(sql)) {
            stmt.setString(1, code);
            stmt.setFloat(2,taux);
            resultat = stmt.executeUpdate();
        }
        return resultat;
    }
    
    public int supprCodeDiscount(String code) throws Exception {
        int resultat = 0;
        String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        try (Connection myConnection = mySource.getConnection();
                PreparedStatement stmt = myConnection.prepareStatement(sql)) {
            stmt.setString(1,code);
            resultat = stmt.executeUpdate();
        }
        return resultat;
    }
    
}
