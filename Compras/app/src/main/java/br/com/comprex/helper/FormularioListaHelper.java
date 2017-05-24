package br.com.comprex.helper;

import android.widget.EditText;

import br.com.compras.compras.R;
import br.com.comprex.activity.FormularioListaActivity;
import br.com.comprex.modelo.Lista;

public class FormularioListaHelper {

    private EditText campoNome;

    public FormularioListaHelper(FormularioListaActivity activity) {
        this.campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
    }

    public Lista getLista() {
        Lista lista = new Lista();
        lista.setNome(this.campoNome.getText().toString());
        return lista;
    }

}
