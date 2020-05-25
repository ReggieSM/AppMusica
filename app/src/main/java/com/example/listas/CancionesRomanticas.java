package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class CancionesRomanticas extends AppCompatActivity {


    public String generateUrl(String s){
        String[] p=s.split("/");
        String imageLink="https://drive.google.com/file/d/1Dnpvav7UmVZsU4Wj3s0SjdJ-QUYS7Jy4/view?usp=sharing"+p[5];
        return imageLink;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_canciones_romanticas);
        final ArrayList<String> listaCancion;
        final ListView lista = (ListView)findViewById(R.id.listaCancionesFav);
        //final String[] listasRep = {"", "", "", ""};



        listaCancion = new ArrayList<String>();
        listaCancion.add("All you need is love");
        listaCancion.add("Sway");
        listaCancion.add("La vie en rose");
        listaCancion.add("The Dance");
        listaCancion.add("Marry you");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCancion);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(CancionesRomanticas.this, "Has pulsado: "+ listaCancion.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
