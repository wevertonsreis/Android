package br.com.caelum.cadastro.aluno.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class Localizador {

    private Geocoder geocoder;

    public Localizador(Context context) {
        this.geocoder = new Geocoder(context);
    }

    public LatLng getCoordenada(String endereco) {
        try {
            List<Address> fromLocationName = geocoder.getFromLocationName(endereco, 1);

            if (fromLocationName != null && !fromLocationName.isEmpty()){
                Address address = fromLocationName.get(0);
                return new LatLng(address.getLatitude(), address.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
