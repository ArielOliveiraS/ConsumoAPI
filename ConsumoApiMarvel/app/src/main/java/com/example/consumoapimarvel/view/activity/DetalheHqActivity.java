package com.example.consumoapimarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consumoapimarvel.R;

public class DetalheHqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_hq);

        ImageView imagemBanner = findViewById(R.id.imageViewBanner);
        ImageView imagemHq = findViewById(R.id.imgHq);
        TextView txtTitulo = findViewById(R.id.txtTitulo);
        TextView txtDescricao = findViewById(R.id.detalheDescricao);
        TextView txtAnoPublicacao = findViewById(R.id.detalheAnoDePublicação);
        TextView txtPreco = findViewById(R.id.detalhePreco);
        TextView txtPaginas = findViewById(R.id.detalhePaginas);

    }
}
