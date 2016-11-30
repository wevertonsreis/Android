package br.com.jumper.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.jumper.jumper.R;
import br.com.jumper.jumper.graphic.Cores;
import br.com.jumper.jumper.graphic.Tela;

/**
 *
 * @author Weverton Reis
 */
public class Cano {

    private final Paint verde = Cores.getCorDoCano();

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;

    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;

    private Tela tela;

    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    /**
     *
     * @param tela
     * @param posicao
     * @param context
     */
    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoInferior, false);

        bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);

    }

    /**
     *
     * @return
     */
    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    /**
     *
     * @param canvas
     */
    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    /**
     *
     * @param canvas
     */
    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    /**
     *
     * @param canvas
     */
    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    /**
     *
     */
    public void move() {
        posicao -= 5;
    }

    /**
     *
     * @return
     */
    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    /**
     *
     * @param passaro
     * @return
     */
    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.X < passaro.RAIO;
    }

    /**
     *
     * @param passaro
     * @return
     */
    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }
}
