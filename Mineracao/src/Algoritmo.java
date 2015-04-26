
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
    int numTrasacoes;
    LinkedList<Linha> dadosLinha;
    
    /**
     * Metodo para pegar as linhas do arquivo e futuramente colocar os dados nas nossas estruturaas de dados que vamos usar
     * por enquanto está sendo usada para testes. 
     * @param linhasArquivo lista com todas as linhas contida no arquivo
     */
    public void lerLinhas(LinkedList<String> linhasArquivo){
        dadosLinha =  new LinkedList<>();
       
        qntAtributos= 0;
        numTrasacoes = 0;
 
     
        //lendo arquivo
        this.linha=linhasArquivo;
        System.out.println("Lendo arquivo");
        for (String linha1 : linha) {
            String temp[];
            Linha c = new Linha();
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
                        String d = Integer.toString(cont);
                        c.add("C:"+d+":"+p);
                        cont++;
                    }
                    dadosLinha.add(c);
                    numTrasacoes++;
                }
            }    
        }
        //teste
        /*
        System.out.println("************************************************************************");
        System.out.println("****************** Valores dos atributos armazenados na lista *********************");
        for(int k=0; k<dadosLinha.size(); k++){
            System.out.println(" ");
            
            System.out.println("Linha: "+k);
            System.out.println(" qnt de elementos na linha"+dadosLinha.get(k).size() );
            for(int z=0; z<11; z++){
                System.out.print("Pos: "+z+" Valor: "+dadosLinha.get(k).get(z)+" ");
                
            }
        }
      */
    }
    
    public LinkedList<ItemSet>  l1(double suporteMin){
       ItemSet itens = new ItemSet();
        
        for(int i=0; i<dadosLinha.size(); i++){
            System.out.println(" ");
            System.out.println("Linha: "+i);
            
            for(int j=0; j<dadosLinha.get(i).size(); j++){
               
                System.out.print(" pos: "+j);
                if(itens.getLista().isEmpty()){
                    
                    System.out.print(" elemennto add:"+dadosLinha.get(i).get(j));
                    itens.add(dadosLinha.get(i).get(j)); 
                }else if(!itens.getLista().contains(dadosLinha.get(i).get(j))){
                    System.out.print(" elemennto add:"+dadosLinha.get(i).get(j));
                    itens.add(dadosLinha.get(i).get(j));
                }
                
            }   
        }
        
        //calcular suporte
        System.out.println("********Calculando suporte******");
        LinkedList<ItemSet> itens2 = new LinkedList<> ();
       
        double sup;
        for(int z=0; z<itens.size(); z++){
            ItemSet var = new ItemSet();
            sup=0;
            int cont=0;
            for(int i=0; i<dadosLinha.size(); i++){
                if(dadosLinha.get(i).getLista().contains(itens.getElemento(z))){
                    cont++;
                }
                   
            }
            sup = (double)cont/numTrasacoes;
            System.out.println("Elemento: "+itens.getElemento(z)+" Quantidade:"+cont+" Suporte:"+sup);
            if(sup>=suporteMin){
                var.add(itens.getElemento(z));
                itens2.add(var);
            }
        }
        
        System.out.println("**************elemento com suporte acima do minimo:****************8888");
        for(int i=0; i<itens2.size();i++){
            for(int j=0; j<itens2.get(i).size(); j++){
              System.out.println(itens2.get(i).getElemento(j));  
            }
            
        }
        
        return itens2;
    }
    
    //gerar todos as combinações e todos os li
    public void ln(double supMin){
        LinkedList<ItemSet> itens = new LinkedList<> ();
        itens = l1(supMin);
        
        //combinações
        for(int i=0; i<=itens.size(); i++){
            
        }
        
    }
    
    public LinkedList<ItemSet>  combinar(ItemSet l, int numComb){
       
        LinkedList<ItemSet> itens = new LinkedList<> ();
        ItemSet it = new ItemSet();
        
        //quantidade de itens menor que o tipo de combinação: ex 2 itens para uma combinação de 3.
        if(l.size()<numComb){
            
            return itens;//retorna lista vazia
        }else{
           //combinações
            
            for(int i=0; i<=l.size(); i++){
                for(int k=i+1; k<numComb; k++){
                    if(itens.isEmpty()){
                        it = new ItemSet();
                        it.add(null);
                        itens.add(l);
                    }else{
                        
                    }
                }

            }
        return itens;  
        }
        
    }
    
}


