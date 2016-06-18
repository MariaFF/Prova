package com.example.maria.prova.maus_tratos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.maria.prova.R;
import com.example.maria.prova.adapter.AdapterMausTratos;
import com.example.maria.prova.modelo.MausTratos;

import java.util.ArrayList;
import java.util.List;

public class ListaMausTratos extends AppCompatActivity {

    private AdapterMausTratos adapterMausTratos;
    private MausTratos mausTratos;
    private CadastrarMausTratos cadastrarMausTratos;

    private List<MausTratos> listaMausTratos = new ArrayList<>();
    private ListView listaViewMausTratos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_maus_tratos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaViewMausTratos = (ListView) findViewById(R.id.maus_tratos_listView);
        preecherListaMausTratos();


    }


    public void preecherListaMausTratos(){
        adapterMausTratos = new AdapterMausTratos(MausTratos.listAll(MausTratos.class), this);
        listaViewMausTratos.setAdapter(adapterMausTratos);
    }

}
