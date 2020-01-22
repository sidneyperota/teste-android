package com.example.folha;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ActCadCliente extends AppCompatActivity {

    private TextView nome;
    private TextView endereco;
    private TextView telefone;
    private TextView  email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cad_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome     = findViewById( R.id.edtNome );
        endereco = findViewById( R.id.edtEndereco );
        telefone = findViewById( R.id.edtTelefone );
        email    = findViewById( R.id.edtEmail );




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cadastrar();

                Snackbar.make(view, "Cadastrado com sucesso!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void cadastrar() {
       Cliente cliente = new Cliente();

       cliente.setNome( nome.getText().toString() );
       cliente.setEmail( email.getText().toString() );
       cliente.setEndereco( endereco.getText().toString() );
       cliente.setTelefone( telefone.getText().toString() );

       SQLiteDatabase conexao;

       DadosOpenHelper dadosOpenHelper = new DadosOpenHelper(this, "bdfinanceiro", null, 1 );

       conexao = dadosOpenHelper.getWritableDatabase();

       ClienteRepositorio clienteRepositorio = new ClienteRepositorio(conexao);

       clienteRepositorio.inserir( cliente );

       nome.setText("");
       email.setText("");
       endereco.setText("");
       telefone.setText("");


    }
}
