package com.example.liste_etd;

public class Etudiant {
    private String code;
    private String nom;
    private boolean isHeader;

    public Etudiant(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.isHeader = false;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

   /* public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
       isHeader = header;
    }

    */

    @Override
    public String toString() {
        return code + " - " + nom;
    }
}
