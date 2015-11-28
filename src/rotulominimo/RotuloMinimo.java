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
        int nVertice, nRotulo;//armazenar numero de vertices e rotulos
        Arquivo arq = new Arquivo();
        List<String> txt = new ArrayList<String>();//txt para arraylist de string
        List<int[][]> listaDeMatriz = new ArrayList<int[][]>();//String para matriz de int
        txt = arq.TxtToString();//todo o txt esta armazenado nesta variavel list string    
        
        String vertRotulo = txt.get(0);// linha do vertice e rotulo
        nVertice = Integer.parseInt(String.valueOf(vertRotulo.split(" ")[0]));
        nRotulo = Integer.parseInt(String.valueOf(vertRotulo.split(" ")[1])); 
        ManipulateMatrix manipulatematrix = new ManipulateMatrix();
        listaDeMatriz = manipulatematrix.convertMatrixInt(txt, nVertice);
       
        
        int[][] teste = new int[nVertice-1][nVertice-1];
        teste = listaDeMatriz.get(0); //cada posicao é uma matriz da instancia
        String print = "";
        for(int i = 0; i < nVertice - 1; i++){//printar a matriz
            print = "";
            for(int j = 0; j < nVertice - 1; j++){
                print = print + teste[i][j] + " ";
            }
            System.out.println(print);
        }
        
        int[][] testeespelho = manipulatematrix.invertMatrix(teste, nVertice); //espelhando a matriz
        /*Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        ArestaRotulo a1 = new ArestaRotulo(v1, v2, "18");
        System.out.println("Vertice: " + v2.getId());
        System.out.println("Aresta: " + a1.getPeso() + "  Vertice: " + a1.getVertice1().getId());*/
        GrafoListaAdjacencia grafoTeste = new GrafoListaAdjacencia();//construção do grafo a partir daqui
        for(int i = 0; i < nVertice; i++){
            Vertice v = new Vertice(String.valueOf(i));
            grafoTeste.adicionaVertice(v);
        }
        
        List<Vertice> listaVertice2 = new ArrayList<Vertice>();//para testar vertices adjcentes
        
        for(int i = 0; i < nVertice; i++){
            for(int j = 0; j < nVertice; j++){
                if(testeespelho[i][j] != -1 & testeespelho[i][j] != nRotulo){//diferente de -1 e 20, tem aresta
                   Vertice v = grafoTeste.getVertice(String.valueOf(i));
                   Vertice vAdj = grafoTeste.getVertice(String.valueOf(j));
                   grafoTeste.adicionaVertice(v, vAdj);//adiciona adjacencia
                }
            }
        }
        
        Vertice v = grafoTeste.getVertice(String.valueOf(1));// ver adj de vertice 0
        listaVertice2 = grafoTeste.getVerticesAdjacentes(v);
        for(int i = 0; i < listaVertice2.size(); i++){
           Vertice v2 = listaVertice2.get(i);
           System.out.println("VerticesAdj de v" + v.getId() + "  " + v2.getId());
        }
           
    }
    
}
