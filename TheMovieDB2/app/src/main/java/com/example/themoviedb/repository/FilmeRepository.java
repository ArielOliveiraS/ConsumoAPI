package com.example.themoviedb.repository;

import com.example.themoviedb.model.Filme;

import io.reactivex.Observable;

import static com.example.themoviedb.data.remote.RetrofitService.getApiService;

public class FilmeRepository {

    public Observable<Filme> getFilmes(String apiKey, int pagina){
        return getApiService().getAllFilmes(apiKey, pagina);
    }
}
