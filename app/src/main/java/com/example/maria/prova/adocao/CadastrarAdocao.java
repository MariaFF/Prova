package com.example.maria.prova.adocao;

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
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.maria.prova.MainActivity;
import com.example.maria.prova.R;
import com.example.maria.prova.modelo.Adocao;
import com.example.maria.prova.util.EditTextTelefone;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastrarAdocao extends AppCompatActivity {

    private Adocao adocao;
    private EditText ed_nomeAnunciante;
    private EditText ed_cpf;
    private EditText ed_telefone;
    private EditText ed_endereco;
    private EditText ed_numCasa;

    private EditText ed_nomeAnimal;
    private EditText ed_descAnimal;
    private EditText ed_especie;
    private EditText ed_porte;
    private EditText ed_peso;
    private EditText ed_idade;
    private EditText ed_pelagem;
    private EditText ed_raca;
    private EditText ed_sexo;
    private EditText ed_castrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_adocao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adocao = new Adocao();
        this.ed_nomeAnunciante = (EditText) findViewById(R.id.adocao_nome);
        this.ed_cpf = (EditText) findViewById(R.id.cpf);
        this.ed_telefone = (EditText) findViewById(R.id.telefone);
        this.ed_endereco = (EditText) findViewById(R.id.endereco);
        this.ed_numCasa = (EditText) findViewById(R.id.numero_casa);

        this.ed_nomeAnimal = (EditText) findViewById(R.id.adocao_nome_animal);
        this.ed_descAnimal = (EditText) findViewById(R.id.desc);
        this.ed_especie = (EditText) findViewById(R.id.especie);
        this.ed_porte = (EditText) findViewById(R.id.porte);
        this.ed_peso = (EditText) findViewById(R.id.peso);
        this.ed_idade = (EditText) findViewById(R.id.idade);
        this.ed_pelagem = (EditText) findViewById(R.id.pelagem);
        this.ed_raca = (EditText) findViewById(R.id.raca);
        this.ed_sexo = (EditText) findViewById(R.id.sexo);
        this.ed_castrado = (EditText) findViewById(R.id.castrado);

        if(getIntent().hasExtra("idAdocao")){
            Bundle bundle = getIntent().getExtras();
            Long id = bundle.getLong("idAdocao");
            adocao = (Adocao) Adocao.findById(Adocao.class, id);
            setAdocao(adocao);
        }


    }

    public void cadastrarAdocao(View view) {
        if(adocao.getId() == null) {
            if (!TextUtils.isEmpty(ed_nomeAnunciante.getText().toString())) {
                if (!TextUtils.isEmpty(ed_telefone.getText().toString())) {
                    if (!TextUtils.isEmpty(ed_descAnimal.getText().toString())) {
                        adocao.setNomeAnunciante(ed_nomeAnunciante.getText().toString());
                        adocao.setCpf(ed_cpf.getText().toString());
                        adocao.setTelefone(ed_telefone.getText().toString());
                        adocao.setEndereco(ed_endereco.getText().toString());
                        adocao.setNumCasa(ed_numCasa.getText().toString());

                        adocao.setNomeAnimal(ed_nomeAnimal.getText().toString());
                        adocao.setDescricaoAnimal(ed_descAnimal.getText().toString());
                        adocao.setEspecie(ed_especie.getText().toString());
                        adocao.setPorte(ed_porte.getText().toString());
                        adocao.setPeso(ed_peso.getText().toString());
                        adocao.setPelagem(ed_pelagem.getText().toString());
                        adocao.setRaca(ed_raca.getText().toString());
                        adocao.setSexo(ed_sexo.getText().toString());
                        adocao.setCastrado(ed_castrado.getText().toString());
                        adocao.setIdade(Integer.valueOf(ed_idade.getText().toString()));
                        adocao.save();
                        passarDadosWebServiceAdocao(
                                ed_nomeAnunciante.getText().toString(),
                                ed_cpf.getText().toString(),
                                ed_telefone.getText().toString(),
                                ed_endereco.getText().toString(),
                                ed_numCasa.getText().toString(),
                                ed_nomeAnimal.getText().toString(),
                                ed_descAnimal.getText().toString(),
                                ed_especie.getText().toString(),
                                ed_porte.getText().toString(),
                                ed_peso.getText().toString(),
                                ed_pelagem.getText().toString(),
                                ed_raca.getText().toString(),
                                ed_sexo.getText().toString(),
                                ed_castrado.getText().toString(),
                                Integer.valueOf(ed_idade.getText().toString()));


                    } else {
                        ed_descAnimal.requestFocus();
                        ed_descAnimal.setError("Preencha campo Descrição Animal");
                    }
                } else {
                    ed_telefone.requestFocus();
                    ed_telefone.setError("Preencha campo telefone");
                }
            } else {
                ed_nomeAnunciante.requestFocus();
                ed_nomeAnunciante.setError("Preencha o campo nome");
            }
            //ALTERAR
        }else{
            if (!TextUtils.isEmpty(ed_nomeAnunciante.getText().toString())) {
                if (!TextUtils.isEmpty(ed_telefone.getText().toString())) {
                    if (!TextUtils.isEmpty(ed_descAnimal.getText().toString())) {
                        adocao.setNomeAnunciante(ed_nomeAnunciante.getText().toString());
                        adocao.setCpf(ed_cpf.getText().toString());
                        adocao.setTelefone(ed_telefone.getText().toString());
                        adocao.setEndereco(ed_endereco.getText().toString());
                        adocao.setNumCasa(ed_numCasa.getText().toString());

                        adocao.setNomeAnimal(ed_nomeAnimal.getText().toString());
                        adocao.setDescricaoAnimal(ed_descAnimal.getText().toString());
                        adocao.setEspecie(ed_especie.getText().toString());
                        adocao.setPorte(ed_porte.getText().toString());
                        adocao.setPeso(ed_peso.getText().toString());
                        adocao.setPelagem(ed_pelagem.getText().toString());
                        adocao.setRaca(ed_raca.getText().toString());
                        adocao.setSexo(ed_sexo.getText().toString());
                        adocao.setCastrado(ed_castrado.getText().toString());
                        adocao.setIdade(Integer.valueOf(ed_idade.getText().toString()));
                        adocao.save();
                        passarDadosWebServiceAdocao(
                                ed_nomeAnunciante.getText().toString(),
                                ed_cpf.getText().toString(),
                                ed_telefone.getText().toString(),
                                ed_endereco.getText().toString(),
                                ed_numCasa.getText().toString(),
                                ed_nomeAnimal.getText().toString(),
                                ed_descAnimal.getText().toString(),
                                ed_especie.getText().toString(),
                                ed_porte.getText().toString(),
                                ed_peso.getText().toString(),
                                ed_pelagem.getText().toString(),
                                ed_raca.getText().toString(),
                                ed_sexo.getText().toString(),
                                ed_castrado.getText().toString(),
                                Integer.valueOf(ed_idade.getText().toString()));


                    } else {
                        ed_descAnimal.requestFocus();
                        ed_descAnimal.setError("Preencha campo Descrição Animal");
                    }
                } else {
                    ed_telefone.requestFocus();
                    ed_telefone.setError("Preencha campo telefone");
                }
            } else {
                ed_nomeAnunciante.requestFocus();
                ed_nomeAnunciante.setError("Preencha o campo nome");
            }
        }

    }



    public void cancelarAdocao(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    private void passarDadosWebServiceAdocao(
            String nomeAnunciante,
            String cpf,
            String telefone,
            String endereco,
            String numCasa,

            String nomeAnimal,
            String descricaoAnimal,
            String especie,
            String porte,
            String peso,
            String pelagem,
            String raca,
            String sexo,
            String castrado,
            Integer idade

    ) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//endereço ip
        String myurl = "http://192.168.56.1:8080/ServicoWeb/resource/WebService/salvarAdocao";
        String POST_PARAMS = "nomeAnunciante=" + nomeAnunciante +
                "&cpf=" + cpf +
                "&telefone=" + telefone +
                "&endereco=" + endereco +
                "&numCasa=" + numCasa +
                "&nomeAnimal=" + nomeAnimal +
                "&descricaoAnimal=" + descricaoAnimal +
                "&especie=" + especie +
                "&porte=" + porte +
                "&peso=" + peso +
                "&pelagem=" + pelagem +
                "&raca=" + raca +
                "&sexo=" + sexo +
                "&castrado=" + castrado +
                "&idade=" + idade;

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

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
        ed_nomeAnunciante.setText(adocao.getNomeAnunciante());
        ed_cpf.setText(adocao.getCpf());
        ed_telefone.setText(adocao.getTelefone());
        ed_endereco.setText(adocao.getTelefone());
        ed_numCasa.setText(adocao.getNumCasa());

        ed_nomeAnimal.setText(adocao.getNomeAnimal());
        ed_descAnimal.setText(adocao.getDescricaoAnimal());
        ed_especie.setText(adocao.getEspecie());
        ed_porte.setText(adocao.getPorte());
        ed_peso.setText(adocao.getPeso());
        ed_pelagem.setText(adocao.getPelagem());
        ed_raca.setText(adocao.getRaca());
        ed_sexo.setText(adocao.getSexo());
        ed_castrado.setText(adocao.getCastrado());
        ed_idade.setText(adocao.getIdade());

    }
}
