package com.example.alumno.clase5;

/**
 * Created by alumno on 25/04/2019.
 */

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by alumno on 11/04/2019.
 */

public class MyThread extends Thread {
    Handler handler;
    String url;
    int imagenText;
    int position;
    public MyThread(Handler handler,String url, int imagenText,int position){
        this.handler = handler;
        this.url = url;
        this.imagenText = imagenText;
        this.position =position;
    }
    @Override
    public void run(){
        HttpManager http = new HttpManager();
        Message m = new Message();
        m.arg1 = imagenText;
        m.arg2 = position;
        if(imagenText == MainActivity.TEXTO){

            String s = http.Conectar(url);
            m.obj = ParseXml.parseXml(s);
        }
        else{
            byte [] img = http.ConectarImagen(url);
            m.obj = img;
        }
        this.handler.sendMessage(m);
    }

}
