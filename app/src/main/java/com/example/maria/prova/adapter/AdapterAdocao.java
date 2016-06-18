package com.example.maria.prova.adapter;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maria.prova.R;
import com.example.maria.prova.modelo.Adocao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maria on 18/06/2016.
 */
public class AdapterAdocao extends BaseAdapter {

    private List<Adocao> listaAdocao = new ArrayList<>();
    private Activity activity;

    public AdapterAdocao(List<Adocao> listaAdocao, Activity activity) {
        this.listaAdocao = listaAdocao;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaAdocao.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAdocao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaAdocao.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_adocao, parent, false);
        Adocao adocao = listaAdocao.get(position);

        TextView tx_nome_animal = (TextView) view.findViewById(R.id.adocao_nome_animal);
        tx_nome_animal.setText(adocao.getNomeAnimal());

        TextView tx_descricao_animal = (TextView) view.findViewById(R.id.adocao_descricao_animal);
        tx_descricao_animal.setText(adocao.getDescricaoAnimal());

        return view;
    }
}
