package com.example.maria.prova.adocao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.maria.prova.R;
import com.example.maria.prova.adapter.AdapterAdocao;
import com.example.maria.prova.modelo.Adocao;

import java.util.ArrayList;
import java.util.List;

public class ListaAdocao extends AppCompatActivity {
    private AdapterAdocao adapterAdocao;
    private List<Adocao> listaAdocao = new ArrayList<>();
    private ListView listViewAdocao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adocao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listViewAdocao = (ListView) findViewById(R.id.listView_adocao);
       preencherListaAdocao();
    }

    public void preencherListaAdocao(){
        adapterAdocao = new AdapterAdocao(Adocao.listAll(Adocao.class), this);
        listViewAdocao.setAdapter(adapterAdocao);

    }

}
