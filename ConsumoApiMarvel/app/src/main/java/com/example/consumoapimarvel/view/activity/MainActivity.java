package com.example.consumoapimarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.consumoapimarvel.R;
import com.example.consumoapimarvel.model.Result;
import com.example.consumoapimarvel.view.adapter.RecyclerViewHqAdapter;
import com.example.consumoapimarvel.view.interfaces.OnClick;
import com.example.consumoapimarvel.viewmodel.MarvelViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClick {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewHqAdapter adapter;
    private List<Result> resultList = new ArrayList<>();
    private MarvelViewModel viewModel;

    public static final String RESULT_KEY = "result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        viewModel.getComics();

        viewModel.getListaResult().observe(this, retornaLista -> {
            adapter.atualizaLista(retornaLista);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });


    }


    public void initViews() {
        recyclerView = findViewById(R.id.recyclerHq);
        progressBar = findViewById(R.id.progress_bar);
        viewModel = ViewModelProviders.of(this).get(MarvelViewModel.class);
        adapter = new RecyclerViewHqAdapter(resultList, this);
    }

    @Override
    public void click(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheHqActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
