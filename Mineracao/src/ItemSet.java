
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
public class ItemSet {
    public ItemSet(){
        itens = new LinkedList<>();
    }
    
    private LinkedList<String> itens;
    
    public void add(String nome){
        itens.add( nome);
    }
   
    public int size(){
        return itens.size();
    }
    
    public LinkedList<String> getLista(){
        return this.itens;
    }
    public String getElemento(int pos){
        return itens.get(pos);
    }

    
}
 