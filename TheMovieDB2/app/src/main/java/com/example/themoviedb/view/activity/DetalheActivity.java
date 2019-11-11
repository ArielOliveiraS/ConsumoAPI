package com.example.themoviedb.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.themoviedb.R;
import com.example.themoviedb.model.Result;
import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        ImageView imageViewDetalhe = findViewById(R.id.imageViewDetalhe);

        if(getIntent() != null){
            Result result = getIntent().getParcelableExtra("Filme");
            Toast.makeText(this,"Result " + result.getTitle(), Toast.LENGTH_LONG).show();

            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+ result.getPosterPath()).into(imageViewDetalhe);

        }
    }
}
