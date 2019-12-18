/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Corso;
import java.util.ArrayList;

/**
 *
 * @author MARTINA
 */
public class GestioneCorsi{
     private ArrayList<Corso> lista_corso;
	
   
	
	public GestioneCorsi() {
      
           lista_corso=new ArrayList<>();

	}
	
	
       public ArrayList<Corso> getCorso() {
		return lista_corso;
	}
	
       
	public ArrayList<Corso> ricercaCorso(String NomeCorso) {
		
		ArrayList<Corso> lista_risultati = new ArrayList<>();
               
		for(Corso c: lista_corso) {
		
			if(c.getNome().equals(NomeCorso)){
				 
				lista_risultati.add(c);
                            
                        }
                      
          }    
       
              return lista_risultati;
	}
	
	
	
	public void creaCorso(Corso c) {
           
            ArrayList c_ricerca = ricercaCorso(c.getNome());
            
        if(c_ricerca.isEmpty()){
                lista_corso.add(c);
              }   
        
        else
           if(!c_ricerca.isEmpty()){
                System.out.println("IL CORSO E' GIA' PRESENTE.");
                c_ricerca.remove(c);
            }
        }
        
	
	public void rimuoviCorso(Corso c){
		
		lista_corso.remove(c);		
	}
        
        
        public Corso modificaCorso(Corso c){
                                 
            int index = lista_corso.indexOf(c);
            return lista_corso.set(index, c);
        
        }
       
	
	public void visualizzaCorsi() {
           
            if(lista_corso.isEmpty()){
            System.out.println("NON ESISTONO CORSI.");
            }
            
            else {
            System.out.println("I CORSI SONO:");
            for(Corso c : lista_corso) {
                System.out.println(c.toString());
		}
            }
        }
       }
