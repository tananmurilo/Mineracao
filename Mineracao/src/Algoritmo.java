
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
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
    
     int idAtributoClasse;
     int idAtributoRelevante1;
     int idAtributoRelevante2;
    
    
   
    
    /**
     * Metodo para pegar as linhas do arquivo e futuramente colocar os dados nas nossas estruturaas de dados que vamos usar
     * por enquanto está sendo usada para testes. 
     * @param linhasArquivo lista com todas as linhas contida no arquivo
     */
    public void lerLinhas(LinkedList<String> linhasArquivo){
        dadosLinha =  new LinkedList<>();
        atributos =  new LinkedList<>();
       
        qntAtributos= 0;
        numTrasacoes = 0;
 
     
        //lendo arquivo
        this.linha=linhasArquivo;
        System.out.println("Lendo arquivo");
        for (String linha1 : linha) {
            String temp[];
            Linha c = new Linha();
            if(linha1!=null){// a ultima posição na lista é null 
                if(linha1.startsWith("@relation")||linha1.startsWith("@RELATION")){
                    System.out.println("Nome da relação: "+linha1);
                }else if(linha1.startsWith("@attribute")||linha1.startsWith("@ATTRIBUTE")){
                    System.out.println("Linha atributo: "+linha1);
                    temp=linha1.split(" ");
                    qntAtributos++;
                    System.out.println("Nome do atributo: "+temp[1]);
                    atributos.add(temp[1]);
                }else if(linha1.startsWith("@data")||linha1.startsWith("@DATA")){
                    System.out.println("Data: "+linha1);
                }else if(linha1.startsWith("%")){
                    //comentario faz nada
                }else if(!linha1.isEmpty()){
                    //System.out.println("dado: "+linha1);
                    temp=linha1.split(",");
                    int cont = 0;
                    
                    for(String p:temp){
                        String d = Integer.toString(cont);
                        c.add(p);//identificar a coluna q pertence esse dado.
                        cont++;
                    }
                    dadosLinha.add(c);
                    numTrasacoes++;
                }
            }    
        }
        
        //teste
        
        for(String j:atributos){
            System.out.println(j);
        }
        System.out.println("************************************************************************");
        System.out.println("****************** Valores dos atributos armazenados na lista *********************");
        for(int k=0; k<dadosLinha.size(); k++){
            System.out.println(" ");
            
            System.out.println("Linha: "+k);
            System.out.println(" qnt de elementos na linha"+dadosLinha.get(k).size() );
            for(int z=0; z<qntAtributos; z++){
                System.out.print("Pos: "+z+" Valor: "+dadosLinha.get(k).get(z)+" ");
                
            }
        }
      
    }
    //salvar o id da classe a ser classificada
    public void salvarIdAtributos(String principal){
        
         for(int i=0; i<atributos.size(); i++){
            if(atributos.get(i).equals(principal)){
                this.idAtributoClasse= i ;
            }
         }
        
         
            
    }
    
    public String start(LinkedList<String> entrada, int n){
        
        LinkedList<VetorDistancia> vetor = new LinkedList<>();
        
        
        for(int i=0; i<dadosLinha.size(); i++){
           // Double valorDouble = Double.parseDouble(valor);
             LinkedList<String> p1 =  new LinkedList<>();
             LinkedList<String> p2 =  new LinkedList<>();
             
             //colocar os dados da base a ser calculado  sem uma lista
             for(int j=0; j<dadosLinha.get(i).size();j++){
                 if(j!=idAtributoClasse){
                     p1.add(dadosLinha.get(i).get(j));
                 }
             }
              //colocar os dados de entrada a ser calculado  sem uma lista
             for(int j=0; j<entrada.size();j++){
                 if(j!=idAtributoClasse){
                     p2.add(entrada.get(j));
                 }
             }
             
             
           /*
            double x1 =Double.parseDouble(entrada.get(idAtributoRelevante1)); 
            double x2 =Double.parseDouble(this.dadosLinha.get(i).get(idAtributoRelevante1));
            double y1 = 0;
            double y2 = 0;
            
            if(idAtributoRelevante2 == -1){//caso seja -1 quer dizer que só tem um atributo escolhido para fazer o calculo
                y1 = 0;
                y2 = 0;
            }else{
                y1 =Double.parseDouble(entrada.get(idAtributoRelevante2)); 
                y2 =Double.parseDouble(this.dadosLinha.get(i).get(idAtributoRelevante2)); 
            }
            double resDist = calcularDistancia(x1, y1, x2, y2);
            */
            
            //adicionar informações das distancias de cada item na lista
            double resDist = calcularDistancia(p1,p2);

            VetorDistancia v = new VetorDistancia(); 
            v.setId(i);
            v.setDist(resDist);
            vetor.add(v); //vetor com as distancias
            
            p1.clear();
            p2.clear();
            
        }
        
        //teste no vetor distancia
          System.out.println(" Teste do calculo de distancia vetor desordenado");
         for(int k=0; k<vetor.size(); k++){
            System.out.println("elemento: "+k);
            System.out.println("distancia "+vetor.get(k).getDist() );
          
        }
         //ordenar
          // Em ordem crescente  
        Collections.sort (vetor, new Comparator() {  
            public int compare(Object o1, Object o2) {  
                VetorDistancia p1 = (VetorDistancia) o1;  
                VetorDistancia p2 = (VetorDistancia) o2;  
                return p1.getDist() < p2.getDist() ? -1 : (p1.getDist() > p2.getDist() ? +1 : 0);  
            }  
        });  
        
          //teste no vetor distancia ordenado 
         System.out.println(" Teste vetor distancia ordenado");
         for(int k=0; k<vetor.size(); k++){
            System.out.println("id do elemento: "+vetor.get(k).getId());
            System.out.println("distancia "+vetor.get(k).getDist() );
          
        }
         
         //n
        if(n==1){
            return dadosLinha.get(vetor.get(0).getId()).get(idAtributoClasse); //retorna a classe que pertence ao elemento mais proximo
        }else if(n>1){
             
           
            
            if(n>vetor.size()){
                n=vetor.size();//caso n seja maior do que a qutidade de elementos ele é setado com o valor maximo de elementos
            }
                String atributoMaior="";
                int contador = 0;
                for(int i=0; i<n; i++){
                    if(i==0){
                       atributoMaior =  dadosLinha.get(vetor.get(i).getId()).get(idAtributoClasse);
                       for(int j=0; j<n; j++){//contar quantidade de atributos
                           if(atributoMaior.equals(dadosLinha.get(vetor.get(j).getId()).get(idAtributoClasse))){
                           contador++;
                       }
                       }
                       
                    }else{
                        String atual = dadosLinha.get(vetor.get(i).getId()).get(idAtributoClasse);
                        int contAtual = 0;
                        if(!atual.equals(atributoMaior)){//se for diferente do maior
                           for(int j=0; j<n; j++){//contar quantidade de atributos
                                if(atual.equals(dadosLinha.get(vetor.get(j).getId()).get(idAtributoClasse))){
                                    contAtual++;
                                } 
                           }
                           if(contAtual>contador){
                               atributoMaior = atual;
                               contador= contAtual;
                           }
                        
                       }
                    }
                  
                }
                
            
            
           return atributoMaior;  
        }else{
            return "Indefinido";
        }
        
       
    }
    //calcular distanci
    public double calcularDistancia(LinkedList<String> p1, LinkedList<String> p2){
        
        double valores=0;
        
         //converter valores para doble e fazer os calculos para cada elemento
             for(int i=0; i<p1.size();i++){
                double pt1 =Double.parseDouble(p1.get(i));  
                double pt2 =Double.parseDouble(p2.get(i)); 
                double ptRes = pt1-pt2;
                valores = valores + (Math.pow(ptRes, 2));// somatorio(p1i - p2i)^2
             }
             
             return Math.sqrt(valores);
             
        /*
        double xres = x1-x2;
        double yres = y1-y2;
        
        return Math.sqrt(((Math.pow(xres, 2))+(Math.pow(yres, 2))));  
       */
    }
    
}


