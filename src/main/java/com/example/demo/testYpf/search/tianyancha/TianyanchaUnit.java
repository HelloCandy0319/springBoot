package com.example.demo.testYpf.search.tianyancha;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TianyanchaUnit {

    @Autowired
    private TianyanchaConfig tianyanchaConfig;

    public void getMessageByUrl(String url){
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Authorization",tianyanchaConfig.getToken());
        HttpClient httpClient = new DefaultHttpClient();
        try{
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                System.out.println("----------------"+result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
