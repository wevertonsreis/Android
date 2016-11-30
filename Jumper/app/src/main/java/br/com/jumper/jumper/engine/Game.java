package br.com.jumper.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.jumper.jumper.elements.Canos;
import br.com.jumper.jumper.elements.Ceu;
import br.com.jumper.jumper.elements.GameOver;
import br.com.jumper.jumper.elements.Passaro;
import br.com.jumper.jumper.elements.Pontuacao;
import br.com.jumper.jumper.graphic.Tela;

/**
 *
 *@author Weverton Reis
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Tela tela;

    private Ceu ceu;
    private Passaro passaro;
    private Canos canos;
    private Pontuacao pontuacao;
    private Som som;

    /**
     *
     * @param context
     */
    public Game(Context context) {
        super(context);
        this.tela = new Tela(context);
        this.som = new Som(context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    /**
     *
     */
    private void inicializaElementos() {
        this.ceu = new Ceu(tela, getContext());
        this.passaro = new Passaro(tela, getContext(), som);
        this.pontuacao = new Pontuacao(tela, som);
        this.canos = new Canos(tela, pontuacao, getContext());
    }

    @Override
    public void run() {
        while (isRunning) {
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();

            this.ceu.desenhaNo(canvas);
            this.passaro.desenhaNo(canvas);
            this.canos.desenhaNo(canvas);
            this.pontuacao.desenhaNo(canvas);

            this.passaro.cai();
            this.canos.move();

            if (new VerificadorDeColisao(passaro, canos).temColisao()){
                new GameOver(tela).desenhaNo(canvas);
                this.som.tocarSom(Som.COLISAO);
                isRunning = false;
            }

            this.holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        this.isRunning = true;
    }

    public void pausa() {
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isRunning) {
            passaro.pula();
        }
        return false;
    }

}
