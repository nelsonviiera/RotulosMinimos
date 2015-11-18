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
        
        String vertRotulo = txt.get(0);
        nVertice = Integer.parseInt(String.valueOf(vertRotulo.split(" ")[0]));
        nRotulo = Integer.parseInt(String.valueOf(vertRotulo.split(" ")[1])); 
        ManipulateMatrix manipulatematrix = new ManipulateMatrix();
        listaDeMatriz = manipulatematrix.convertMatrixInt(txt, nVertice);
       
        int[][] teste = new int[nVertice-1][nVertice-1];
        teste = listaDeMatriz.get(9); //cada posicao é uma matriz da instancia
        String print = "";
        for(int i = 0; i < 19; i++){
            print = "";
            for(int j = 0; j < 19; j++){
                print = print + teste[i][j] + " ";
            }
            System.out.println(print);
        }
        
        
        
       
    }
    
}
