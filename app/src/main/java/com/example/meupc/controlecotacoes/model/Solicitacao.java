package com.example.meupc.controlecotacoes.model;

import java.util.Date;

/**
 * Created by MeuPC on 15/03/2017.
 */

public class Solicitacao {
    private int idsolicitacao;
    private String nome;
    private String telefone;
    private Date dt_ida;
    private String origem;
    private String destino;
    private Date dt_volta;
    private char idaEvolta;
    private Status status;

    public int getIdsolicitacao() {
        return idsolicitacao;
    }

    public void setIdsolicitacao(int idsolicitacao) {
        this.idsolicitacao = idsolicitacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDt_ida() {
        return dt_ida;
    }

    public void setDt_ida(Date dt_ida) {
        this.dt_ida = dt_ida;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDt_volta() {
        return dt_volta;
    }

    public void setDt_volta(Date dt_volta) {
        this.dt_volta = dt_volta;
    }

    public char getIdaEvolta() {
        return idaEvolta;
    }

    public void setIdaEvolta(char idaEvolta) {
        this.idaEvolta = idaEvolta;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
