/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpjsp;




/**
 * Un enregistrement de la table DISCOUNT_CODE
 * @author pedago
 */
public class CodeDiscount {
    private String code;
    
    private float taux;
    
    public CodeDiscount(String codeC, float tauxC) {
        this.code = codeC;
        this.taux = tauxC;
    }
    
    public String getCodeDiscount() {
        return code;
    }
    
    public float getTauxDiscount() {
        return taux;
    }
}
