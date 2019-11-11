package com.example.theaudiodb.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theaudiodb.R;
import com.example.theaudiodb.model.Album;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Album> albums;

    public RecyclerViewAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = this.albums.get(position);
        holder.onBind(album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    //Método que atualiza a lista
    public void setUpdate(List<Album> albums) {

        //Se a lista for vazia ele adiciona na lista vazia os valores da lista de dados que está chegando
        if (this.albums.isEmpty()){
            this.albums = albums;
        }else {
            //Se a lista não for vazia e já possuir dados nós adicionamos nessa lista os novos dados que estão chegando em sequencia
            //ou seja logo após o ultimo item da lista adicionamos os novos dados em sequencia como se fosse uma fila
            this.albums.addAll(albums);
        }
        //No final notificamos as mudanças acontecidas
        notifyDataSetChanged();
    }

    public void clear(){
        this.albums.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgFilme);
            titulo = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Album album) {
            titulo.setText(album.getStrAlbum());
            Picasso.get().load(album.getStrAlbumThumb()).into(img);
        }
    }
}
