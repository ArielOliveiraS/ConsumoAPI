package com.example.desafiomarvelapi.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafiomarvelapi.model.pojos.Result;
import com.example.desafiomarvelapi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetalheImagemActivity extends AppCompatActivity {

    private ImageView imagem;
    private FloatingActionButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_imagem);

        imagem = findViewById(R.id.imgDetalhe);
        btnVoltar = findViewById(R.id.btnVoltar);

        Result result = getIntent().getParcelableExtra("Result");
        Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imagem);

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(DetalheImagemActivity.this, DetalheActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("Result", result);
            intent.putExtras(bundle);
            startActivity(intent);
        });


    }


}
