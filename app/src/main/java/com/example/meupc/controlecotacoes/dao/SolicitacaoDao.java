package com.example.meupc.controlecotacoes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.meupc.controlecotacoes.model.Solicitacao;
import com.example.meupc.controlecotacoes.model.Status;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by MeuPC on 15/03/2017.
 */

public class SolicitacaoDao {

    private SQLiteDatabase db;
    private DBOpenHelper banco;

    public SolicitacaoDao(Context context){
        banco = new DBOpenHelper(context);
    }

    private static final String TABELA_SOLICITACAO = "solicitacao";
    private static final String COLUNA_ID = "idsolicitacao";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String COLUNA_DTIDA = "dt_ida";
    private static final String COLUNA_ORIGEM = "origem";
    private static final String COLUNA_DESTINO = "destino";
    private static final String COLUNA_DTVOLTA = "dt_volta";
    private static final String COLUNA_IDAEVOLTA = "ida_e_volta";
    private static final String COLUNA_STATUSID = "status_id";

    public String add(Solicitacao solicitacao) {
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME, solicitacao.getNome());
        values.put(COLUNA_TELEFONE, solicitacao.getTelefone());
//        values.put(COLUNA_DTIDA, solicitacao.getDt_ida()); CONVERTER DATE PARA STRING
        values.put(COLUNA_ORIGEM, solicitacao.getOrigem());
        values.put(COLUNA_DESTINO, solicitacao.getDestino());
//        values.put(COLUNA_DTVOLTA, solicitacao.getDt_volta());  CONVERTER DATE PARA STRING
//        values.put(COLUNA_IDAEVOLTA, solicitacao.getIdaEvolta());  CONVERTER CHAR PARA STRING
        values.put(COLUNA_STATUSID, solicitacao.getStatus().getIdstatus());

        resultado = db.insert(TABELA_SOLICITACAO, null, values);

        db.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso.";
        }
    }

        public List<Solicitacao> getAll(){
            List<Solicitacao> solicitacoes = new LinkedList<>();

            String rawQuery = "select s.*, st.descricao FROM "+
                    SolicitacaoDao.TABELA_SOLICITACAO + "s INNER JORIN "+
                    StatusDao.TABELA_STATUS + "st ON s."+ SolicitacaoDao.COLUNA_STATUSID + "= st."+
                    StatusDao.COLUNA_ID + " ORDER BY "+SolicitacaoDao.COLUNA_NOME + " ASC";

            SQLiteDatabase db = banco.getReadableDatabase();
            Cursor cursor = db.rawQuery(rawQuery, null);

            Solicitacao solicitacao = null;
            if(cursor.moveToFirst()){
                do{
                    solicitacao = new Solicitacao();
                    solicitacao.setIdsolicitacao(cursor.getInt(0));
                    solicitacao.setNome(cursor.getString(2));
                    solicitacao.setTelefone(cursor.getString(2));
//                    solicitacao1.setDt_ida(cursor.getString(2));
                    solicitacao.setOrigem(cursor.getString(2));
                    solicitacao.setDestino(cursor.getString(2));
//                    solicitacao1.setDt_volta(cursor.getString(2));
//                    solicitacao1.setIdaEvolta(cursor.getString(2));
                    solicitacao.setStatus(new Status(cursor.getInt(1), cursor.getString(3)));

                    solicitacoes.add(solicitacao);
                }while (cursor.moveToNext());
            }
            return solicitacoes;
        }
}


