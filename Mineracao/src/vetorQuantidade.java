/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author murilo
 */
public class vetorQuantidade {
    public vetorQuantidade(){
        quantidade=0;
    }
    private int quantidade;
    private String attributoNome;
    
    public void incrementarQnt(){
        quantidade++;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @return the attributoNome
     */
    public String getAttributoNome() {
        return attributoNome;
    }

    /**
     * @param attributoNome the attributoNome to set
     */
    public void setAttributoNome(String attributoNome) {
        this.attributoNome = attributoNome;
    }
    
    
    
}
