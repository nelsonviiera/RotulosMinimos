/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotulominimo;

/**
 *
 * @author Documentois
 */
public class Vertice {
     private String id;
    //private double peso = Double.POSITIVE_INFINITY;
    
    public Vertice(){
        this.id = String.valueOf(getClass().hashCode());
    }
    
    public Vertice(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
}
