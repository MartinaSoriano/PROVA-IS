/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import control.GestioneCorsi;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author MARTINA
 */
public class AppelloTest {
    
    GestioneCorsi g = new GestioneCorsi();
    
    public AppelloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    
    @Test
	public void test01CorsoNonTrovato() throws Exception{
           
           Corso c=new Corso("Ingegneria del Software", "Natella Roberto", 9);
           Studente s1=new Studente("N46003705","Martina", "Soriano");
           Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
           a1.prenotazioni(s1,c,a1,g);
           assertEquals(0,a1.lista_studenti.size());
	}
        

        @Test
        public void test02CorsoTrovatoSenzaAppelli() throws Exception{

        
           Corso c=new Corso("Ingegneria del Software", "Natella Roberto", 9);
           g.creaCorso(c);
           Studente s1=new Studente("N46003705","Martina", "Soriano");
           Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
           a1.prenotazioni(s1,c,a1,g);
           assertEquals(0,a1.lista_studenti.size());
	
           g.rimuoviCorso(c);
        }     

          @Test
        public void test03PiùCorsiNonTrovati() throws Exception{
            
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c2= new Corso("Elettronica Generale", "Maresca Luca", 9);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 20), Appello.Prova.SCRITTA);
            a1.prenotazioni(s1,c1,a1,g);
            a2.prenotazioni(s1,c1,a2,g);
            assertEquals(0,a1.lista_studenti.size());   
       
	}
        
      
                
     @Test
        public void test04CorsoTrovatoConAppelloConUnoStudentePrenotato() throws Exception{
 
           Corso c1= new Corso("Elettronica Generale", "Maresca Luca", 9);
           g.creaCorso(c1);
           Studente s1=new Studente("N46003705","Martina", "Soriano");
           Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 20), Appello.Prova.ORALE);
           c1.aggiungiAppello(a1,c1,g);
           a1.prenotazioni(s1,c1,a1,g);
           assertEquals(1,a1.lista_studenti.size());
           System.out.println(a1.lista_studenti.toString());
          	
        }         

        @Test
        public void test05PiùCorsiTrovatiSenzaAppello() throws Exception{
            
          
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c2= new Corso("Elettronica Generale", "Maresca Luca", 9);
            g.creaCorso(c1);
            g.creaCorso(c2);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 20), Appello.Prova.SCRITTA);
            a1.prenotazioni(s1,c1,a1,g);
            a2.prenotazioni(s1,c2,a2,g);
            assertEquals(0,a1.lista_studenti.size());   
            assertEquals(0,a2.lista_studenti.size());
	}
        
   @Test
        public void test06PiùCorsiTrovatiConAppelloSenzaStudentiPrenotati() throws Exception{
            
         
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c2= new Corso("Sistemi Operativi", "Pietrantuono Roberto", 9);
            g.creaCorso(c1);
            g.creaCorso(c2);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Studente s3=new Studente("N46006745","Leonardo", "Russo");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 27), Appello.Prova.CALCOLATORE);
            c1.aggiungiAppello(a1,c1,g);
            c2.aggiungiAppello(a2,c2,g);
            assertEquals(0,a1.lista_studenti.size());   
            assertEquals(0,a2.lista_studenti.size());
	
	}
            
        
    @Test
        public void test07StudenteGiaPrenotato() throws Exception{
          
          
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            g.creaCorso(c1);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            c1.aggiungiAppello(a1,c1,g);
            a1.prenotazioni(s1,c1,a1,g);
            a1.prenotazioni(s1,c1,a1,g);
            assertEquals(1,a1.lista_studenti.size());
            System.out.println(a1.lista_studenti.toString());
        }
      
     @Test
        public void test08CorsoTrovatoConAppelloConPiùStudentiPrenotati() throws Exception{

           
           Corso c1= new Corso("Elettronica Generale", "Maresca Luca", 9);
           g.creaCorso(c1);
           Studente s1=new Studente("N46003705","Martina", "Soriano");
           Studente s2=new Studente("N46003498","Mario", "Rossi");
           Studente s3=new Studente("N46006745","Leonardo", "Russo");
           Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 20), Appello.Prova.ORALE);
           c1.aggiungiAppello(a1,c1,g);
           a1.prenotazioni(s1,c1,a1,g);
           a1.prenotazioni(s2,c1,a1,g);
           a1.prenotazioni(s3,c1,a1,g);
           assertEquals(3,a1.lista_studenti.size());
           System.out.println(a1.lista_studenti.toString());	
}         

        @Test
        public void test09CorsoTrovatoConAppelloSenzaStudentiPrenotati() throws Exception{

            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            g.creaCorso(c1);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Studente s3=new Studente("N46006745","Leonardo", "Russo");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            c1.aggiungiAppello(a1,c1,g);
            assertEquals(0,a1.lista_studenti.size());   
                     	
}         
   
        @Test
        public void test10PiùStudentiGiàPrenotati() throws Exception{
          
          
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            g.creaCorso(c1);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Studente s3=new Studente("N46006745","Leonardo", "Russo");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            c1.aggiungiAppello(a1,c1,g);
            a1.prenotazioni(s1,c1,a1,g);
            a1.prenotazioni(s1,c1,a1,g);
            a1.prenotazioni(s2,c1,a1,g);
            a1.prenotazioni(s2,c1,a1,g);
            a1.prenotazioni(s3,c1,a1,g);
            a1.prenotazioni(s3,c1,a1,g);
            assertEquals(3,a1.lista_studenti.size());
            System.out.println(a1.lista_studenti.toString());
        }
        
         @Test
        public void test11PiùCorsiTrovatiConAppelloConStudentiPrenotati() throws Exception{
            
         
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c2= new Corso("Sistemi Operativi", "Pietrantuono Roberto", 9);
            g.creaCorso(c1);
            g.creaCorso(c2);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Studente s3=new Studente("N46006745","Leonardo", "Russo");
            Studente s4=new Studente("N46003209","Claudia", "Barone");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 27), Appello.Prova.CALCOLATORE);
            Appello a3=new Appello(LocalDate.of(2019, Month.DECEMBER, 20), Appello.Prova.ORALE);
            c1.aggiungiAppello(a1,c1,g);
            c2.aggiungiAppello(a2,c2,g);
            c2.aggiungiAppello(a3,c2,g);
            a1.prenotazioni(s1,c1,a1,g);
            a1.prenotazioni(s4,c1,a1,g);
            a2.prenotazioni(s3,c2,a2,g);
            a2.prenotazioni(s2,c2,a2,g);
            a2.prenotazioni(s1,c2,a2,g);
            a3.prenotazioni(s3,c2,a3,g);
            assertEquals(2,a1.lista_studenti.size());   
            assertEquals(3,a2.lista_studenti.size());
            assertEquals(1,a3.lista_studenti.size());
            System.out.println(a1.lista_studenti.toString());
            System.out.println(a2.lista_studenti.toString());
            System.out.println(a3.lista_studenti.toString());
	}
        
        @Test
        public void test12AppelloConStudentiEAppelloSenzaStudenti() throws Exception{
            
         
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c2= new Corso("Sistemi Operativi", "Pietrantuono Roberto", 9);
            g.creaCorso(c1);
            g.creaCorso(c2);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 27), Appello.Prova.CALCOLATORE);
            c1.aggiungiAppello(a1,c1,g);
            c2.aggiungiAppello(a2,c2,g);
            a1.prenotazioni(s1,c1,a1,g);
            a1.prenotazioni(s2,c1,a1,g);
            assertEquals(2,a1.lista_studenti.size());   
            assertEquals(0,a2.lista_studenti.size());
            System.out.println(a1.lista_studenti.toString());
            System.out.println(a2.lista_studenti.toString());
            
	} 
        
        
        
          @Test
        public void test13AppelliConStudentiEAppelloSenzaStudenti() throws Exception{
            
         
            Corso c1=new Corso("Ingegneria del Software", "Natella Roberto", 9);
            Corso c2= new Corso("Sistemi Operativi", "Pietrantuono Roberto", 9);
            g.creaCorso(c1);
            g.creaCorso(c2);
            Studente s1=new Studente("N46003705","Martina", "Soriano");
            Studente s2=new Studente("N46003498","Mario", "Rossi");
            Studente s3=new Studente("N46006745","Leonardo", "Russo");
            Studente s4=new Studente("N46003209","Claudia", "Barone");
            Appello a1=new Appello(LocalDate.of(2019, Month.DECEMBER, 19), Appello.Prova.ORALE);
            Appello a2=new Appello(LocalDate.of(2020, Month.JANUARY, 27), Appello.Prova.CALCOLATORE);
            Appello a3=new Appello(LocalDate.of(2019, Month.DECEMBER, 20), Appello.Prova.ORALE);
            c1.aggiungiAppello(a1,c1,g);
            c2.aggiungiAppello(a2,c2,g);
            c2.aggiungiAppello(a3,c2,g);
            a1.prenotazioni(s1,c1,a1,g);
            a1.prenotazioni(s2,c1,a1,g);
            a2.prenotazioni(s3,c2,a2,g);
            a2.prenotazioni(s4,c2,a2,g);
            a2.prenotazioni(s1,c2,a2,g);
            assertEquals(2,a1.lista_studenti.size());   
            assertEquals(3,a2.lista_studenti.size());
            assertEquals(0,a3.lista_studenti.size());
            System.out.println(a1.lista_studenti.toString());
            System.out.println(a2.lista_studenti.toString());
            System.out.println(a3.lista_studenti.toString());
	} 
}
    

