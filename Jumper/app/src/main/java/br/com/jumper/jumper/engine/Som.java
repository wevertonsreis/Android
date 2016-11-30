package br.com.jumper.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.jumper.jumper.R;

/**
 * @author Weverton Reis
 */
public class Som {

    private SoundPool soundPool;
    public static int PULO;
    public static int COLISAO;
    public static int PONTOS;

    /**
     *
     * @param context
     */
    public Som(Context context) {
        this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = this.soundPool.load(context, R.raw.pulo, 1);
        COLISAO = this.soundPool.load(context, R.raw.colisao, 1);
        PONTOS = this.soundPool.load(context, R.raw.pontos, 1);
    }

    /**
     *
     * @param som
     */
    public void tocarSom(int som) {
        this.soundPool.play(som,1,1,1,0,1);
    }
}
