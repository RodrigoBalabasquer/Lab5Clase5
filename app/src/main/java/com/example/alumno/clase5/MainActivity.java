package com.example.alumno.clase5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements MyOnItemClick, Handler.Callback {
    MyAdapter adapter;
    List<PersonaModel> personas;
    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListener listener = new MyListener(this);
        Button btn = (Button) super.findViewById(R.id.btn);
        btn.setOnClickListener(listener);

        personas = new ArrayList<>();
        //personas.add(new PersonaModel("Rodrigo","Balabasquer","4240-9124"));
        //personas.add(new PersonaModel("Matias","Pinel","4356-2463"));
        /*personas.add(new PersonaModel("Pepe","Fulanito","4240-3842"));
        personas.add(new PersonaModel("Lautaro","Cosme","4240-7810"));
        personas.add(new PersonaModel("Sheldon","Cooper","4831-6842"));
        personas.add(new PersonaModel("Peny","Lalalala","4789-3651"));
        personas.add(new PersonaModel("Seiya","Pegaso","4012-9864"));
        personas.add(new PersonaModel("Goku","Kakaroto","4653-7436"));
        personas.add(new PersonaModel("Lui","Kang","4589-1258"));
        personas.add(new PersonaModel("David","Caceres","4332-6842"));*/

        RecyclerView rvPersona = (RecyclerView) super.findViewById(R.id.rvPersonas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPersona.setLayoutManager(layoutManager);

        Handler handler = new Handler(this);

        adapter = new MyAdapter(personas,this,handler);
        rvPersona.setAdapter(adapter);

        MyThread hilo = new MyThread(handler,"http://192.168.0.1:8080/listaPersonasImg.xml",TEXTO,0);
        hilo.start();
        /*MyThread hilo2 = new MyThread(handler,"http://www.lslutnfra.com/pagina404/homer404.jpg",IMAGEN);
        hilo2.start();*/
    }
    @Override
    public void onItemClick(int position) {
        PersonaModel person = this.personas.get(position);
        Log.d("Nueva persona",person.toString());
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1 == TEXTO){
            this.personas = this.adapter.SetPersonas((List<PersonaModel>) msg.obj);
            adapter.notifyDataSetChanged();
        }
        else{
            this.adapter.SetImagenPer((byte[])msg.obj,msg.arg2);
            adapter.notifyItemChanged(msg.arg2);
            //ImageView imagen = (ImageView)super.findViewById(R.id.imagen);
            //imagen.setImageBitmap(BitmapFactory.decodeByteArray((byte[])msg.obj,0,((byte[]) msg.obj).length));
        }
        return false;
    }
}
