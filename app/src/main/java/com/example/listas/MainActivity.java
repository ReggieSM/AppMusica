package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> listasRep;
        final ListView lista = (ListView)findViewById(R.id.lista);
        //final String[] listasRep = {"", "", "", ""};

        listasRep = new ArrayList<String>();
        listasRep.add("Lista Vacía");
        listasRep.add("Música para dormir");
        listasRep.add("Pop en español");
        listasRep.add("Canciones favoritas");
        listasRep.add("Música Romántica");


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listasRep);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                //Toast.makeText(MainActivity.this, "Has pulsado: "+ listasRep.get(position), Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(MainActivity.this, ListaCancionesRomanticas.class);

                //intent.putExtra("objetoData" , listasRep.get(position));
                //listasRep.get(position);
                switch(position){

                    case 4:
                        Intent intent = new Intent(MainActivity.this, CancionesRomanticas.class);
                        startActivity(intent);
                        break;
                    case 0:
                        Toast.makeText(MainActivity.this, "Has pulsado Lista Vacía", Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        Toast.makeText(MainActivity.this, "Has pulsado Música para dormir ", Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, "Has pulsado pop en español", Toast.LENGTH_LONG).show();
                        break;

                    case 3:
                        Intent intent2 = new Intent(MainActivity.this, CancionesFavoritas.class);
                        startActivity(intent2);
                        //Toast.makeText(MainActivity.this, "Has pulsado Canciones favoritas", Toast.LENGTH_LONG).show();
                        break;
                }


            }
        });


    }

}
