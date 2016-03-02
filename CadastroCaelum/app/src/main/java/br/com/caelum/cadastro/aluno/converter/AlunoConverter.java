package br.com.caelum.cadastro.aluno.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import br.com.caelum.cadastro.aluno.model.Aluno;

/**
 * Created by Weverton on 29/02/2016.
 */
public class AlunoConverter {

    public String toJSON(List<Aluno> listaDeAlunos) {
        JSONStringer jsonStringer = new JSONStringer();
        try {

            jsonStringer.object().key("list").array();
            jsonStringer.object().key("aluno").array();

            for (Aluno aluno : listaDeAlunos) {
                jsonStringer.object()
                        .key("id").value(aluno.getId())
                        .key("nome").value(aluno.getNome())
                        .key("telefone").value(aluno.getTelefone())
                        .key("endereco").value(aluno.getEndereco())
                        .key("site").value(aluno.getSite())
                        .key("nota").value(aluno.getNota());
                jsonStringer.endObject();
            }
            jsonStringer.endArray();
            jsonStringer.endObject();
            jsonStringer.endArray();
            jsonStringer.endObject();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  jsonStringer.toString();
    }
}
