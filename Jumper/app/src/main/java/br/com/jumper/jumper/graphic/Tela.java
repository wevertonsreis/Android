package br.com.jumper.jumper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Weverton on 17/11/2016.
 */
public class Tela {

    private DisplayMetrics displayMetrics;

    public Tela(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
    }

    /**
     *
     * @return
     */
    public int getAltura() {
        return displayMetrics.heightPixels;
    }

    /**
     *
     * @return
     */
    public int getLargura() {
        return displayMetrics.widthPixels;
    }

}
