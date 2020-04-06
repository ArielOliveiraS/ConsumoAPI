package com.example.desafiomarvelapi.view.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafiomarvelapi.R;
import com.example.desafiomarvelapi.model.characters.Result;
import com.example.desafiomarvelapi.model.comicsid.Price;
import com.example.desafiomarvelapi.viewmodel.MarvelViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class DetalheImagemActivity extends AppCompatActivity {

    private ImageView imagem = null;
    private TextView txtTitulo = null;
    private TextView txtDescricao = null;
    private TextView txtPreco = null;
    private Long idPersonagem;
    private MarvelViewModel viewModel;
    private List<com.example.desafiomarvelapi.model.comicsid.Result> listaResult = new ArrayList<>();
    private List<Price> listaPrice = new ArrayList<>();
    private int index = -1;
    private double max ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detalhe_imagem);

            initViews();

            Result result = getIntent().getParcelableExtra("Result");
            idPersonagem =  result.getId();

//        https://gateway.marvel.com:443/v1/public/characters/+ idPersonagem +/comics?apikey=939a0aa82c5e5eb59b9f101ee831d037


            viewModel.getComics(idPersonagem);

            viewModel.getListaComics().observe(this, resultadoLista -> {
                listaResult = resultadoLista;
            });

//            max = Double.parseDouble(listaResult.get(0).getPrices().get(0).getPrice());
            max = 0;

            for( int iCount = 0; iCount < listaResult.size(); iCount++) {
                listaPrice = listaResult.get(iCount).getPrices();

                if( listaPrice.get(iCount).getPrice() > max) {
                    max = listaPrice.get(iCount).getPrice();


                    Picasso.get().load(listaResult.get(iCount).getThumbnail().getPath() + ".jpg").into(imagem);
                    txtTitulo.setText(listaResult.get(iCount).getTitle());
                    txtDescricao.setText(listaResult.get(iCount).getDescription());
                    txtPreco.setText(String.valueOf(max));
                }
            }
        }
        catch (Exception err) {
            Toast.makeText(this, "Erro DetalheImagemActivity" + err.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        imagem = findViewById(R.id.imgDetalhe);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricaoHq);
        txtPreco = findViewById(R.id.txtPrecoHq);
        viewModel = ViewModelProviders.of(this).get(MarvelViewModel.class);
    }
}
