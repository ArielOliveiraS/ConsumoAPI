package com.example.desafiomarvelapi.view.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafiomarvelapi.R;
import com.example.desafiomarvelapi.model.characters.Result;
import com.example.desafiomarvelapi.viewmodel.MarvelViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class DetalheImagemActivity extends AppCompatActivity {

    private ImageView imagem = null;
    private TextView txtTitulo = null;
    private TextView txtDescricao = null;
    private TextView txtPreco = null;
    private long idPersonagem;
    private MarvelViewModel viewModel;
    private List<com.example.desafiomarvelapi.model.comicsid.Result> listaResult = new ArrayList<>();
    private double max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_imagem);

        initViews();

        Result result = getIntent().getParcelableExtra("Result");
        Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imagem);
        idPersonagem =  result.getId();

//        https://gateway.marvel.com:443/v1/public/characters/+ idPersonagem +/comics?apikey=939a0aa82c5e5eb59b9f101ee831d037


        viewModel.getComics(idPersonagem);

        for (int i = 0; i <listaResult.size() ; i++) {
            Log.e("Comics", String.valueOf(listaResult.size()));
        }

//        Observable.range(0, listaResult.size())
//                .map()


    }

    private void initViews() {
        imagem = findViewById(R.id.imgDetalhe);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricaoHq);
        txtPreco = findViewById(R.id.txtPrecoHq);
    }


}
