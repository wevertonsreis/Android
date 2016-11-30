package br.com.jumper.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.jumper.jumper.graphic.Tela;

/**
 * @author Weverton
 */
public class Canos {

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;

    private List<Cano> canos = new ArrayList<Cano>();

    private Tela tela;
    private int maximo;
    private Pontuacao pontuacao;
    private Context context;

    /**
     *
     * @param tela
     */
    public Canos(Tela tela, Pontuacao pontuacao, Context context) {
        this.tela = tela;
        this.pontuacao = pontuacao;
        this.context = context;
        int posicaoInicial = 200;

        for (int i = 0; i < QUANTIDADE_DE_CANOS ; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial, context));
        }

    }

    /**
     *
     * @param canvas
     */
    public void desenhaNo(Canvas canvas) {
        for(Cano cano : canos)
            cano.desenhaNo(canvas);
    }

    /**
     *
     */
    public void move() {
        ListIterator<Cano> iterator = canos.listIterator();

        while (iterator.hasNext()) {
            Cano cano = iterator.next();
            cano.move();

            if (cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                Cano novoCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(novoCano);
            }
        }

    }

    /**
     *
     * @return
     */
    public int getMaximo() {
        int maximo = 0;
        for(Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    /**
     *
     * @param passaro
     * @return
     */
    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano : canos) {
            if (cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }
}
