
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
public class Linha {
    LinkedList<String> lista =  new LinkedList<>();
    
    public void add(String nome){
        lista.add(nome);
    }
   
    public int size(){
        return lista.size();
    }
    public String get(int pos){
        return lista.get(pos);
    }
    
    public LinkedList<String> getLista(){
        return this.lista;
    }
}
