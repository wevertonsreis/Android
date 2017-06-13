package br.com.comprex.comprex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import br.com.comprex.comprex.R;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail;
    private EditText campoSenha;
    private Button botaoEntrar;
    private Button botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = (EditText) findViewById(R.id.login_campo_email);
        campoSenha = (EditText) findViewById(R.id.login_campo_senha);
        botaoEntrar = (Button) findViewById(R.id.login_botao_entrar);
        botaoCadastrar = (Button) findViewById(R.id.login_botao_cadastrar);

        botaoEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        botaoCadastrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTelaCadastro();
            }
        });
    }

    /**
     * Efetua o login do usuario
     */
    private void login() {
        mostrarTelaPrincipal();
    }

    /**
     * Redireciona o usuario para a tela princial e finaliza a tela de login
     */
    private void mostrarTelaPrincipal() {
        Intent irParaTelaLogin = new Intent(LoginActivity.this, ListaMercadoActivity.class);
        startActivity(irParaTelaLogin);
        finish();
    }

    /**
     * Redireciona o usuario para a tela de cadastro
     */
    private void mostrarTelaCadastro() {
        Intent intentTelaCadastro = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
        startActivity(intentTelaCadastro);
    }

}