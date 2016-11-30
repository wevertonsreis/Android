package br.com.jumper.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.jumper.jumper.graphic.Cores;
import br.com.jumper.jumper.graphic.Tela;

/**
 * Classe responsavel por representar o fim de jogo
 *
 * @author Weverton Reis
 */
public class GameOver {

    private static final Paint PAINT = Cores.getCorDoGameOver();

    private Tela tela;

    /**
     * @param tela
     */
    public GameOver(Tela tela) {
        this.tela = tela;
    }

    /**
     * Classe responsavel por desenhar o elemento da tela
     *
     * @param canvas
     */
    public void desenhaNo(Canvas canvas) {
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroHorizontal, tela.getAltura() / 2, PAINT);
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
