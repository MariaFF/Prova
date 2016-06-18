package com.example.maria.prova.modelo;

import com.orm.SugarRecord;

/**
 * Created by maria on 14/06/2016.
 */
public class Adocao extends SugarRecord {

    private String nomeAnunciante;
    private String cpf;
    private String telefone;
    private String endereco;
    private String numCasa;

    private String nomeAnimal;
    private String descricaoAnimal;
    private String especie;
    private String porte;
    private String peso;
    private String pelagem;
    private String raca;
    private Boolean sexo;
    private Boolean castrado;
    private Double idade;

    public Adocao() {
    }

    public Adocao(String nomeAnunciante, String cpf, String telefone, String endereco, String numCasa,
                  String nomeAnimal, String descricaoAnimal, String especie, String porte, String peso,
                  String pelagem, String raca, Boolean sexo, Boolean castrado, Double idade) {
        this.nomeAnunciante = nomeAnunciante;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numCasa = numCasa;
        this.nomeAnimal = nomeAnimal;
        this.descricaoAnimal = descricaoAnimal;
        this.especie = especie;
        this.porte = porte;
        this.peso = peso;
        this.pelagem = pelagem;
        this.raca = raca;
        this.sexo = sexo;
        this.castrado = castrado;
        this.idade = idade;
    }

    public String getNomeAnunciante() {
        return nomeAnunciante;
    }

    public void setNomeAnunciante(String nomeAnunciante) {
        this.nomeAnunciante = nomeAnunciante;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getDescricaoAnimal() {
        return descricaoAnimal;
    }

    public void setDescricaoAnimal(String descricaoAnimal) {
        this.descricaoAnimal = descricaoAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }
}
