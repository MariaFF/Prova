package com.example.maria.prova.adocao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.maria.prova.MainActivity;
import com.example.maria.prova.R;
import com.example.maria.prova.modelo.Adocao;
import com.example.maria.prova.util.EditTextTelefone;

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
    private RadioButton rb_sexo;
    private RadioButton rb_castrado;



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



    }

    public void cadastrarAdocao(View view){
        if(!TextUtils.isEmpty(ed_nomeAnunciante.getText().toString())){
            if(!TextUtils.isEmpty(ed_telefone.getText().toString())){
                if(!TextUtils.isEmpty(ed_descAnimal.getText().toString())){
                    adocao.setNomeAnunciante(ed_nomeAnunciante.getText().toString());
                    adocao.setCpf(ed_cpf.getText().toString());
                    adocao.setTelefone(ed_telefone.getText().toString());
                    adocao.setEndereco(ed_endereco.getText().toString());
                    adocao.setNumCasa(ed_numCasa.getText().toString());

                    adocao.setDescricaoAnimal(ed_descAnimal.getText().toString());
                    adocao.setEspecie(ed_especie.getText().toString());
                    adocao.setPorte(ed_porte.getText().toString());
                    adocao.setPeso(ed_peso.getText().toString());
                    adocao.setIdade(Double.valueOf(ed_idade.getText().toString()));
                    adocao.setPelagem(ed_pelagem.getText().toString());
                    adocao.setRaca(ed_raca.getText().toString());
                    adocao.save();

                }else {
                    ed_descAnimal.requestFocus();
                    ed_descAnimal.setError("Preencha campo Descrição Animal");
                }
            }else {
                ed_telefone.requestFocus();
                ed_telefone.setError("Preencha campo telefone");
            }
        }else {
            ed_nomeAnunciante.requestFocus();
            ed_nomeAnunciante.setError("Preencha o campo nome");
        }



    }

    public void cancelarAdocao(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
