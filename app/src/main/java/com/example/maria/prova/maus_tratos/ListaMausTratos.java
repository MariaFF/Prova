package com.example.maria.prova.maus_tratos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maria.prova.MainActivity;
import com.example.maria.prova.R;
import com.example.maria.prova.adapter.AdapterMausTratos;
import com.example.maria.prova.modelo.MausTratos;

import java.util.ArrayList;
import java.util.List;

public class ListaMausTratos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private AdapterMausTratos adapterMausTratos;
    private MausTratos mausTratos;
    private CadastrarMausTratos cadastrarMausTratos;

    private List<MausTratos> listaMausTratos = new ArrayList<>();
    private ListView listaViewMausTratos;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_maus_tratos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaViewMausTratos = (ListView) findViewById(R.id.maus_tratos_listView);
        preecherListaMausTratos();
        listaViewMausTratos.setOnItemClickListener(this);


    }


    public void preecherListaMausTratos(){
        adapterMausTratos = new AdapterMausTratos(MausTratos.listAll(MausTratos.class), this);
        listaViewMausTratos.setAdapter(adapterMausTratos);
    }

    public void alterarMausTratos(View view){
        Intent intent = new Intent(this, CadastrarMausTratos.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    @Override
    public void onResume(){
        super.onResume();
        preecherListaMausTratos();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Long idMt = adapterMausTratos.getItemId(position);

        bundle = new Bundle();
        bundle.putLong("idMausTratos", idMt);

    }

    public void excluirMausTratos(View view){
        Long id = bundle.getLong("idMausTratos");
        mausTratos = (MausTratos) MausTratos.findById(MausTratos.class, id);
        mausTratos.delete();
        preecherListaMausTratos();
    }

    public void voltarInicioMt(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
