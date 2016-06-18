package com.example.maria.prova.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maria.prova.R;
import com.example.maria.prova.modelo.MausTratos;

import java.util.List;

/**
 * Created by maria on 13/06/2016.
 */
public class AdapterMausTratos extends BaseAdapter {
    private List<MausTratos> listaMausTratos;
    private Activity activity;

    public AdapterMausTratos(List<MausTratos> listaMausTratos, Activity activity) {
        this.listaMausTratos = listaMausTratos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaMausTratos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMausTratos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaMausTratos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_maus_tratos, parent, false);

        MausTratos mausTratos = listaMausTratos.get(position);

        TextView tx_descAnimal = (TextView) view.findViewById(R.id.lista_maus_tratos_desc);
        tx_descAnimal.setText(mausTratos.getDescricaoAnimal());

        TextView tx_cidade = (TextView) view.findViewById(R.id.lista_maus_tratos_cidade);
        tx_cidade.setText(mausTratos.getCidadeAnimal());

        return view;
    }
}
