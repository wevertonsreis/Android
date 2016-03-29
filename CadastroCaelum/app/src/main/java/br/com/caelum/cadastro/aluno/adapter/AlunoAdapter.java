package br.com.caelum.cadastro.aluno.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastrocaelum.R;

/**
 * Created by Weverton on 16/02/2016.
 */
public class AlunoAdapter extends BaseAdapter {

    private List<Aluno> alunos;
    private Activity activity;
    
    /**
     *
     * @param alunos
     */
    public AlunoAdapter(List<Aluno> alunos, Activity activity) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunos.get(position);

        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View linha = layoutInflater.inflate(R.layout.item, null);

        if (position % 2 == 0) {
            linha.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
        }

        TextView itemNome = (TextView) linha.findViewById(R.id.item_nome);
        itemNome.setText(aluno.getNome());

        if(aluno.getCaminhoFoto() != null && !aluno.getCaminhoFoto().isEmpty()) {
            Bitmap foto = BitmapFactory.decodeFile(aluno.getCaminhoFoto());
            Bitmap fotoReduzida = Bitmap.createScaledBitmap(foto, 100, 100, true);
            ImageView itemFoto = (ImageView) linha.findViewById(R.id.item_foto);
            itemFoto.setImageBitmap(fotoReduzida);
        }

        TextView itemTelefone = (TextView)linha.findViewById(R.id.telefone);
        if (itemTelefone != null){
            itemTelefone.setText(aluno.getTelefone());
        }

        TextView itemSite = (TextView)linha.findViewById(R.id.site);
        if (itemSite != null) {
            itemSite.setText(aluno.getSite());
        }

        return linha;
    }
}
