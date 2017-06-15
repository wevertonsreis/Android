package br.com.comprex.comprex.helper;

import android.widget.EditText;
import android.widget.Spinner;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.activity.CadastroUsuarioActivity;
import br.com.comprex.comprex.modelo.Usuario;

public class CadastroUsuarioHelper {

    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoSenha;
    private EditText campoSenhaConfirmacao;
    private Spinner campoBandeiraCartao;
    private EditText campoNumeroCartao;

    public CadastroUsuarioHelper(CadastroUsuarioActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.cadastro_usuario_nome);
        campoEmail = (EditText) activity.findViewById(R.id.cadastro_usuario_email);
        campoSenha = (EditText) activity.findViewById(R.id.cadastro_usuario_senha);
        campoSenhaConfirmacao = (EditText) activity.findViewById(R.id.cadastro_usuario_senha_confirmacao);
        campoBandeiraCartao = (Spinner) activity.findViewById(R.id.cadastro_usuario_bandeira_cartao);
        campoNumeroCartao = (EditText) activity.findViewById(R.id.cadastro_usuario_numero_cartao);
    }

    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(campoNome.getText().toString());
        usuario.setEmail(campoEmail.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        usuario.setBandeiraCartaoDeCredito(campoBandeiraCartao.getSelectedItem().toString());
        usuario.setNumeroCartaoDeCredito(campoNumeroCartao.getText().toString());
        return usuario;
    }

    public Spinner getCampoBandeiraCartao() {
        return campoBandeiraCartao;
    }

}
