
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
public class Algoritmo {
    
    LinkedList<String> linha =  new LinkedList<>();
    int qntAtributos;
    
    /**
     * Metodo para pegar as linhas do arquivo e futuramente colocar os dados nas nossas estruturaas de dados que vamos usar
     * por enquanto está sendo usada para testes. 
     * @param linhasArquivo lista com todas as linhas contida no arquivo
     */
    public void lerLinhas(LinkedList<String> linhasArquivo){
        LinkedList<Linha> dadosLinha =  new LinkedList<>();
        Linha c = new Linha();
        qntAtributos= 0;
        dadosLinha.add(c);
     
        //lendo arquivo
        this.linha=linhasArquivo;
        System.out.println("Lendo arquivo");
        for (String linha1 : linha) {
            String temp[];
            if(linha1!=null){// a ultima posição na lista é null 
                if(linha1.startsWith("@relation")){
                    System.out.println("Nome da relação: "+linha1);
                }else if(linha1.startsWith("@attribute")){
                    System.out.println("Linha atributo: "+linha1);
                    temp=linha1.split(" ");
                    qntAtributos++;
                    System.out.println("Nome do atributo: "+temp[1]+" Valor: "+temp[2]);
                }else if(linha1.startsWith("@data")){
                    System.out.println("Data: "+linha1);
                }else if(!linha1.isEmpty()){
                    //System.out.println("dado: "+linha1);
                    temp=linha1.split(",");
                    int cont = 0;
                    for(String p:temp){
                        c.add(p, cont);
                        cont++;
                    }
                    dadosLinha.add(c);
                }
            }    
        }
        //teste
        System.out.println("************************************************************************");
        System.out.println("****************** Valores dos atributos armazenados na lista *********************");
        for(int k=0; k<dadosLinha.size(); k++){
            System.out.println(" ");
            System.out.println("Linha: "+k);
            for(int z=0; z<11; z++){
                System.out.print("Pos: "+z+" Valor: "+dadosLinha.get(k).get(z)+" ");
                
            }
        }
    }
    
}
