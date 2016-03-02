package br.com.caelum.cadastro.support;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Weverton on 29/02/2016.
 */
public class WebClient {

    private final String url;

    /**
     *
     * @param url
     */
    public WebClient(String url) {
        this.url = url;
    }

    /**
     *
     * @param json
     * @return
     */
    public String post(String json) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://localhost:8080/buscaralunos");
            post.setEntity(new StringEntity(json));
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");

            HttpResponse response = httpClient.execute(post);

            String jsonResposta = EntityUtils.toString(response.getEntity());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResposta;
    }
}
