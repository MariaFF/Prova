package com.example.maria.prova.adocao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maria.prova.MainActivity;
import com.example.maria.prova.R;
import com.example.maria.prova.adapter.AdapterAdocao;
import com.example.maria.prova.modelo.Adocao;

import java.util.ArrayList;
import java.util.List;

public class ListaAdocao extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private AdapterAdocao adapterAdocao;
    private Adocao adocao;

    private List<Adocao> listaAdocao = new ArrayList<>();
    private ListView listViewAdocao;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adocao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listViewAdocao = (ListView) findViewById(R.id.listView_adocao);
       preencherListaAdocao();
        listViewAdocao.setOnItemClickListener(this);
    }

    public void preencherListaAdocao(){
        adapterAdocao = new AdapterAdocao(Adocao.listAll(Adocao.class), this);
        listViewAdocao.setAdapter(adapterAdocao);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Long idAdocao = adapterAdocao.getItemId(position);

        bundle = new Bundle();
        bundle.putLong("idAdocao", idAdocao);

    }

    public void alterarAdocao(View view){
        Intent intent = new Intent(this, CadastrarAdocao.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void excluirMausTratos(View view){
        Long id = bundle.getLong("idAdocao");
        adocao = (Adocao) Adocao.findById(Adocao.class, id);
        adocao.delete();
        preencherListaAdocao();
    }

    public void voltarInicioAdocao(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume(){
        super.onResume();
        preencherListaAdocao();
    }
}
