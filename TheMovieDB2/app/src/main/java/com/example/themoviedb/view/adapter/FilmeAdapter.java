package com.example.themoviedb.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themoviedb.R;
import com.example.themoviedb.model.Result;
import com.example.themoviedb.view.interfaces.OnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {

    private List<Result> resultList;
    private OnClick listener;

    public FilmeAdapter(List<Result> resultList, OnClick listener) {
        this.resultList = resultList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeAdapter.ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(v -> listener.click(result));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    //Método que atualiza a lista
    public void atualizaLista(List<Result> novaLista){
        //Se a lista for vazia ele adiciona na lista vazia os valores da lista de dados que está chegando
        if (this.resultList.isEmpty()){
            this.resultList = novaLista;
        }else{
            //Se a lista não for vazia e já possuir dados nós adicionamos nessa lista os novos dados que estão chegando em sequencia
            //ou seja logo após o ultimo item da lista adicionamos os novos dados em sequencia como se fosse uma fila
            this.resultList.addAll(novaLista);
        }
        //No final notificamos as mudanças acontecidas
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFilme);
            textView = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Result result) {
            textView.setText(result.getTitle());

            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+ result.getPosterPath()).into(imageView);
        }
    }
}
