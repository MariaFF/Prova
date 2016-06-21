package com.example.maria.prova.maus_tratos;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.prova.MainActivity;
import com.example.maria.prova.R;
import com.example.maria.prova.modelo.MausTratos;
import com.example.maria.prova.util.EditTextTelefone;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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

        this.ed_descAnimal = (EditText) findViewById(R.id.maus_tratos_desc);
        this.ed_cidadeAnimal = (EditText) findViewById(R.id.maus_tratos_cidade_animal);
        this.ed_longitude = (EditText) findViewById(R.id.maus_tratos_longitude);
        this.ed_altitude = (EditText) findViewById(R.id.maus_tratos_altitude);

        this.ed_nomeContato = (EditText) findViewById(R.id.maus_tratos_nome_contato);
        this.ed_telefone = (EditText) findViewById(R.id.maus_tratos_telefone);

        if(getIntent().hasExtra("idMausTratos")){
            Bundle bundle = getIntent().getExtras();
            Long id = bundle.getLong("idMausTratos");
            mausTratos = (MausTratos) MausTratos.findById(MausTratos.class, id);
            setMausTratos(mausTratos);
        }


    }

    public void cadastrarMausTratos(View view){
        if(mausTratos.getId() == null) {
            if (!TextUtils.isEmpty(ed_altitude.getText().toString())) {
                if (!TextUtils.isEmpty(ed_longitude.getText().toString())) {
                    mausTratos.setDescricaoAnimal(ed_descAnimal.getText().toString());
                    mausTratos.setCidadeAnimal(ed_cidadeAnimal.getText().toString());
                    mausTratos.setLongitude(ed_longitude.getText().toString());
                    mausTratos.setAltitude(ed_altitude.getText().toString());

                    mausTratos.setNome(ed_nomeContato.getText().toString());
                    mausTratos.setTelefone(ed_telefone.getText().toString());
                    mausTratos.save();

                    passarDadosWebServiceMausTratos(
                            ed_nomeContato.getText().toString(),
                            ed_telefone.getText().toString(),

                            ed_descAnimal.getText().toString(),
                            ed_cidadeAnimal.getText().toString(),
                            ed_longitude.getText().toString(),
                            ed_altitude.getText().toString()
                    );

                    Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ListaMausTratos.class);
                    startActivity(intent);
                    finish();

                } else {
                    //LONGITUDE
                    ed_longitude.requestFocus();
                    ed_longitude.setError("Por favor preencha campo Longitude");
                }
            } else {
                //ALTITUDE
                ed_altitude.requestFocus();
                ed_altitude.setError("Por favor preencha campo Altitude");
            }
            //ALTERAR
        }else{
            if (!TextUtils.isEmpty(ed_altitude.getText().toString())) {
                if (!TextUtils.isEmpty(ed_longitude.getText().toString())) {
                    mausTratos.setDescricaoAnimal(ed_descAnimal.getText().toString());
                    mausTratos.setCidadeAnimal(ed_cidadeAnimal.getText().toString());
                    mausTratos.setLongitude(ed_longitude.getText().toString());
                    mausTratos.setAltitude(ed_altitude.getText().toString());

                    mausTratos.setNome(ed_nomeContato.getText().toString());
                    mausTratos.setTelefone(ed_telefone.getText().toString());
                    mausTratos.save();

                    passarDadosWebServiceMausTratos(
                            ed_nomeContato.getText().toString(),
                            ed_telefone.getText().toString(),

                            ed_descAnimal.getText().toString(),
                            ed_cidadeAnimal.getText().toString(),
                            ed_longitude.getText().toString(),
                            ed_altitude.getText().toString()
                    );

                    Toast.makeText(this, "Alterado com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ListaMausTratos.class);
                    startActivity(intent);
                    finish();

                } else {
                    //LONGITUDE
                    ed_longitude.requestFocus();
                    ed_longitude.setError("Por favor preencha campo Longitude");
                }
            } else {
                //ALTITUDE
                ed_altitude.requestFocus();
                ed_altitude.setError("Por favor preencha campo Altitude");
            }

        }

    }

    public void cancelarMausTratos(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    private void passarDadosWebServiceMausTratos(
            String nome,
            String telefone,

            String descricaoAnimal,
            String cidadeAnimal,
            String longitude,
            String altitude) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//endereço ip
        String myurl = "http://192.168.56.1:8080/ServicoWeb/resource/WebService/salvarAdocao";
        String POST_PARAMS =
                "nome=" + nome+
                "&telefone=" + telefone +

                "&descricao=" + descricaoAnimal +
                "&cidadeAnimal=" + cidadeAnimal +
                "&longitude=" + longitude +
                "&altitude=" + altitude;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            OutputStream os = conn.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            conn.connect();
            int response = conn.getResponseCode();
            Log.i("MainActivity", "The response is: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMausTratos(MausTratos mausTratos) {
        this.mausTratos = mausTratos;
        ed_nomeContato.setText(mausTratos.getNome());
        ed_telefone.setText(mausTratos.getTelefone());

        ed_descAnimal.setText(mausTratos.getDescricaoAnimal());
        ed_cidadeAnimal.setText(mausTratos.getCidadeAnimal());
        ed_longitude.setText(mausTratos.getLongitude());
        ed_altitude.setText(mausTratos.getAltitude());

    }
}
