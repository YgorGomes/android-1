package com.example.meupc.controlecotacoes.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.meupc.controlecotacoes.model.Status;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by MeuPC on 15/03/2017.
 */

public class StatusDao {
    private DBOpenHelper banco;

    public StatusDao(Context context){
        banco = new DBOpenHelper(context);
    }

    public static final String TABELA_STATUS = "status";

    public static final String COLUNA_ID = "idstatus";
    public static final String COLUNA_DESCRICAO = "descricao";

    public List<Status> getAll(){
        List<Status> status = new LinkedList<>();

        String query = "SELECT * FROM "+TABELA_STATUS;

        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Status status1 = null;
        if(cursor.moveToFirst()) {
            do {
                status1 = new Status();
                status1.setIdstatus(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));
                status1.setDescricao(cursor.getString(cursor.getColumnIndex(COLUNA_DESCRICAO)));
                status.add(status1);
            } while (cursor.moveToNext());
        }
        return status;
    }

    public Status getBy(int idstatus){
        SQLiteDatabase db = banco.getReadableDatabase();
        String colunas[] = {COLUNA_ID, COLUNA_DESCRICAO};
        String where = "idstatus = "+ idstatus;
        Cursor cursor = db.query(true, TABELA_STATUS, colunas, where, null, null, null, null, null);

        Status status = null;

        if(cursor != null){
            cursor.moveToFirst();
            status = new Status();
            status.setIdstatus(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));
            status.setDescricao(cursor.getString(cursor.getColumnIndex(COLUNA_DESCRICAO)));
        }
        return status;
    }

}
