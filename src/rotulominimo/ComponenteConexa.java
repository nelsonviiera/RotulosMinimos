/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotulominimo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Documentois
 */
public class ComponenteConexa {
    public ComponenteConexa(){
    
    }
    
    public void CCcount(GrafoListaAdjacencia grafo, int nVertice){
        int count = 0;//contador para números de componentes conexas
        List<String> listaVerticeNVisitado = new ArrayList<String>();//lista com os vertices nao visitados
        for(int i = 0; i < nVertice; i++){
            listaVerticeNVisitado.add(String.valueOf(i));
        }
        
        while(!listaVerticeNVisitado.isEmpty()){
            count++;
            Vertice v = grafo.getVertice(listaVerticeNVisitado.get(0));
            List<Vertice> listaVerticeAdj = new ArrayList<Vertice>();
            for(int i = 0; i < grafo.getVerticesAdjacentes(v).size(); i++){
                listaVerticeAdj.add(grafo.getVerticesAdjacentes(v).get(i));
            }
            listaVerticeNVisitado.remove(v.getId());//remove ele pq foi visitado
            
            while(!listaVerticeAdj.isEmpty()){
               List<Vertice> listaVerticeAdj2 = new ArrayList<Vertice>();
               Vertice v2 = grafo.getVertice(listaVerticeAdj.get(0).getId());
               System.out.println("Vertice asd:" + v2.getId());
               //listaVerticeAdj2 = grafo.getVerticesAdjacentes(v2);
               for(int i = 0; i < grafo.getVerticesAdjacentes(v2).size(); i++){
                   listaVerticeAdj2.add(grafo.getVerticesAdjacentes(v2).get(i));
               }

               for(int i = 0; i < listaVerticeAdj2.size(); i++){
                   if(listaVerticeNVisitado.contains(listaVerticeAdj2.get(i).getId()) && !listaVerticeAdj.contains(listaVerticeAdj2.get(i))){
                       listaVerticeAdj.add(listaVerticeAdj2.get(i));
                   }
               }
               
               listaVerticeNVisitado.remove(v2.getId()); 
               listaVerticeAdj.remove(v2);
            }
            //listaVerticeNVisitado.remove(0);
        }
        System.out.println(count);
    }
}
