package com.example.consumoapimarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consumoapimarvel.R;
import com.example.consumoapimarvel.model.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetalheHqActivity extends AppCompatActivity {

    private ImageView imagem;
    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtData;
    private TextView txtPreço;
    private TextView txtPaginas;
    private FloatingActionButton btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_hq);

        initViews();

        if (getIntent() != null) {
            Result result = getIntent().getParcelableExtra("Result");

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imagem);
            //   Picasso.get().load(result.getThumbnail().getPath() + "/detail." + result.getThumbnail().getExtension());

            txtTitulo.setText(result.getTitle());
            txtDescricao.setText(result.getDescription());

            String dataISO = result.getDates().get(0).getDate().split("T")[0];
            String[] dates = dataISO.split("-");
            String dataUsuario = dates[2] + "/" + dates[1] + "/" + dates[0];
            txtData.setText(dataUsuario);

            txtPreço.setText("US$ " + String.format("%.2f", result.getPrices().get(0).getPrice()));
            txtPaginas.setText(result.getPageCount().toString() + " pages");
            imagem.setOnClickListener(v -> {
                Intent intent = new Intent(DetalheHqActivity.this, DetalheImagem.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Result", result);
                intent.putExtras(bundle);
                startActivity(intent);
            });

            btnvoltar.setOnClickListener(v -> {
                Intent intent = new Intent(DetalheHqActivity.this, MainActivity.class);
                startActivity(intent);
            });

        }
    }

    public void initViews() {
        imagem = findViewById(R.id.imgHQ);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtData = findViewById(R.id.txtPublicacao);
        txtPreço = findViewById(R.id.txtPreco);
        txtPaginas = findViewById(R.id.txtPaginas);
        btnvoltar = findViewById(R.id.btnVoltar);

    }
}
