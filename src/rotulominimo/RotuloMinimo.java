/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotulominimo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Documentois
 */
public class RotuloMinimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        int contaNumRotulo = 0;//guardar numero total de rotulos utilizados em todas as instancias
        int nVertice, nRotulo;//armazenar numero de vertices e rotulos
        Arquivo arq = new Arquivo();
        List<String> txt = new ArrayList<String>();//txt para arraylist de string
        List<int[][]> listaDeMatriz = new ArrayList<int[][]>();//String para matriz de int
        txt = arq.TxtToString();//todo o txt esta armazenado nesta variavel list string    
        long time1 = System.currentTimeMillis();
        
        String vertRotulo = txt.get(0);// linha do vertice e rotulo
        nVertice = Integer.parseInt(String.valueOf(vertRotulo.split(" ")[0]));
        nRotulo = Integer.parseInt(String.valueOf(vertRotulo.split(" ")[1])); 
        ManipulateMatrix manipulatematrix = new ManipulateMatrix();
        listaDeMatriz = manipulatematrix.convertMatrixInt(txt, nVertice);
        
        for(int p = 0; p < listaDeMatriz.size();p++){
            int[][] teste = new int[nVertice-1][nVertice-1];
            teste = listaDeMatriz.get(p); //cada posicao é uma matriz da instancia
            String print = "";
        
            int[][] testeespelho = manipulatematrix.invertMatrix(teste, nVertice); //espelhando a matriz, atriz certa
        
            GrafoListaAdjacencia grafoTeste = new GrafoListaAdjacencia();//construção do grafo a partir daqui
            for(int i = 0; i < nVertice; i++){//adicionar somente os vertices sem as arestas
                Vertice v = new Vertice(String.valueOf(i));//instancia cada vertice do grafo 
                grafoTeste.adicionaVertice(v);//adiciona ele no grafo, em arestas
            }
        
            for(int i = 0; i < nVertice; i++){//adicionar adjacencia
                for(int j = 0; j < nVertice; j++){
                    if(testeespelho[i][j] != -1 & testeespelho[i][j] != nRotulo){//diferente de -1 e 20, tem aresta
                        Vertice v = grafoTeste.getVertice(String.valueOf(i));
                        Vertice vAdj = grafoTeste.getVertice(String.valueOf(j));
                        grafoTeste.adicionaVertice(v, vAdj);//adiciona adjacencia
                        grafoTeste.adicionaVertice(vAdj, v);// adiciona adj na duas vias, é não direcionado
                    }
                }
            }//grafo montado
            
        
            ComponenteConexa compconex = new ComponenteConexa();//testando contagem de componenete conexa;
            int count = compconex.CCcount(grafoTeste, nVertice);
            int contaRotuloDaInstancia = 0;
            if(count == 1){
                System.out.println("Matriz: " + p);
                MVCA mvca = new MVCA();
                contaRotuloDaInstancia = mvca.doMVCA(grafoTeste, nVertice, testeespelho,nRotulo);//testesespelho matriz certa para percorrer
                System.out.println(" ");
            }
            contaNumRotulo += contaRotuloDaInstancia; //contando numero total de label usados
        }///////////   
        long time2 = System.currentTimeMillis();
        System.out.println("milis: " + (time2 - time1));
        System.out.println("Numero de Rótulos totais: " + contaNumRotulo);
    }
    
}
