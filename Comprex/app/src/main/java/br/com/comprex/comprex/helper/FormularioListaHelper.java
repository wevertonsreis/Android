package br.com.comprex.comprex.helper;

import android.widget.EditText;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.activity.FormularioListaActivity;
import br.com.comprex.comprex.modelo.Lista;

public class FormularioListaHelper {

    private EditText campoNome;

    public FormularioListaHelper(FormularioListaActivity activity) {
        this.campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
    }

    public Lista getLista() {
        Lista lista = new Lista();
        lista.setNome(this.campoNome.getText().toString().toUpperCase());
        return lista;
    }

    public EditText getCampoNome() {
        return campoNome;
    }
}
