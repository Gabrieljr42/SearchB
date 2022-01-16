package com.ifmg.POO.searchb.modelos;

public class Versiculo {
    private int numVer;
    private int id;
    private String conteudo;
    private boolean chave;
    private int capitulo=0;
    private int livro;
    public Versiculo(int id, String conteudo, boolean chave,int capitulo, int livro,int numVer){
        this.id = id;
        this.conteudo = conteudo;
        this.chave = chave;
        this.capitulo = capitulo;
        this.livro = livro;
        this.numVer = numVer;
    }
    public Versiculo(){

    }

    public int getNumVer() {
        return numVer;
    }

    public int getLivro() {
        return livro;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public int getId() {
        return id;
    }

    public boolean isChave() {
        return chave;
    }
}
