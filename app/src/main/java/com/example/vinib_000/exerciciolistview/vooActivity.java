package com.example.vinib_000.exerciciolistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class vooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo);
        Intent intent = getIntent();
        if (intent != null) {
            //text.setText("intent diferente de nula");
            Bundle parametros = intent.getBundleExtra("valores");
            String var1 = intent.getStringExtra("origem");
            //text.setText(var1);
            if (parametros != null) {
                //text.setText("Parametros diferentes de nulo");
                String origem = parametros.getString("cidadeorigem");
                String destino = parametros.getString("cidadedestino");
                String[] voo = new String[2];
                if (origem.equals("Sao Paulo") && destino.equals("Porto Alegre")) {
                    voo[0] = "Voo 1 - Sao Paulo - Porto Alegre";
                    voo[1] = "Voo 2 - Sao Paulo - Porto Alegre";
                  // text.setText("Entrei no if 1");

                } else if (origem.equals("Sao Paulo") && destino.equals("Salvador")) {
                    voo[0] = "Voo 1 - Sao Paulo - Salvador";
                    voo[1] = "Voo 2 - Sao Paulo - Salvador";


                }
                else if (origem.equals("Rio de Janeiro") && destino.equals("Salvador")) {
                    voo[0] = "Voo 1 - Rio de Janeiro - Salvador";
                    voo[1] = "Voo 2 - Rio de Janeiro - Salvador";


                }
                else if (origem.equals("Rio de Janeiro") && destino.equals("Porto Alegre")) {
                    voo[0] = "Voo 1 - Rio de Janeiro - Porto Alegre";
                    voo[1] = "Voo 2 - Rio de Janeiro - Porto Alegre";


                }
                ArrayAdapter<String> adapterCidade = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,voo);
                Spinner voos ;
                voos = (Spinner) findViewById(R.id.spvoo);
                voos.setAdapter(adapterCidade);

            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_voo, menu);
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
}
