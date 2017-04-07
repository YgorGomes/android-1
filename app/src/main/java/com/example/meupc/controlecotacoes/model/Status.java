package com.example.meupc.controlecotacoes.model;

/**
 * Created by MeuPC on 15/03/2017.
 */

public class Status {
    private int idstatus;
    private String descricao;

    public Status(){

    }

    public Status(int idstatus, String descricao ){
        this.idstatus = idstatus;
        this.descricao = descricao;

    }

    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
