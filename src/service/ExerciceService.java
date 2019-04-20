/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;
import java.sql.*;
import model.Etudiant;

/**
 *
 * @author leonnel ghomsi
 */
public class ExerciceService {
    
   String url = "jdbc:mysql://localhost:3306/School_db";
    String username = "root";
    String password = "";
    Connection conn = null;
    
    public ExerciceService(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Chargement du Pilote ok");
            
            conn = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
     //enregistrer un nouveau etudiant;
      public boolean nouvelEtudiant(Etudiant etu){
            try{
                Statement req=conn.createStatement();
                String reqSQL="INSERT INTO  etudiant value(null,'" + etu.getMatricule() + "','" 
                        + etu.getNom() + "','" + etu.getFiliere() + "'," + etu.getNiveau()+")";
                int res =req.executeUpdate(reqSQL);
                return true;
            }catch(Exception e){
            e.printStackTrace();    
            return false;
            }
     }
        //etats des  etudiants;
       public void afficherListeEtudiant(){
        try{
            Statement req = conn.createStatement();
            String reqSQL = "SELECT * FROM etudiant";
            ResultSet res = req.executeQuery(reqSQL);
            while(res.next()){
                System.out.println(res.getString("matricule") + ":" + res.getString("nom") + ":" + res.getString("filiere") + ":" + res.getInt("niveau"));
                
            }
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
        //etat des  etudiants par filiere;
        public void afficherListeEtudiantfil(String filiere){
        try{
            Statement req = conn.createStatement();
            String reqSQL = "SELECT * FROM etudiant WHERE filiere='"+filiere+"'";
            ResultSet res = req.executeQuery(reqSQL);
            while(res.next()){
             
                System.out.println(res.getString("matricule") + ":" + res.getString("nom") + ":" + res.getInt("niveau"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
           
        }
    }
        //rechercher un etudiant;
         public void rechercherEtudiantmat(String matricule){
                try{
                   Statement req=conn.createStatement();
                 String reqSQL="SELECT FROM etudiant WHERE matricule='+matricule'";
                  ResultSet res=req.executeQuery(reqSQL);
                  while(res.next()){

                   System.out.println(res.getString("matricule") + ":" + res.getString("nom") + ":" + res.getString("filiere")+":"+res.getInt("niveau"));
                  }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
         
          //supprimer un etudiant 
    public void deleteMatricule(String matricule){
        try{
            Statement req = conn.createStatement();
            String sql = "DELETE FROM etudiant WHERE matricule= '"+matricule+"'";
            int res = req.executeUpdate(sql);
                System.out.println("La suppression du matricule a bien été effectuée. ");
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //modification du niveau d'un etudiant
    public void modifyNiveauEtudiant(String matricule,int niveau){
        try{
            Statement req= conn.createStatement();
             String sql = "UPDATE etudiant SET niveau="+niveau+"WHERE matricule = '"+matricule+"'";
             int res=req.executeUpdate(sql);
             
             System.out.println("****************************");
             System.out.println("apres modification : ");
             
           System.out.println("le niveau est bien modifier");
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
   
    
}
