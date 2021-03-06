/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cx.estrutura.dados.ii;

import java.lang.reflect.Array;

/**
 *
 * @author Vitor
 */
public class Lista<T> {
    
    private T[] elementos;
    private int tamanho;
    
    // construtor onde posso passar somente a capacidade para lista generica
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
    }
    // Construtor onde posso passar o tipo de classe para lista generica
    public Lista(int capacidade, Class<T> tipoClasse){
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        if (tamanho < elementos.length) {
            this.elementos[tamanho] = elemento;
            tamanho++;
            return true;
        } else {
            return false;
        }
    }

    public boolean adiciona(int posicao, T elemento) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Indice do vetor não existe");
        }
        this.aumentaCapacidade();

        for (int i = tamanho; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void aumentaCapacidade() {
        if (tamanho == this.elementos.length) {
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public T busca(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Indice do vetor não existe");
        }
        return this.elementos[posicao];
    }

    public int buscarPorIndice(T elemento) {
        // busca sequencial
        for (int i = 0; i < tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public int tamanho() {
        return this.tamanho;
    }
    //  B G D E F
    //  0 1 2 3 4
    // vetor[1] = vetor[2];
    // vetor[2] = vetor[3];
    // vetor[3] = vetor[4];
    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Indice do vetor não existe");
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    public void removePorNome(T elemento) {
        remove(buscarPorIndice(elemento));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < tamanho(); i++) {
            s.append(this.elementos[i]);
            if (i == tamanho() - 1) {
                s.append("");
            } else {
                s.append(",");
            }
        }
        s.append("]");
        return s.toString();
    }

}
