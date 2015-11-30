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
    
    public void doMVCA(GrafoListaAdjacencia grafo, int nVertice, int[][] matrizAdj){
        ComponenteConexa compconex = new ComponenteConexa();
        int count;//contar componentes
        List<Integer> listaRotuloNVisitado = new ArrayList<Integer>();
        for(int i = 0; i < nVertice; i++){//preencher a lista com os rótulos não utilizados
            listaRotuloNVisitado.add(i);
        }
        
        GrafoListaAdjacencia subgrafo = new GrafoListaAdjacencia();
        for(int i = 0; i < nVertice; i++){//inicializar subgrafo que vai conter o caminho rotulo minimo
            Vertice v = new Vertice(String.valueOf(i));//add todos os vertices sem as arestas
            subgrafo.adicionaVertice(v);
        }
        
        for(int i = 0; i < nVertice; i++){
            for(int j = 0; j < nVertice; j++){
                if(matrizAdj[i][j] == 19){//testando componente com o rotulo 19 adcionado
                    Vertice v = subgrafo.getVertice(String.valueOf(i));
                    Vertice v2 = subgrafo.getVertice(String.valueOf(j));
                    subgrafo.adicionaVertice(v, v2);
                    subgrafo.adicionaVertice(v2, v);
                }
            }
        }
        
        count = compconex.CCcount(subgrafo, nVertice);
        System.out.println("subgrafo teste: " + count);
    }
}
