
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author murilo
 */



public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        System.out.println("teste");
       
        
        Interface a = new Interface();
        a.setVisible(true);
        Arquivo arq = new Arquivo();
        
        //testes 
         //LinkedList<String> coluna =  new LinkedList<>();
        LinkedList<Linha> dadosLinha =  new LinkedList<>();
        Linha c = new Linha();
        c.add("oi", 0);
        c.add("sou", 1);
        c.add("eu", 2);
        dadosLinha.add(c);
        c= new Linha();
        c.add("teste", 0);
        c.add("deu", 1);
        c.add("certo", 2);
        dadosLinha.add(c);
        System.out.println("Numero de linhas: "+dadosLinha.size());
        System.out.println("Numero de colunas: "+c.size());
        
        for(int k=0; k<dadosLinha.size(); k++){
            System.out.println(" ");
            System.out.println("Linha "+k);
            for(int z=0; z<3; z++){
                System.out.print("Pos "+z+" Valor "+dadosLinha.get(k).get(z)+" ");
                
            }
        }
       
    }
    
    
}
