package br.com.caelum.cadastro.aluno.listener;

import android.content.Context;
import android.location.Location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import br.com.caelum.cadastro.aluno.fragment.MapFragment;
import br.com.caelum.cadastro.aluno.util.Configurador;

public class AtualizadorDeLocalizacao implements LocationListener {

    private GoogleApiClient googleApiClient;
    private MapFragment mapFragment;

    public AtualizadorDeLocalizacao(Context context, MapFragment mapFragment) {
        this.mapFragment = mapFragment;
        Configurador configurador = new Configurador(this);
        this.googleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(configurador)
                .build();
        this.googleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mapFragment.centralizaNo(latLng);
    }

    @SuppressWarnings("ResourceType")
    public void inicia(LocationRequest locationRequest) {
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    public void cancela() {
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        this.googleApiClient.disconnect();
    }
}
