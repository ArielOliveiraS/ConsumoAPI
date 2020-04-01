package com.example.desafiomarvelapi.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafiomarvelapi.R;
import com.example.desafiomarvelapi.model.characters.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imagem;
    private ImageView imgBanner;
    private TextView txtTitulo;
    private TextView txtDescricao;
    private FloatingActionButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        initViews();

        if (getIntent() != null) {
            Result result = getIntent().getParcelableExtra("Result");

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imagem);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgBanner);

            txtTitulo.setText(result.getName());
            txtDescricao.setText(result.getDescription());

            imagem.setOnClickListener(v -> {
                Intent intent = new Intent(DetalheActivity.this, DetalheImagemActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Result", result);
                intent.putExtras(bundle);
                startActivity(intent);
            });
        }

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(DetalheActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void initViews() {
        imagem = findViewById(R.id.imgHQ);
        imgBanner = findViewById(R.id.imgBanner);
        txtTitulo= findViewById(R.id.txtTitulo);
        txtDescricao= findViewById(R.id.txtDescricao);
        btnVoltar= findViewById(R.id.floatingActionButton);
    }
}
