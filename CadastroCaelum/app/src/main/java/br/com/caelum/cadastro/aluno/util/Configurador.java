package br.com.caelum.cadastro.aluno.util;

import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

import br.com.caelum.cadastro.aluno.listener.AtualizadorDeLocalizacao;

public class Configurador implements GoogleApiClient.ConnectionCallbacks {

    private AtualizadorDeLocalizacao atualizadorDeLocalizacao;

    public Configurador(AtualizadorDeLocalizacao atualizadorDeLocalizacao) {
        this.atualizadorDeLocalizacao = atualizadorDeLocalizacao;
    }

    @Override
    public void onConnected(Bundle bundle) {
        LocationRequest locationRequest = new LocationRequest().create();
        locationRequest.setInterval(2000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setSmallestDisplacement(50);

        atualizadorDeLocalizacao.inicia(locationRequest);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}
