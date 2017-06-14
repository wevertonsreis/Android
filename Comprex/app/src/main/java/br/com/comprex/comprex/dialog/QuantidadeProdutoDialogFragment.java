package br.com.comprex.comprex.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import br.com.comprex.comprex.R;
import br.com.comprex.comprex.dao.ProdutoListaDAO;
import br.com.comprex.comprex.modelo.Lista;
import br.com.comprex.comprex.modelo.Produto;
import br.com.comprex.comprex.modelo.ProdutoLista;
import br.com.comprex.comprex.modelo.ProdutoMercado;

/**
 * Classe que representa a caixa de dialogo para escolha de quantidade
 * de produto.
 *
 * Created by wevertonreis on 25/05/17.
 *
 */
public class QuantidadeProdutoDialogFragment extends DialogFragment {

    private ProdutoMercado produtoMercado;
    private Lista lista;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        produtoMercado = (ProdutoMercado) getArguments().get("produtoMercado");
        lista = (Lista) getArguments().get("lista");

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_quantidade, null);

        final NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.numberPicker_quantidade_produto);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(30);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view);

        builder.setTitle("Quantidade");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ProdutoLista produtoLista = new ProdutoLista();
                produtoLista.setProdutoMercado(produtoMercado);
                produtoLista.setLista(lista);
                produtoLista.setQuantidade(numberPicker.getValue());

                ProdutoListaDAO produtoListaDAO = new ProdutoListaDAO(getActivity());
                produtoListaDAO.inserir(produtoLista);

                getActivity().setResult(1, getActivity().getIntent());

                QuantidadeProdutoDialogFragment.this.getDialog().dismiss();

                Toast.makeText(getActivity(), "Produto(s) adicionado(s) com sucesso", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                QuantidadeProdutoDialogFragment.this.getDialog().cancel();
            }
        });

        return builder.create();
    }
}
