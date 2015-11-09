package com.example.borja.aplicacionloteria;

/**
 * Created by Borja on 10/10/2015.
 */
public class Boleto {
    private String numero;
    private String serie;
    private String tipo;

    public Boleto(String numero, String serie, String tipo) {
        this.numero = numero;
        this.serie = serie;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public String getSerie() {
        return serie;
    }

    public String getTipo() {
        return tipo;
    }

}
