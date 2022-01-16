package com.ifmg.POO.searchb.modelos;

import com.ifmg.POO.searchb.modelos.Versiculo;

public class Capitulo {
    private int id;
    private Versiculo[] conteudo;

    public Capitulo(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConteudo(Versiculo[] conteudo) {
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public Versiculo[] getConteudo() {
        return conteudo;
    }

    public void createCapitulo(Versiculo[] conteudo) {
        this.conteudo = conteudo;
    }


}
