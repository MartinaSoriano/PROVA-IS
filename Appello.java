/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import control.GestioneCorsi;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author MARTINA
 */
public class Appello {
    
    private LocalDate Data;
    public Prova prova;   
    public ArrayList<Studente> lista_studenti;

       
    public enum Prova { SCRITTA,
    ORALE,
    CALCOLATORE;
    }
    
    
    public Prova getProva(){
        return prova;
    }
    
    
    public void setProva(String s) {
       this.prova = Prova.valueOf(s);
    }
    
    
    public Appello(){
        Data=null;
        prova=null;
       
        lista_studenti = new ArrayList<>();
        
    }
    
    public Appello(LocalDate Data, Prova prova){
        this.Data=Data;
        
        this.prova=prova;
        lista_studenti=new ArrayList<>();
    }
    
   
    
    public LocalDate getData(){
        return Data;
    }
    
    public void setData(LocalDate Data){
        this.Data=Data;
    }
    
   
    
    public ArrayList getStudenti(){
        return lista_studenti;
    }
    
    public void setStudenti(ArrayList lista_studenti){
        this.lista_studenti=lista_studenti;
    }
    	
    
	
	public ArrayList<Studente> ricercaStudente(String Matricola) {
		
                ArrayList<Studente> lista_risultati_studenti = new ArrayList<>();
               
                for(Studente Stud : lista_studenti) {
			
			if( Stud.getMatricola().equals(Matricola) ) {
							
				lista_risultati_studenti.add(Stud);
			}
		}
		
		return lista_risultati_studenti;
	}
        
     		
	public void prenotazioni(Studente stud, Corso c, Appello a, GestioneCorsi g) {
            
            ArrayList c_ricerca= g.ricercaCorso(c.getNome());
            ArrayList a_ricerca = c.ricercaAppello(a.getData());
            ArrayList s_ricerca = ricercaStudente(stud.getMatricola());
           
            if(c_ricerca.isEmpty()){
                System.out.println("NON ESISTONO CORSI.");
                               
            }
            
            else
              if(!c_ricerca.isEmpty()) {
                 if(a_ricerca.isEmpty()){
                    System.out.println("NON ESISTONO APPELLI");
                    c_ricerca.remove(c);
                  }
                                                   
            else
               if(!a_ricerca.isEmpty()){
                  if(s_ricerca.isEmpty()){
                        a_ricerca.add(a);
                        c_ricerca.add(c);
                        lista_studenti.add(stud);
                    }
                                                       
            else
               if(!s_ricerca.isEmpty()){
                    System.out.println("QUESTO STUDENTE E' GIA' PRENOTATO.");
                    a_ricerca.remove(a);
                    c_ricerca.remove(c);
                    s_ricerca.remove(stud);
                        }
                    }
                }
        }
        
        
	public void rimuoviStudentePrenotato(Studente s){
		
		lista_studenti.remove(s);		
	}
        
       
       public void visualizzaStudenti() {
        
            if(lista_studenti.isEmpty()){
                System.out.println("NON CI SONO STUDENTI PRENOTATI PER L'APPELLO DEL "+getData());
                }
            else{
                System.out.println("\nGLI STUDENTI PRENOTATI PER L'APPELLO DEL "+getData()+" SONO:");
                for(Studente s : lista_studenti){
                System.out.println(s.toString());
                }
        } 
       }
       
    @Override
    public String toString(){
        
        return "LA PROVA "+ getProva() + " E' IL " + getData();
    }  
}
