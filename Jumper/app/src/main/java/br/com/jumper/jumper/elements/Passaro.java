package br.com.jumper.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.jumper.jumper.R;
import br.com.jumper.jumper.engine.Som;
import br.com.jumper.jumper.graphic.Cores;
import br.com.jumper.jumper.graphic.Tela;

/**
 *
 * @author Weverton Reis
 */
public class Passaro {

    public static final float X = 100;
    public static final int RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();

    private float altura;

    private Tela tela;

    private Bitmap passaro;

    private Som som;

    /**
     *
     * @param tela
     */
    public Passaro(Tela tela, Context context, Som som) {
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
        this.tela = tela;
        this.altura = 100;
        this.som = som;
    }

    /**
     *
     * @param canvas
     */
    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    /**
     *
     */
    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if (!chegouNoChao) {
            this.altura += 5;
        }

    }

    /**
     *
     */
    public void pula() {
        this.som.tocarSom(Som.PULO);
        int bordaSuperior = (int) altura - RAIO;
        if(bordaSuperior > 0) {
            altura -= 150;
        }
    }

    /**
     *
     * @return
     */
    public float getAltura() {
        return altura;
    }
}
