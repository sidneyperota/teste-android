package com.example.folha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCliente extends RecyclerView.Adapter<AdapterCliente.MyViewHolder> {

    private List<Cliente> listarClientes;


    public AdapterCliente(List<Cliente> lista ) {

        this.listarClientes = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView endereco;
        TextView telefone;
        TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome  = itemView.findViewById( R.id.edtNome );
            endereco = itemView.findViewById( R.id.edtEndereco );
            telefone = itemView.findViewById( R.id.edtTelefone );
            email = itemView.findViewById( R.id.edtEmail );
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from( parent.getContext() ).inflate(  R.layout.adapter_lista, parent, false );

        return new MyViewHolder( itemLista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get( position );

        holder.titulo.setText( filme.getTitulo() );
        holder.ano.setText( filme.getAno() );
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }
}
