package com.example.alumno.clase5;

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

public class HttpManager {
    public String Conectar(String url){
        URL Url = null;
        try{
            Url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int res = connection.getResponseCode();
            if(res == 200){
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] aux = new byte[1024];
                int cant =  0;
                while((cant = is.read(aux)) != -1){
                    baos.write(aux,0,cant);
                }
                is.close();
                return  new String(baos.toByteArray());
            }

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public byte[] ConectarImagen(String url){
        URL Url = null;
        try{
            Url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int res = connection.getResponseCode();
            if(res == 200){
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] aux = new byte[1024];
                int cant =  0;
                while((cant = is.read(aux)) != -1){
                    baos.write(aux,0,cant);
                }
                is.close();
                return  baos.toByteArray();
            }

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}