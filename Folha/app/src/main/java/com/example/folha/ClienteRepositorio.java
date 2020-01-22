package com.example.folha;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {

    private SQLiteDatabase conexao;


    public ClienteRepositorio( SQLiteDatabase conexao ) {
        this.conexao = conexao;
    }

    public void inserir( Cliente cliente ) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", cliente.getNome() );
        contentValues.put("endereco", cliente.getEndereco() );
        contentValues.put("email", cliente.getEmail() );
        contentValues.put("telefone", cliente.getTelefone() );
        conexao.insertOrThrow("cliente", null, contentValues );
    }


    public void excluir ( int codigo ) {

        String[] parametros = new String[1];
        parametros[0] = String.valueOf( codigo );

        conexao.delete("cliente", "codigo = ?", parametros );
    }

    public void alterar( Cliente cliente ) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", cliente.getNome() );
        contentValues.put("endereco", cliente.getEndereco() );
        contentValues.put("email", cliente.getEmail() );
        contentValues.put("telefone", cliente.getTelefone() );

        String[] parametros = new String[1];
        parametros[0] = String.valueOf( cliente.getCodigo() );

        conexao.update("cliente", contentValues, "codigo = ?", parametros );

    }

    public List<Cliente> buscarTodos() {

        List<Cliente> clientes = new ArrayList<Cliente>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, nome, endereco, email, telefone");
        sql.append(" FROM cliente");

        Cursor cursor = conexao.rawQuery(sql.toString(), null );

        if ( cursor.getCount() > 0 ) {
            cursor.moveToFirst();

            do {
                    Cliente cli = new Cliente();
                    cli.setCodigo( cursor.getInt(  cursor.getColumnIndexOrThrow("codigo") )  );
                    cli.setNome( cursor.getString( cursor.getColumnIndexOrThrow( "nome") ) );
                    cli.setEndereco( cursor.getString( cursor.getColumnIndexOrThrow("endereco")));
                    cli.setEmail( cursor.getString( cursor.getColumnIndexOrThrow( "email")));
                    cli.setTelefone( cursor.getString(cursor.getColumnIndexOrThrow( "telefone")));
                    clientes.add( cli );

            } while(cursor.moveToNext());

        }

        return clientes;
    }


    public Cliente buscarCliente( int codigo ) {

        Cliente cliente = new Cliente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, nome, endereco, email, telefone ");
        sql.append("FROM cliente ");
        sql.append("WHERE codigo = ?");
        String[] parametros = new String[1];
        parametros[0] = String.valueOf( codigo );

        Cursor resultado = conexao.rawQuery( sql.toString(), parametros );

        if ( resultado.getCount() > 0 ) {

            cliente.setCodigo(resultado.getInt(resultado.getColumnIndexOrThrow("codigo")));
            cliente.setNome(resultado.getString(resultado.getColumnIndexOrThrow("nome")));
            cliente.setEndereco(resultado.getString(resultado.getColumnIndexOrThrow("endereco")));
            cliente.setTelefone(resultado.getString(resultado.getColumnIndexOrThrow("telefone")));
            cliente.setEmail(resultado.getString(resultado.getColumnIndexOrThrow("email")));

            return cliente;
        }

        return null;

    }

}
