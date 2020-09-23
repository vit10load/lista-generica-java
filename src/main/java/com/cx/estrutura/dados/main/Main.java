/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cx.estrutura.dados.main;

import com.cx.estrutura.dados.ii.Contato;
import com.cx.estrutura.dados.ii.Lista;
import com.cx.estrutura.dados.ii.Vetor;
import com.cx.estrutura.dados.ii.VetorObjetos;

/**
 *
 * @author Vitor
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        // Lista generica por tipo
        Lista<String> lista = new Lista<>(3);
        
        lista.adiciona("Vitor");
        lista.adiciona("Oliveira");
        lista.adiciona("Silva");
        
        System.out.println(lista);

    }
}
