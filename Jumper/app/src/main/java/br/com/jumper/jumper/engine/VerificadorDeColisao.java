package br.com.jumper.jumper.engine;

import br.com.jumper.jumper.elements.Canos;
import br.com.jumper.jumper.elements.Passaro;

/**
 * Created by Weverton on 24/11/2016.
 */
public class VerificadorDeColisao {

    private Passaro passaro;
    private Canos canos;

    /**
     *
     * @param passaro
     * @param canos
     */
    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
