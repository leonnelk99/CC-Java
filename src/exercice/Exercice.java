/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercice;

import java.util.Scanner;
import model.Etudiant;
import service.ExerciceService;

/**
 *
 * @author leonnel ghomsi
 */
public class Exercice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
         Scanner sc=new Scanner (System.in);
         Etudiant et1,et2,et3,et,et10,et4,et5,et6,et9;
         Etudiant e;
         
        int niv , choix;
        String mat,fil,nom;
        
        ExerciceService   service;
        service =new ExerciceService();
        
         do{
        System.out.println("----------------menu-------------------------");
        System.out.println("1. Enregistrer un nouvel etudiant");
        System.out.println("2. liste de tous les etudiants");
        System.out.println("3. liste de tous les etudiants d'une filiere donnée");
        System.out.println("4. Recherche et affiche les informations d un etudiant par son matricule");
        System.out.println("5. Suppression d'un etudiant a partir de son matricule"); 
        System.out.println("6. modification du niveau d'un etudiant donné");
        System.out.println("Veuillez entrer votre choix(1-6): ");
        
         choix=sc.nextInt(); 
         
          switch(choix)
      { 
          //methode d'enregistrement d'un nouvel etudiant
          case 1:
         System.out.print("Entrer le matricule: ");
         mat= sc.next();
         System.out.print("Entrer le nom : ");
         nom= sc.next();
         System.out.print("Entrer la filiere : ");
         fil=sc.next();
         System.out.print("Entrer le niveau : ");
         niv= sc.nextInt(); 
          e = new Etudiant(mat,nom,fil,niv);
          service.nouvelEtudiant(e);
          System.out.println(" Enregistrement  effectué ");
                   
              break;
              //methode d'affichage de tous les etudiant
              case 2: 
                  service.afficherListeEtudiant(); 
           
              break;
                  //methode d'affichage des etudiant par filiere
                   case 3: 
                  System.out.print("Entrer la filiere: "); 
           fil=sc.next();
           service.afficherListeEtudiantfil(fil);
           
              break;
                  case 4:
                      //methode de recherche d'un etudiant par filiere
                      System.out.print("Entrer le matricule de l etudiant à rechercher : ");
                mat= sc.next();
                System.out.print("l'etudiant rechercher est: ");
                service.rechercherEtudiantmat(mat);
           
              break;
                //methode de suppression
                 case 5:
                     System.out.print("Entrer le matricule de l'etudiant à supprimer : ");
                mat= sc.next();
                service.deleteMatricule(mat);
                service.afficherListeEtudiant();
                System.out.println("suppression reussie");
            
              break;
             //methode de modification du niveau d'un etudiant
                  case 6:
                System.out.print("Entrer le matricule  de l'etudiant : ");
                mat= sc.next();
                System.out.print("Modifier le niveau de l'etudiant : ");
                niv= sc.nextInt();
                service.modifyNiveauEtudiant(mat,niv);
                service.afficherListeEtudiant();
                System.out.println("Mise à jour effectuée"); 
                      break;
                  default:System.out.println("veuillez rester l'ordre");
    } 
      }while(choix!=6);
        
  }     
        
    
    
}
    

