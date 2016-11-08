package com.vania.jogoforca;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vania on 08/11/16.
 */

public class ForcaController {

    private String palavraParaAdvinhar;//palavra a ser advinhada
    private Set<Character> letrasUsadas;//lista com as leras que foram usadas, sem repetir SET
    private int qntErros = -1; //quantidade de erros

    public ForcaController(String palavra) {
        this.palavraParaAdvinhar = palavra;
        letrasUsadas = new HashSet<>();
    }

    public void joga(Character letra){
        //caso o set ja tenha  aletra jogada saimos da funcao
        if(letrasUsadas.contains(letra)){
            return;
        }
        letrasUsadas.add(letra);
        if(palavraParaAdvinhar.contains(letra.toString())){
            return;
        }
        qntErros++;

    }

    public String getpalavraAteAgora(){
        String visuazlizacao = "";
        for(char c : palavraParaAdvinhar.toCharArray()){
            if(letrasUsadas.contains(c)){
                visuazlizacao += c;

            }else {
                visuazlizacao += " ";
            }
        }
        return visuazlizacao;
    }

    public boolean isMorreu(){
        return getQntErros() == 5;
    }

    public boolean isGanhou(){
        return !getpalavraAteAgora().contains(" ");
    }

    public boolean isTerminou(){
        return isGanhou() || isMorreu();
    }

    public int getQntErros() {
        return qntErros;
    }
}
