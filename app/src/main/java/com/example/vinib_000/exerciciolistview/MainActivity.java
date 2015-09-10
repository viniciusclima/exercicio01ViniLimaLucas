package com.example.vinib_000.exerciciolistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Spinner;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    private String origem = "";
    private String destinos = "";
    private String orides = origem + " - " + destinos;
    Spinner cidade;
    Spinner destino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] cidades = new String[]{"Sao Paulo", "Rio de Janeiro"};
        final String[] cidadesdestino = new String[]{"Porto Alegre", "Salvador"};
        ArrayAdapter<String> adapterCidade = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cidades);
         cidade = (Spinner) findViewById(R.id.listorigem);
        cidade.setAdapter(adapterCidade);
        ArrayAdapter<String> adapterDestino = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cidadesdestino);
        destino = (Spinner) findViewById(R.id.listdestino);
        destino.setAdapter(adapterDestino);
        cidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //origem = cidades[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        destino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //destinos = cidadesdestino[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getorigemdest(View view) {
    String origems = (String)cidade.getSelectedItem();
    String destinosss = (String)destino.getSelectedItem();
        Bundle params = new Bundle();
        Intent intent = new Intent(this,vooActivity.class);
        params.putString("cidadeorigem",origems);
        params.putString("cidadedestino", destinosss);

        intent.putExtra("valores",params);
        //intent.putExtra("destino",destinosss);
        startActivity(intent);
    }


}
