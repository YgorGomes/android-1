package com.example.meupc.controlecotacoes;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private final String LOGIN_DEFAULT = "android";
    private final String SENHA_DEFAULT = "123";

    private final String KEY_APP_PREFERENCES = "login";
    private final String KEY_LOGIN = "login";

    private TextInputLayout tilLogin;
    private TextInputLayout tilSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilLogin = (TextInputLayout) findViewById(R.id.tilLogin);
        tilSenha = (TextInputLayout) findViewById(R.id.tilSenha);


    }

    //MetodoLogar
    public void logar(View v){
        if(isLoginValido()){
            iniciarApp();
        }
    }

    //valida Login
    private boolean isLoginValido(){
        String login = tilLogin.getEditText().getText().toString();
        String senha = tilSenha.getEditText().getText().toString();

        if(login.equals(LOGIN_DEFAULT) && senha.equals(SENHA_DEFAULT)){
            return true;
        }else{
            return false;
        }
    }

    private void iniciarApp(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
