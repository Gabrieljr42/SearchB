package com.ifmg.POO.searchb.modelos;



import java.util.Calendar;

public class AlertaData {
    private Calendar dataAlerta;
    private Versiculo conteudo;

    public AlertaData(Calendar dataAlerta, Versiculo conteudo){
        this.dataAlerta = dataAlerta;
        this.conteudo = conteudo;
    }
    public AlertaData(){
        dataAlerta = Calendar.getInstance();
    }
    public void setConteudo(Versiculo conteudo) {
        this.conteudo = conteudo;
    }

    public Calendar getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(Calendar dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

}
