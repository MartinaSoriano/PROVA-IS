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
public class Corso {
    private String Nome;
    private String Docente;
    private int Crediti;
    private ArrayList<Appello> lista_appelli;
    
    
    public Corso(){
        Nome="";
        Docente="";
        Crediti= 0;
        lista_appelli=new ArrayList<>();
        
          }
    
    public Corso(String Nome, String Docente, int Crediti){
        this.Nome=Nome;
        this.Docente=Docente;
        this.Crediti=Crediti;
        lista_appelli=new ArrayList<>();        
    }
    
    public Corso(String Nome, String Docente, int Crediti, ArrayList lista_appelli){
        this.Nome=Nome;
        this.Docente=Docente;
        this.Crediti=Crediti;
        this.lista_appelli=lista_appelli;
    }
    
       
    public String getNome(){
        return Nome;
    }
    
    public String getDocente(){
        return Docente;
    }
    
    public int getCrediti(){
        return Crediti;
    }
    
    public ArrayList getAppello(){
        return lista_appelli;
    }
    
    public void setAppello(ArrayList lista_appelli){
        this.lista_appelli=lista_appelli;
    }
    
    public Appello modificaCorso(Appello a){
                                 
            int index = lista_appelli.indexOf(a);
            return lista_appelli.set(index, a);
      }
        
    public void setNome(String Nome){
        this.Nome=Nome;
    }
    
    public void setDocente(String Docente){
        this.Docente=Docente;
    }
    
    public void setCrediti(int Crediti){
        this.Crediti=Crediti;
    }
    
     
	public ArrayList<Appello> ricercaAppello( LocalDate Data) {
		
                ArrayList<Appello> lista_risultati = new ArrayList<>();
            
		for(Appello a : lista_appelli) {
			
			if(a.getData().equals(Data) )  {
				
                           lista_risultati.add(a);
			}
              
	}
               return lista_risultati;
        }
	
	
        
	public void aggiungiAppello(Appello a, Corso c, GestioneCorsi g) {
                       
            ArrayList c_ricerca = g.ricercaCorso(c.getNome());
            ArrayList a_ricerca = ricercaAppello(a.getData());
            
            if(c_ricerca.isEmpty()){
                System.out.println("NON ESISTONO CORSI.");
               }
            
            else
                if(!c_ricerca.isEmpty()){
                    if(a_ricerca.isEmpty()){
                        a_ricerca.add(a);
                        lista_appelli.add(a);
                      }
            else
              if(!a_ricerca.isEmpty()){
                          System.out.println("L'APPELLO E' GIA' PRESENTE.");
                          a_ricerca.remove(a);
                          c_ricerca.remove(c);
                          
                          
                       }
                  }
              
        }    
                   

	public void rimuoviAppello(Appello a){
		
		lista_appelli.remove(a);		
	}
        
        
        public Appello modificaAppello(Appello a){
                                 
            int index = lista_appelli.indexOf(a);
            return lista_appelli.set(index, a);
        
        }
        
       
           
   public void visualizzaAppelli() {
              
        if(lista_appelli.isEmpty()){
            System.out.println("PER IL CORSO "+getNome()+" NON CI SONO APPELLI.");
            }
        else{
            System.out.println("\nPER IL CORSO "+getNome()+" ");        
            for(Appello a : lista_appelli) {
            System.out.println(a.toString());
        }
        }
  }
        
    
    @Override
    public String toString(){
        
       return "NOME CORSO: " + getNome()+ "\nDOCENTE: " + getDocente() + "\nCREDITI: " + getCrediti() + "\n";
       
    }
}
