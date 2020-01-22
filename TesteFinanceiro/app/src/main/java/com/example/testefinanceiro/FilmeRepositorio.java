package com.example.testefinanceiro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepositorio {

    private SQLiteDatabase conexao;


    public FilmeRepositorio( SQLiteDatabase conexao ) {
        this.conexao = conexao;
    }

    public void inserir( Filme filme ) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", filme.getTitulo() );
        contentValues.put("ano", filme.getAno() );
        conexao.insertOrThrow("filme", null, contentValues );
    }


    public void excluir ( int codigo ) {

        String[] parametros = new String[1];
        parametros[0] = String.valueOf( codigo );

        conexao.delete("filme", "codigo = ?", parametros );
    }

    public void alterar( Filme filme ) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", filme.getTitulo() );
        contentValues.put("ano", filme.getAno() );
        String[] parametros = new String[1];
        parametros[0] = String.valueOf( filme.getCodigo() );

        conexao.update("filme", contentValues, "codigo=?", parametros );

    }

    public List<Filme> buscarTodos() {

        List<Filme> filmes = new ArrayList<Filme>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, titulo, ano");
        sql.append(" FROM filme");

        Cursor cursor = conexao.rawQuery(sql.toString(), null );

        if ( cursor.getCount() > 0 ) {
            cursor.moveToFirst();

            do {
                Filme filme = new Filme();
                filme.setCodigo( cursor.getInt(  cursor.getColumnIndexOrThrow("codigo") )  );
                filme.setTitulo( cursor.getString( cursor.getColumnIndexOrThrow( "titulo") ) );
                filme.setAno( cursor.getString( cursor.getColumnIndexOrThrow("ano")));
                filmes.add( filme );

            } while(cursor.moveToNext());

        }

        return filmes;
    }


    public Filme buscarFilme( int codigo ) {

        Filme filme = new Filme();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, titulo, ano ");
        sql.append("FROM filme ");
        sql.append("WHERE codigo = ?");
        String[] parametros = new String[1];
        parametros[0] = String.valueOf( codigo );

        Cursor resultado = conexao.rawQuery( sql.toString(), parametros );

        if ( resultado.getCount() > 0 ) {

            filme.setCodigo(resultado.getInt(resultado.getColumnIndexOrThrow("codigo")));
            filme.setTitulo(resultado.getString(resultado.getColumnIndexOrThrow("titulo")));
            filme.setAno(resultado.getString(resultado.getColumnIndexOrThrow("ano")));
            return filme;
        }

        return null;

    }

}
