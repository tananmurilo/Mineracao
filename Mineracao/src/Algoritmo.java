
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
    
    public void salvarIdAtributos(String principal, String id1, String id2){
        
         for(int i=0; i<atributos.size(); i++){
            if(atributos.get(i).equals(principal)){
                this.idAtributoClasse= i ;
            }else if(atributos.get(i).equals(id1)){
                this.idAtributoRelevante1=i;
            }else if(atributos.get(i).equals(id2)){
                this.idAtributoRelevante2=i;
            }
         }
        
         if(id2.equals("Nulo")){
             this.idAtributoRelevante2= -1;
         }
            
    }
    
    public String start(LinkedList<String> entrada, int n){
        
        LinkedList<VetorDistancia> vetor = new LinkedList<>();
        
        
        for(int i=0; i<dadosLinha.size(); i++){
           // Double valorDouble = Double.parseDouble(valor); 
           
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
            
            //adicionar informações das distancias de cada item na lista
            VetorDistancia v = new VetorDistancia(); 
            v.setId(i);
            v.setDist(resDist);
            vetor.add(v); 
            
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
        if(n==1){
            return dadosLinha.get(vetor.get(0).getId()).get(idAtributoClasse); //retorna a classe que pertence ao elemento mais proximo
        }else{
             return "Indefinido";
        }
        
       
    }
    
    public double calcularDistancia(double x1, double y1, double x2, double y2){
        double xres = x1-x2;
        double yres = y1-y2;
        
        return Math.sqrt(((Math.pow(xres, 2))+(Math.pow(yres, 2))));     
    }
    
}


