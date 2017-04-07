package com.example.meupc.controlecotacoes;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.meupc.controlecotacoes.dao.SolicitacaoDao;
import com.example.meupc.controlecotacoes.model.Solicitacao;

public class NovaCotacaoActivity extends AppCompatActivity {

    public final static int CODE_NOVA_COTACAO = 1002;

    private TextInputLayout tilNomePassageiro;
    private TextInputLayout tilTelefone;
    private TextInputLayout tilDtIda;
    private TextInputLayout tilOrigem;
    private TextInputLayout tilDestino;
    private TextInputLayout tilDtVolta;
    private RadioButton rbida;
    private RadioButton rbida_e_volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_cotacao);

        tilNomePassageiro = (TextInputLayout) findViewById(R.id.tilNomePassageiro);
        tilDtIda = (TextInputLayout) findViewById(R.id.tilDtIda);
        tilOrigem = (TextInputLayout) findViewById(R.id.tilOrigem);
        tilDestino = (TextInputLayout) findViewById(R.id.tilDestino);
        tilDtVolta = (TextInputLayout) findViewById(R.id.tilDtVolta);
        rbida = (RadioButton) findViewById(R.id.rbida);
        rbida_e_volta = (RadioButton) findViewById(R.id.rbida_e_volta);

        }

    public  void cadastrar(View v){
        SolicitacaoDao solicitacaoDao = new SolicitacaoDao(this);
        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setNome(tilNomePassageiro.getEditText().getText().toString());
        solicitacao.setNome(tilDtIda.getEditText().getText().toString());
        solicitacao.setNome(tilOrigem.getEditText().getText().toString());
        solicitacao.setNome(tilDestino.getEditText().getText().toString());
        solicitacao.setNome(tilDtVolta.getEditText().getText().toString());

        solicitacaoDao.add(solicitacao);

        retornarParaTelaAnterior();
    }

    public void retornarParaTelaAnterior(){
        Intent intentMessage = new Intent();
        setResult(CODE_NOVA_COTACAO, intentMessage);
        finish();
    }
}
