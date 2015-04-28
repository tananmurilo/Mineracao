
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
    public String textoFinal="";
    
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
        //System.out.println("********Calculando suporte******");
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
    
    public ItemSet verItems(LinkedList<ItemSet> ListaItens){
        ItemSet itenParaCombinacao = new ItemSet();
        for(int i=0; i<ListaItens.size(); i++){
            for(int j=0; j<ListaItens.get(i).size(); j++){
                //textoFinal = textoFinal+ListaItens.get(i).getElemento(j)+" Quantidade: "+ListaItens.get(i).getQuantidade()+" suporte:"+ListaItens.get(i).getSuporte()+"\n";
                if(itenParaCombinacao.size()==0){
                    itenParaCombinacao.add(ListaItens.get(i).getElemento(j));
                    
                }else if(!itenParaCombinacao.getLista().contains(ListaItens.get(i).getElemento(j))){
                    itenParaCombinacao.add(ListaItens.get(i).getElemento(j));
                }
            }
            
        }
        return itenParaCombinacao;
    }
    
    //gerar todos as combinações e todos os li
    public void ln(double supMin){
        LinkedList<ItemSet> ListaItens = new LinkedList<> ();
        ItemSet itenParaCombinacao = new ItemSet();
        ListaItens = l1(supMin);
        int combinacaoAtual=2;
        
        //textoFinal = "L1:\n";
        
            //separar valores para gerar combinações
        itenParaCombinacao = verItems(ListaItens);

        LinkedList<ItemSet> retorno = new LinkedList<>();
         //trabalhar com as combinações recebidas
            retorno = combinar(itenParaCombinacao,combinacaoAtual);
         if(retorno!=null){ 
            //gerar todas as combinações e calcular os suportes
            do{

                /*
                textoFinal = textoFinal+"Combinações para:"+combinacaoAtual+"\n";
                //System.out.println("Imprimindo lista final");
                 for(int i=0; i<retorno.size(); i++){
                   // System.out.println("Combinação "+i);
                    textoFinal = textoFinal+"{";
                    for(int j=0; j<retorno.get(i).size(); j++){
                        //System.out.println(retorno.get(i).getElemento(j));
                        textoFinal = textoFinal+" "+retorno.get(i).getElemento(j)+" ";
                    }
                    textoFinal = textoFinal+"}\n";
                }
                */

                 //calcular sup 
                  LinkedList<ItemSet> itens2 = new LinkedList<> ();

                    double sup;
                    int cont2=0;
                    for(int z=0; z<retorno.size(); z++){
                        ItemSet var = new ItemSet();
                        sup=0;

                        int contQnt=0;
                        //varer os dados (bd)
                        for(int i=0; i<dadosLinha.size(); i++){
                            int contL=0;//conquantas 
                            for(int p = 0; p<retorno.get(z).size();p++){
                                if(dadosLinha.get(i).getLista().contains(retorno.get(z).getElemento(p))){
                                    contL++;//contar quantas vezes apareceu o elemento da linha de z na linha de i
                                    if(contL==combinacaoAtual){
                                        contQnt++;//contar quantas vezes apareceu a combinaçõ de itens
                                    }
                                }  
                            }


                        }
                        sup = (double)contQnt/numTrasacoes;
                       // System.out.println("Elemento: "+itens.getElemento(z)+" Quantidade:"+cont+" Suporte:"+sup);
                        if(sup>=supMin){
                            var = retorno.get(z);
                            itens2.add(var);
                            itens2.getLast().setQuantidade(contQnt);
                            itens2.getLast().setSuporte(sup);

                        }
                    }

                    textoFinal = textoFinal+"Combinações acima do suporte para:"+combinacaoAtual+"\n";
                //System.out.println("Imprimindo lista final");
                    //teste
                 for(int i=0; i<itens2.size(); i++){
                    if(itens2.get(i).getSuporte()>supMin){
                        
                        calcularConfianca(itens2.get(i));
                    }
                }

                //separar valores para gerar combinações
                 itenParaCombinacao = verItems((LinkedList<ItemSet>)itens2.clone());
                 combinacaoAtual++;
                 retorno = combinar(itenParaCombinacao,combinacaoAtual);
                 System.out.println("preso no while");
            }while(retorno!=null);
       } else{//if
             textoFinal="não há nada com suporte acima de: "+supMin;
         }
          System.out.println("finalizou o while");
    }
    
    public void calcularConfianca(ItemSet itens2){
            
            if(itens2.size()==2){
                if(!itens2.getElemento(0).equals(itens2.getElemento(1))){
                    
                    ItemSet temp = new ItemSet();
                    //temp.add(itens2.getElemento(0));
                    //double conf = (double)itens2.getQuantidade()/contarElementos(temp);
                    //regra'
                    //textoFinal = textoFinal+"SE ("+itens2.getElemento(0)+") ENTÃO ("+itens2.getElemento(1)+")"+" Sup:"+itens2.getSuporte()+" Conf:"+conf+"\n";
                    temp = new ItemSet();
                    temp.add(itens2.getElemento(1));
                    double conf = (double)itens2.getQuantidade()/contarElementos(temp);
                    String valor[];
                    valor=itens2.getElemento(1).split(":");
                    String n1="";
                    for(int k=0; k<atributos.size(); k++){
                        if(valor[1].equals(Integer.toString(k))){
                            System.out.println("transformando...");
                            n1=atributos.get(k);
                        }
                    }
                    String valor2[];
                    valor2=itens2.getElemento(0).split(":");
                    String n2="";
                    for(int k=0; k<atributos.size(); k++){
                        if(valor2[1].equals(Integer.toString(k))){
                            System.out.println("transformando...");
                            n2=atributos.get(k);
                        }
                    }
                    //regra'
                    
                    textoFinal = textoFinal+"SE "+n1+"("+valor[2]+") ENTÃO "+n2+"("+valor2[2]+")"+" Sup:"+itens2.getSuporte()+" Conf:"+conf+"\n";
                }   
            }else if(itens2.size()>2){ 
                    //System.out.println("Combinação "+i);
               textoFinal = textoFinal+"{";
               for(int j=0; j<itens2.size(); j++){


                   textoFinal = textoFinal+" "+itens2.getElemento(j);
               }
               textoFinal = textoFinal+"}";
               textoFinal = textoFinal+" "+" Suporte: "+itens2.getSuporte()+" Quantidade: "+itens2.getQuantidade()+"\n";

            }
                    
          

               
    }
    
    public int contarElementos(ItemSet iten){
        
        int contQnt=0;
        for(int z=0; z<iten.size(); z++){
            
            //varer os dados (bd)
            for(int i=0; i<dadosLinha.size(); i++){
                int contL=0;//conquantas 
                for(int p = 0; p<iten.size();p++){
                    if(dadosLinha.get(i).getLista().contains(iten.getElemento(p))){
                        contL++;//contar quantas vezes apareceu o elemento da linha de z na linha de i
                        if(contL==iten.size()){
                            contQnt++;//contar quantas vezes apareceu a combinaçõ de itens
                        }
                    }  
                }


            }
            
        }
        return contQnt;
    }
    
    public LinkedList<ItemSet>  combinar(ItemSet l, int numComb){
       System.out.println("gerando combinações");
        LinkedList<ItemSet> itens = new LinkedList<> ();
        
        LinkedList<ItemSet> temp = new LinkedList<> ();
        ItemSet it = new ItemSet();
        int ponteiro2 = 0;
        //quantidade de itens menor que o tipo de combinação: ex 2 itens para uma combinação de 3.
        if(l.size()<numComb){
            
            return null;//retorna vazio
        }else{
           //combinações
            int cont = numComb;
            //System.out.println("Fazendo combinações");
            //temp = new LinkedList<> ();
            while(cont>0){
                //System.out.println("Cont :"+cont);
                
                if(itens.isEmpty()){
                    //System.out.println("lista vazia colocando itens");
                    for(int i=0; i<l.size(); i++){
                        it = new ItemSet();
                       // System.out.println(l.getElemento(i));
                        it.add(l.getElemento(i));
                        itens.add(it);
                    } 
                    //teste na adição na lista funcionou
                   
                }else{
                    for(int j=ponteiro2; j<l.size(); j++){
                        for(int i=0; i<itens.size(); i++){
                       
                          // System.out.println("Lendo posIntem: "+i+" L pos: "+j);
                           if(!temp.isEmpty()){
                              // itens.get(i).getLista().add(null);
                               it= new ItemSet() ;
                               it.itens=(LinkedList<String>)itens.get(i).getLista().clone();
                               //teste
                              
                               //add elemento no final da lista 
                               it.getLista().add(l.getElemento(j));
                              
                               //if(!temp.contains(it)){
                                   temp.add(it);
                                   //System.out.println("temp não vazio");
                                   //System.out.println("add objeto no temp");
                                    
                               //}
                               /*
                               System.out.println("valores armazenados no temp");
                               for(int h=0; h<temp.size(); h++){
                                        for(int c=0; c<temp.get(h).size(); c++){
                                            System.out.println("linha:"+h+"valor"+c+" : "+temp.get(h).getElemento(c));
                                        }
                                        
                                    }
                                */       
                           }else if(temp.isEmpty()){
                               //System.out.println("temp vazio");
                               it = new ItemSet();
                               
                               it.itens=(LinkedList<String>)itens.get(i).getLista().clone();
                               it.getLista().add(l.getElemento(j));
                               temp.add(it);
                               //System.out.println("add objeto no temp");
                               
                           }
                           
                       }
                    }
            
                    itens = new LinkedList<> ();
                    itens = (LinkedList<ItemSet>)temp.clone();//substituir a lista de itens por uma nova
                    temp.clear();
                   // System.out.println("tamanho da lista itens depois da rodada"+itens.size());
                }
                cont--;
                ponteiro2++;
            }
              
            
        return itens;  
        }
        
    }
    
}


