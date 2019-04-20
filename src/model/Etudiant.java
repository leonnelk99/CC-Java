/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author leonnel ghomsi
 */
public class Etudiant {
    
    private String matricule;
    private String nom;
    private String filiere;
    private int niveau;

    public Etudiant() {
    }

    public Etudiant(String matricule, String nom, String filiere, int niveau) {
        this.matricule = matricule;
        this.nom = nom;
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getFiliere() {
        return filiere;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
    
}
