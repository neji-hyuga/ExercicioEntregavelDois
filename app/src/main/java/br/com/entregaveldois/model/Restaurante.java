package br.com.entregaveldois.model;


import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Restaurante implements Serializable {

    private int fotoRestaurante;
    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioRestaurante;

    public int getFotoRestaurante() {
        return fotoRestaurante;
    }

    public void setFotoRestaurante(int fotoRestaurante) {
        this.fotoRestaurante = fotoRestaurante;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getEnderecoRestaurante() {
        return enderecoRestaurante;
    }

    public void setEnderecoRestaurante(String enderecoRestaurante) {
        this.enderecoRestaurante = enderecoRestaurante;
    }

    public String getHorarioRestaurante() {
        return horarioRestaurante;
    }

    public void setHorarioRestaurante(String horarioRestaurante) {
        this.horarioRestaurante = horarioRestaurante;
    }
}
