package br.com.jumper.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.jumper.jumper.engine.Som;
import br.com.jumper.jumper.graphic.Cores;
import br.com.jumper.jumper.graphic.Tela;

/**
 * Created by Weverton on 24/11/2016.
 */
public class Pontuacao {

    private static final Paint PAINT = Cores.getCorDaPontuacao();

    private int pontos = 0;

    private Tela tela;
    private Som som;

    /**
     *
     * @param tela
     */
    public Pontuacao(Tela tela, Som som) {
        this.tela = tela;
        this.som = som;
    }

    /**
     *
     * @param canvas
     */
    public void desenhaNo(Canvas canvas) {
        String pontuacao = String.valueOf(pontos);
        int centroHorizontal = centralizaTexto(pontuacao);
        canvas.drawText(pontuacao, centroHorizontal, 100, PAINT);
    }

    /**
     *
     */
    public void aumenta() {
        this.som.tocarSom(Som.PONTOS);
        this.pontos ++;
    }

    /**
     * @param texto
     * @return
     */
    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        PAINT.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
        return centroHorizontal;
    }

}
