/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotulominimo;

import java.util.ArrayList;
import java.util.List;

/**
 * adicionar aresta na ida e volta para realmente conectar dois vertices, 19....17comp
 * @author Documentois
 */
public class MVCA {
    public MVCA(){
        
    }
    
    public void doMVCA(GrafoListaAdjacencia grafo, int nVertice, int[][] matrizAdj, int nRotulo){
        ComponenteConexa compconex = new ComponenteConexa();
        int count = nVertice;//contar componentes
        int countdef = 10000;
        int countaux;
        int label = -1;
        List<Integer> listaRotuloNVisitado = new ArrayList<Integer>();
        List<Integer> listaRotuloUtilizado = new ArrayList<Integer>();//lista com o label do caminho minimo
        for(int i = 0; i < nRotulo; i++){//preencher a lista com os rótulos não utilizados
            listaRotuloNVisitado.add(i);
        }
        
        GrafoListaAdjacencia subgrafo = new GrafoListaAdjacencia();//o subgrafo final
        GrafoListaAdjacencia subgrafoaux = new GrafoListaAdjacencia();
        for(int i = 0; i < nVertice; i++){//inicializar subgrafo que vai conter o caminho rotulo minimo
            Vertice v = new Vertice(String.valueOf(i));//add todos os vertices sem as arestas
            subgrafoaux.adicionaVertice(v);
            subgrafo.adicionaVertice(v);
        }
        
        while(countdef > 1){
            for(int k = 0; k < listaRotuloNVisitado.size(); k++){
                GrafoListaAdjacencia subgrafoaux2 = new GrafoListaAdjacencia();
                for(int i = 0; i < nVertice; i++){//inicializar subgrafo de teste rotulo minimo, é um aux
                    Vertice v = new Vertice(String.valueOf(i));
                    subgrafoaux2.adicionaVertice(v);
                }
                if(!listaRotuloUtilizado.isEmpty()){//se ja tiver rotulo minimo no caminho add eles
                    for(int i = 0; i < listaRotuloUtilizado.size(); i++){
                        for(int l = 0; l < nVertice; l++){
                            for(int p = 0; p < nVertice; p++){
                                if(matrizAdj[l][p] == listaRotuloUtilizado.get(i)){
                                        Vertice v = subgrafoaux2.getVertice(String.valueOf(l));
                                        Vertice v2 = subgrafoaux2.getVertice(String.valueOf(p));
                                        subgrafoaux2.adicionaVertice(v, v2);
                                        subgrafoaux2.adicionaVertice(v2, v);
                                }
                            }
                        }
                    }
                }
                
                for(int i = 0; i < nVertice; i++){
                    for(int j = 0; j < nVertice; j++){
                        if(matrizAdj[i][j] == listaRotuloNVisitado.get(k)){//testando componente com o rotulo 19 adcionado
                            Vertice v = subgrafoaux2.getVertice(String.valueOf(i));
                            Vertice v2 = subgrafoaux2.getVertice(String.valueOf(j));
                            subgrafoaux2.adicionaVertice(v, v2);
                            subgrafoaux2.adicionaVertice(v2, v);
                        }
                    }
                }
                countaux = compconex.CCcount(subgrafoaux2, nVertice);//contar as componentes do grafo resultante do label k
                //System.out.println("Label: " + k);
                //System.out.println("Count: " + countaux);
                //System.out.println(" ");
                if(countaux < count){
                    label = k;
                    count = countaux;
                    //System.out.println("label: " + label);
                }
            }
            //System.out.println("Label escolhido:" + label);
            countdef = count; //coundef definitivo
            //System.out.println("CountDef" + countdef);
            count = 10000;
            listaRotuloUtilizado.add(label);
            //listaRotuloNVisitado.remove(label);
        }
        
        String teste = "";
        for(int i = 0; i < listaRotuloUtilizado.size(); i++){
            teste += listaRotuloUtilizado.get(i) + " ";
        }
        System.out.println("Rotulos utilizados: " + teste);  
        
    }
}
