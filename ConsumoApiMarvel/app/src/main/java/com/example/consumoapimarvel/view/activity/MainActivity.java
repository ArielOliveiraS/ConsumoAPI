package com.example.consumoapimarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.consumoapimarvel.R;
import com.example.consumoapimarvel.model.Result;
import com.example.consumoapimarvel.view.adapter.RecyclerViewHqAdapter;
import com.example.consumoapimarvel.view.interfaces.OnClick;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClick {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewHqAdapter adapter;
    private List<Result> listaHq = new ArrayList<>();
    public static final String API_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }




    private void initViews() {
        recyclerView = findViewById(R.id.recyclerHq);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewHqAdapter(listaHq, this);


    }

    @Override
    public void click(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheHqActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Result", result);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setScrollView(){

    }
}
