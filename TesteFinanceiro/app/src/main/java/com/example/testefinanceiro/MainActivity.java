package com.example.testefinanceiro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.testefinanceiro.servidor.TesteServidor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Sistema de Controle de Filmes");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastro();


                //Snackbar.make(view, "Alterar valor do texto.", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });


        // Configurar RecyclerView
        recyclerView = findViewById( R.id.recyclerView );


        /*

        // Listagem de Filmes
        listaFilmes.add( new Filme("O Poderoso Chefão","2019"));
        listaFilmes.add( new Filme("Perfume de Mulher","1977"));
        listaFilmes.add( new Filme("Senhor dos Anéis", "1982"));


        DadosOpenHelper dadosOpenHelper = new DadosOpenHelper( this );
        SQLiteDatabase conexao = dadosOpenHelper.getReadableDatabase();

        FilmeRepositorio filmeRepositorio = new FilmeRepositorio( conexao );

        List<Filme> lista;
        lista = filmeRepositorio.buscarTodos();

        for ( int i=0; i < lista.size(); i++ ) {
            listaFilmes.add( lista.get(i));
        }


        // Fixar para melhorar o desempenho
        recyclerView.setHasFixedSize( true );


        // Configurar Adapter
        AdapterTeste adapterTeste = new AdapterTeste( listaFilmes );

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL ) );
        recyclerView.setAdapter( adapterTeste );

        // Evento de Click

        recyclerView.addOnItemTouchListener(

                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get( position );

                                Toast.makeText( getApplicationContext(), "Item Pressionado " + filme.getTitulo(),Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText( getApplicationContext(), "Click Longo",Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }

                )
        );

         */

        preencherListaFilmes();

        TesteServidor testeServidor = new TesteServidor();

        testeServidor.obterDadosServidor();








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void abrirCadastro() {
        Intent intent = new Intent( this, ActCadFilme.class );
        startActivity( intent );

    }

    public void preencherListaFilmes() {

        // Listagem de Filmes
        listaFilmes.add( new Filme(1,"O Poderoso Chefão","2019"));
        listaFilmes.add( new Filme(2,"Perfume de Mulher","1977"));
        listaFilmes.add( new Filme(3,"Senhor dos Anéis", "1982"));


        DadosOpenHelper dadosOpenHelper = new DadosOpenHelper( this );
        SQLiteDatabase conexao = dadosOpenHelper.getReadableDatabase();

        FilmeRepositorio filmeRepositorio = new FilmeRepositorio( conexao );

        List<Filme> lista;
        lista = filmeRepositorio.buscarTodos();

        for ( int i=0; i < lista.size(); i++ ) {
            listaFilmes.add( lista.get(i));
        }


        // Fixar para melhorar o desempenho
        recyclerView.setHasFixedSize( true );


        // Configurar Adapter
        AdapterTeste adapterTeste = new AdapterTeste( listaFilmes );

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL ) );
        recyclerView.setAdapter( adapterTeste );

        // Evento de Click

        recyclerView.addOnItemTouchListener(

                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get( position );

                                Toast.makeText( getApplicationContext(), "Item Pressionado " + filme.getTitulo(),Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText( getApplicationContext(), "Click Longo",Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }

                )
        );



    }


    public void chamarTelaCadastro( View view ) {

        abrirCadastro();

    }



}
