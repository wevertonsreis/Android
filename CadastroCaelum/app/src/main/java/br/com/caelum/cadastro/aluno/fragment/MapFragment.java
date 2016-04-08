package br.com.caelum.cadastro.aluno.fragment;

import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import br.com.caelum.cadastro.aluno.dao.AlunoDAO;
import br.com.caelum.cadastro.aluno.model.Aluno;
import br.com.caelum.cadastro.aluno.util.Localizador;
import br.com.caelum.cadastro.comum.helper.DBHelper;

public class MapFragment extends SupportMapFragment {

    @Override
    public void onResume() {
        super.onResume();

        Localizador localizador = new Localizador(getActivity());

        DBHelper dbHelper = new DBHelper(getActivity());
        AlunoDAO alunoDAO = new AlunoDAO(dbHelper);
        List<Aluno> alunos = alunoDAO.getLista();

        for (Aluno aluno: alunos) {
            LatLng local = localizador.getCoordenada(aluno.getEndereco());

            if (local != null){
                Log.i("teste", local.toString());
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(local);
                getMap().addMarker(markerOptions);
            }
        }

    }

    private void centralizaNo(LatLng local) {
        GoogleMap googleMap = getMap();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 17));
    }
}
