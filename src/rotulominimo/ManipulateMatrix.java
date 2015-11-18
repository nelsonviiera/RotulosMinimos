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
    public int[][] invertMatrix(){
        int[][] invertedMatrix = null;
        return invertedMatrix;
    }
}
