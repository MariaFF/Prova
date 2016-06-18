package com.example.maria.prova.modelo;

import com.orm.SugarRecord;

/**
 * Created by maria on 13/06/2016.
 */
public class MausTratos extends SugarRecord {

    private String nome;
    private String telefone;

    private String descricaoAnimal;
    private String cidadeAnimal;
    private String longitude;
    private String altitude;


    public MausTratos() {
    }

    public MausTratos(String nome, String telefone, String descricaoAnimal, String cidadeAnimal, String longitude, String altitude) {
        this.nome = nome;
        this.telefone = telefone;
        this.descricaoAnimal = descricaoAnimal;
        this.cidadeAnimal = cidadeAnimal;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricaoAnimal() {
        return descricaoAnimal;
    }

    public void setDescricaoAnimal(String descricaoAnimal) {
        this.descricaoAnimal = descricaoAnimal;
    }

    public String getCidadeAnimal() {
        return cidadeAnimal;
    }

    public void setCidadeAnimal(String cidadeAnimal) {
        this.cidadeAnimal = cidadeAnimal;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude= altitude;
    }
}
