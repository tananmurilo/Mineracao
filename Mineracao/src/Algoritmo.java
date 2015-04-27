
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
    LinkedList<String> atributos =  new LinkedList<>();
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
                    atributos.add(temp[1]);
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
        for(String j:atributos){
            System.out.println(j);
        }
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
    /**
     * 
     * @param suporteMin suporte minimo
     * @return lista com um conjunto de valores de suporte maior que o minimo
     */
    public LinkedList<ItemSet>  l1(double suporteMin){
       ItemSet itens = new ItemSet();
        
        for(int i=0; i<dadosLinha.size(); i++){
            //System.out.println(" ");
            //System.out.println("Linha: "+i);
            
            for(int j=0; j<dadosLinha.get(i).size(); j++){
               
                //System.out.print(" pos: "+j);
                if(itens.getLista().isEmpty()){
                    
                   // System.out.print(" elemennto add:"+dadosLinha.get(i).get(j));
                    itens.add(dadosLinha.get(i).get(j)); 
                }else if(!itens.getLista().contains(dadosLinha.get(i).get(j))){
                   // System.out.print(" elemennto add:"+dadosLinha.get(i).get(j));
                    itens.add(dadosLinha.get(i).get(j));
                }
                
            }   
        }
        
        //calcular suporte
        System.out.println("********Calculando suporte******");
        LinkedList<ItemSet> itens2 = new LinkedList<> ();
       
        double sup;
        int cont2=0;
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
           // System.out.println("Elemento: "+itens.getElemento(z)+" Quantidade:"+cont+" Suporte:"+sup);
            if(sup>=suporteMin){
                var.add(itens.getElemento(z));
                itens2.add(var);
                itens2.get(cont2).setQuantidade(cont);
                itens2.get(cont2).setSuporte(sup);
                cont2++;
            }
        }
        /*
        System.out.println("**************elemento com suporte acima do minimo:****************8888");
        for(int i=0; i<itens2.size();i++){
            for(int j=0; j<itens2.get(i).size(); j++){
              System.out.print(itens2.get(i).getElemento(j));  
              System.out.print(" qnt: "+itens2.get(i).getQuantidade()); 
              System.out.print(" sup: "+itens2.get(i).getSuporte());
                System.out.println(" ");
            }
            
        }
        */
        
        return itens2;
    }
    
    //gerar todos as combinações e todos os li
    public void ln(double supMin){
        LinkedList<ItemSet> ListaItens = new LinkedList<> ();
        ItemSet itenParaCombinacao = new ItemSet();
        ListaItens = l1(supMin);
        
        //separar valores para gerar combinações
        for(int i=0; i<ListaItens.size(); i++){
            for(int j=0; j<ListaItens.get(i).size(); j++){
                if(itenParaCombinacao.size()==0){
                    itenParaCombinacao.add(ListaItens.get(i).getElemento(j));
                }else if(!itenParaCombinacao.getLista().contains(ListaItens.get(i).getElemento(j))){
                    itenParaCombinacao.add(ListaItens.get(i).getElemento(j));
                }
            }
            
        }
        LinkedList<ItemSet> retorno = new LinkedList<>();
        retorno = combinar(itenParaCombinacao,2);
        
        System.out.println("Imprimindo lista final");
         for(int i=0; i<retorno.size(); i++){
            System.out.println("Combinação "+i);
            for(int j=0; j<retorno.get(i).size(); j++){
                System.out.println(retorno.get(i).getElemento(j));
            }
            
        }
        
    }
    
    public LinkedList<ItemSet>  combinar(ItemSet l, int numComb){
       
        LinkedList<ItemSet> itens = new LinkedList<> ();
        LinkedList<ItemSet> temp = new LinkedList<> ();
        ItemSet it = new ItemSet();
        
        //quantidade de itens menor que o tipo de combinação: ex 2 itens para uma combinação de 3.
        if(l.size()<numComb){
            
            return itens;//retorna lista vazia
        }else{
           //combinações
            int cont = numComb;
            System.out.println("Fazendo combinações");
            while(cont>0){
                System.out.println("Cont :"+cont);
                temp = new LinkedList<> ();
                if(itens.isEmpty()){
                    System.out.println("lista vazia colocando itens");
                    for(int i=0; i<l.size(); i++){
                        it = new ItemSet();
                        System.out.println(l.getElemento(i));
                        it.add(l.getElemento(i));
                        itens.add(it);
                    } 
                    //teste na adição na lista funcionou
                   
                }else{
                    for(int i=0; i<itens.size(); i++){
                       for(int j=i+1; j<l.size(); j++){
                           if((j>i)&&(!temp.isEmpty())){
                               
                               it= new ItemSet() ;
                               it=itens.get(i);
                               //teste
                              
                               //add elemento no final da lista 
                               it.getLista().add(l.getElemento(j));
                              
                               if(!temp.contains(it)){
                                   temp.add(it);
                                   System.out.println("temp não vazio");
                                   System.out.println("add objeto no temp");
                                    for(int h=0; h<temp.size(); h++){
                                        for(int c=0; c<temp.get(h).size(); c++){
                                            System.out.println("linha:"+h+"valor"+c+" : "+temp.get(h).getElemento(c));
                                        }
                                        
                                    }
                               }
                           }else if((j>i)&&(temp.isEmpty())){
                               System.out.println("temp vazio");
                               it = new ItemSet();
                               it=itens.get(i);
                               it.getLista().add(l.getElemento(j));
                               temp.add(it);
                               System.out.println("add objeto no temp");
                               
                               for(int h=0; h<temp.get(0).size(); h++){
                                   System.out.println("valor:"+temp.get(0).getElemento(h));
                               }
                           }
                           
                       }
                    }
                    itens = temp;//substituir a lista de itens por uma nova
                }
                cont--;
            }
              
          
        return itens;  
        }
        
    }
    
}


