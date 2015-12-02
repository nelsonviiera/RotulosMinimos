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
public class ManipulateMatrix {
    public ManipulateMatrix(){
        
    }
    /*
    * retorna uma lista de matriz de inteiros
    */
    public List convertMatrixInt(List<String> txt, int nVertice){
        List<int[][]> listaDeMatriz = new ArrayList<int[][]>();
        
         //passar de string para lista de matriz de inteiro(cada posição uma matriz)////
        //int[][] auxMatriz = new int[nVertice-1][nVertice-1];
        int posicaoListaMatriz = 0;
        String linhaAtual;//receber a linha atual do txt
        int linhaMatriz = 0;
        
        int cont = 1;
        while(cont < txt.size()){
           
            int[][] auxMatriz = new int[nVertice-1][nVertice-1];
            for(int i = 0; i < (nVertice - 1); i++){
                linhaAtual = txt.get(cont);
                String[] split = linhaAtual.split(" ");
                for(int j = 0; j < split.length; j++){
                    auxMatriz[i][j] = Integer.parseInt(split[j]);
                }
                cont++;//cont++ pq cada linha da matriz é uma linha percorrida no arquivo
            }
            listaDeMatriz.add(auxMatriz);
            cont++;
        }
        return listaDeMatriz;
    }
    
    /*
    *Inverte as colunas de uma matriz que esta espelhada
    */
    public int[][] invertMatrix(int[][] matriz, int nVertice){
        String print;
        int[][] invertedMatrix = new int[nVertice][nVertice];
        for(int i = 0; i < nVertice; i++){// os dois fors percorrem os lugares onde serão 0
            for(int j = 0; j <= i; j++){//ou seja abaixo da diagonal principal e a propria diagonal
                invertedMatrix[i][j] = -1;
            }
        }
        
        int lin = 0;//controlar as linhas e colunas da matriz espelhada
        int colun = 0;
        int auxcolun = 1;
        int auxverticeatual = nVertice - 2;
        
        //System.out.println(" ");
        for(int i = 0; i < nVertice - 1; i++){
            colun = auxcolun;
            for(int j = auxverticeatual; j >= 0; j--){//ultima coluna é nvertice -2
                invertedMatrix[lin][colun] = matriz[i][j];
                colun++;
            }
            lin++;
            auxcolun++;
            auxverticeatual--;
        }
        
      
        //System.out.println(" ");
    
        /*for(int i = 0; i < nVertice; i++){
            print = "";
            for(int j = 0; j < nVertice; j++){
                print = print + invertedMatrix[i][j] + " ";
            }
            System.out.println(print);
        }*/
        return invertedMatrix;
    }
}
