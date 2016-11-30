package br.com.jumper.jumper.elements;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import br.com.jumper.jumper.R;
import br.com.jumper.jumper.graphic.Tela;

/**
 * @author Weverton Reis
 */
public class Ceu {

    private Bitmap background;

    /**
     *
     * @param tela
     * @param context
     */
    public Ceu(Tela tela, Context context) {
        Bitmap back = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    /**
     *
     * @param canvas
     */
    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(background, 0, 0, null);
    }

}
