package com.example.testefinanceiro;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ActCadFilme extends AppCompatActivity {

    private TextView titulo;
    private TextView ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cad_filme);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Cadastro de Filmes");

        titulo = findViewById(R.id.txt_titulo );
        ano =    findViewById(R.id.txt_ano );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cadastrado com sucesso!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                cadastrar();
            }
        });


    }

    private void cadastrar() {


        DadosOpenHelper dadosOpenHelper = new DadosOpenHelper(this );
        SQLiteDatabase conexao;
        conexao = dadosOpenHelper.getWritableDatabase();

        conexao.execSQL( ScriptDLL.getCreateTableFilme() );

        FilmeRepositorio filmeRepositorio = new FilmeRepositorio( conexao );

        Filme filme = new  Filme();
        filme.setTitulo( titulo.getText().toString() );
        filme.setAno( ano.getText().toString() );
        filmeRepositorio.inserir( filme );

        titulo.setText("");
        ano.setText("");

    }

}
