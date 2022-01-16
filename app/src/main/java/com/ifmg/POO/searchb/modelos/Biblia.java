package com.ifmg.POO.searchb.modelos;

public class Biblia {
    private int versao;
    private Capitulo[] biblia;
    private int Livro;
    public Biblia(int versao, Capitulo[] biblia){
        this.versao = versao;
        this.biblia = biblia;

    }

    public int getLivro() {
        return Livro;
    }

    public void setLivro(int livro) {
        Livro = livro;
    }

    public Capitulo[] getBiblia() {
        return biblia;
    }

    public int getVersao() {
        return versao;
    }

    public void createBiblia(Capitulo[] biblia) {
        this.biblia = biblia;
    }


}
