package com.example.consumoapimarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumoapimarvel.R;
import com.example.consumoapimarvel.model.Result;
import com.example.consumoapimarvel.view.interfaces.OnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewHqAdapter extends RecyclerView.Adapter<RecyclerViewHqAdapter.ViewHolder> {

    private List<Result> resultList;
    private OnClick listener;

    public RecyclerViewHqAdapter(List<Result> resultList, OnClick listener) {
        this.resultList = resultList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(v -> listener.click(result));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public void atualizaLista(List<Result> novaLista){
        if(this.resultList.isEmpty()){
            this.resultList = novaLista;
        }else{
            this.resultList.addAll(novaLista);
        }

        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.itemImgHq);
            textView = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Result result) {
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imageView);
            //Picasso.get().load(result.getThumbnail().getPath() + "/detail." + result.getThumbnail().getExtension());
            textView.setText(result.getTitle());
        }
    }
}
