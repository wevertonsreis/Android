package br.com.caelum.cadastro.aluno.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import br.com.caelum.cadastro.comum.Extras;
import br.com.caelum.cadastrocaelum.R;

/**
 * Created by Weverton on 12/02/2016.
 */
public class VerSite extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site);

        String site = getIntent().getExtras().getString(Extras.URL_SITE.toString());

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(site);


    }
}
