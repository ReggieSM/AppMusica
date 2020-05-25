package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CancionesFavoritas extends AppCompatActivity {

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones_favoritas);

        final ArrayList<String> listaCancion;
        final ListView lista = (ListView)findViewById(R.id.listaCancionesFav);
        listaCancion = new ArrayList<String>();

        queue = Volley.newRequestQueue(this);
        String url = "http://localhost:3000/canciones";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response){

                try {

                    JSONArray mJsonArray = response.getJSONArray("canciones");


                        JSONObject mJsonObject = mJsonArray.getJSONObject(2);
                        String name = mJsonObject.getString("nombre");
                        listaCancion.add(name);




                } catch (JSONException e){
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error){

                    }
                });

        queue.add(request);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCancion);


        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(CancionesFavoritas.this, "Has pulsado: "+ listaCancion.get(position), Toast.LENGTH_LONG).show();
            }
        });

}


}
