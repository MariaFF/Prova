package com.example.maria.prova.maus_tratos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.prova.MainActivity;
import com.example.maria.prova.R;
import com.example.maria.prova.modelo.MausTratos;
import com.example.maria.prova.util.EditTextTelefone;

public class CadastrarMausTratos extends AppCompatActivity {

    private MausTratos mausTratos = new MausTratos();
    private EditText ed_descAnimal = null;
    private EditText ed_cidadeAnimal = null;
    private EditText ed_longitude = null;
    private EditText ed_altitude= null;

    private EditText ed_nomeContato = null;
    private EditText ed_telefone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_maus_tratos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ed_descAnimal = (EditText) findViewById(R.id.maus_tratos_desc);
        ed_cidadeAnimal = (EditText) findViewById(R.id.maus_tratos_cidade_animal);
        ed_longitude = (EditText) findViewById(R.id.maus_tratos_longitude);
        ed_altitude = (EditText) findViewById(R.id.maus_tratos_altitude);

        ed_nomeContato = (EditText) findViewById(R.id.maus_tratos_nome_contato);
        ed_telefone = (EditText) findViewById(R.id.maus_tratos_telefone);


    }

    public void cadastrarMausTratos(View view){
        if(!TextUtils.isEmpty(ed_altitude.getText().toString())){
            if (!TextUtils.isEmpty(ed_longitude.getText().toString())){
                mausTratos.setDescricaoAnimal(ed_descAnimal.getText().toString());
                mausTratos.setCidadeAnimal(ed_cidadeAnimal.getText().toString());
                mausTratos.setLongitude(ed_longitude.getText().toString());
                mausTratos.setAltitude(ed_altitude.getText().toString());

                mausTratos.setNome(ed_nomeContato.getText().toString());
                mausTratos.setTelefone(ed_telefone.getText().toString());
                mausTratos.save();

                Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ListaMausTratos.class);
                startActivity(intent);
                finish();

            }else {
                //LONGITUDE
                ed_longitude.requestFocus();
                ed_longitude.setError("Por favor preencha campo Longitude");
            }
        }else {
            //ALTITUDE
            ed_altitude.requestFocus();
            ed_altitude.setError("Por favor preencha campo Altitude");
        }

    }

    public void cancelarMausTratos(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
