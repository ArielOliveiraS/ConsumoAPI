package com.example.consumoapimarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consumoapimarvel.R;
import com.example.consumoapimarvel.model.Result;
import com.squareup.picasso.Picasso;

public class DetalheHqActivity extends AppCompatActivity {

    private ImageView imgBanner;
    private ImageView imgHq;
    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtData;
    private TextView txtPreço;
    private TextView txtPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_hq);

        initViews();

        if (getIntent() != null) {
            Result result = getIntent().getParcelableExtra("Result");

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgBanner);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgHq);

            txtTitulo.setText(result.getTitle());
            txtDescricao.setText(result.getDescription());

            String dataISO = result.getDates().get(0).getDate().split("T")[0];
            String[] dates = dataISO.split("-");
            String dataUsuario = dates[2] + "/" + dates[1] + "/" + dates[0];
            txtData.setText(dataUsuario);

            txtPreço.setText("US$ " + String.format("%.2f", result.getPrices().get(0).getPrice()));
            txtPaginas.setText(result.getPageCount().toString() + " pages");

        }}

    public void initViews() {
        imgBanner = findViewById(R.id.imgBanner);
        imgHq = findViewById(R.id.imgHQ);
        txtTitulo= findViewById(R.id.txtTitulo);
        txtDescricao= findViewById(R.id.txtDescricao);
        txtData= findViewById(R.id.txtPublicacao);
        txtPreço= findViewById(R.id.txtPreco);
        txtPaginas= findViewById(R.id.txtPaginas);

    }
}
