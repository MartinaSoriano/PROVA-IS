/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MARTINA
 */
public class Studente {
    
    private String Matricola;
    private String Nome;
    private String Cognome;
    
    
    public Studente(){
        Matricola="";
        Nome="";
        Cognome="";
     
    }
    
    public Studente(String Matricola, String Nome, String Cognome){
        
        this.Matricola=Matricola;
        this.Nome=Nome;
        this.Cognome=Cognome;
       
        
    }
    
    
    public String getMatricola(){
        return Matricola;
    }
    
    public String getNome(){
        return Nome;
    }
    
    public String getCognome(){
        return Cognome;
    }
      
    
    public void setMatricola(String Matricola){
        this.Matricola=Matricola;
    }
    
    public void setNome(String Nome){
        this.Nome=Nome;
    }
    
    public void setCognome(String Cognome){
        this.Cognome=Cognome;
    }

    
    
    public String toString(){
        
        return Matricola + "\t" + Nome + "\t" + Cognome;
    }

}
