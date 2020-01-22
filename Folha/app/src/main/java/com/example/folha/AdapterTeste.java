package com.example.folha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTeste extends RecyclerView.Adapter<AdapterTeste.MyViewHolder> {

    private List<Filme> listaFilmes;


    public AdapterTeste(List<Filme> lista ) {
        this.listaFilmes = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById( R.id.txt_titulo );
            ano   = itemView.findViewById( R.id.txt_ano );


        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from( parent.getContext() ).inflate( R.layout.adapter_lista, parent, false );

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
