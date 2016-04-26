package br.com.guiapgcity.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.guiapgcity.model.Empresa;

/**
 *
 */
public class EmpresaAdapter extends BaseAdapter {

    private List<Empresa> empresas;
    private Activity activity;

    /**
     *
     * @param empresas
     * @param activity
     */
    public EmpresaAdapter(List<Empresa> empresas, Activity activity) {
        this.empresas = empresas;
        this.activity = activity;
    }

    /**
     * Retorna a quantidade de registros na lista
     *
     * @return
     */
    @Override
    public int getCount() {
        return empresas.size();
    }

    /**
     * Retorna o objeto referente a posicao informada
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return empresas.get(position);
    }

    /**
     * Retorna o identificador do objeto de acordo com a posicao informada
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return empresas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return null;
    }
}
