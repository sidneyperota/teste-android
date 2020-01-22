package com.example.testefinanceiro;

public class Filme {

    private int codigo;
    private String titulo;
    private String ano;


    public Filme() {
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Filme( int codigo, String titulo, String ano) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
