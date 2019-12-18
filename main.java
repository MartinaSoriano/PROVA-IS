/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoj;

import control.GestioneCorsi;
import entity.Appello;
import entity.Corso;
import entity.Studente;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author MARTINA
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
         
            
        try{
            
            Corso c= new Corso();
            GestioneCorsi g = new GestioneCorsi();
            Studente s = new Studente();
            Appello a = new Appello();
            
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c3= new Corso("Elettronica Generale", "Maresca Luca", 9);
            Corso c2= new Corso("Sistemi Operativi", "Pietrantuono Roberto", 9);
                        
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Studente s3=new Studente("N46006745","Leonardo", "Russo");
            Studente s4=new Studente("N46003209","Claudia", "Barone");
            Studente s5=new Studente("N46004856","Francesco", "Esposito");
            Studente s6=new Studente("N46006734","Luca", "Bruno");
            
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 20), Appello.Prova.SCRITTA);
            Appello a3=new Appello(LocalDate.of(2019, Month.DECEMBER, 20), Appello.Prova.ORALE);
            Appello a4=new Appello(LocalDate.of(2020, Month.JANUARY, 27), Appello.Prova.CALCOLATORE);
            Appello a5=new Appello(LocalDate.of(2020, Month.JANUARY, 21), Appello.Prova.SCRITTA);      
            
            g.creaCorso(c1);
            g.creaCorso(c2);
            g.creaCorso(c3);
                        
            g.visualizzaCorsi();
            
            c1.aggiungiAppello(a1,c1,g);
            c1.aggiungiAppello(a2,c1,g);
            c2.aggiungiAppello(a3,c2,g);
            c2.aggiungiAppello(a4,c2,g);
            c3.aggiungiAppello(a5,c3,g);
                     
            
            c1.visualizzaAppelli();
            c2.visualizzaAppelli();
            c3.visualizzaAppelli();
            
            a1.prenotazioni(s1,c1,a1,g);
            a2.prenotazioni(s3,c1,a2,g);
            a2.prenotazioni(s4,c2,a2,g);
            a3.prenotazioni(s5,c2,a3,g);
            a4.prenotazioni(s6,c2,a4,g);
            a5.prenotazioni(s3,c3,a5,g);
                      
            
            a1.visualizzaStudenti();
            a2.visualizzaStudenti();
            a3.visualizzaStudenti();
            a4.visualizzaStudenti();
            a5.visualizzaStudenti();


            
            
        }
        
            catch(Exception e){
            e.printStackTrace();
        }
    
        
            
}
        
        
}  
    

