package com.example.desafiomarvelapi.repository;

import com.example.desafiomarvelapi.data.remote.RetrofitService;
import com.example.desafiomarvelapi.model.pojos.ComicsResult;

import io.reactivex.Observable;

public class MarvelRepository {

    public Observable<ComicsResult> getComics(String format, String formatType, boolean noVariants, String orderBy, String limit, String ts, String hash, String apiKey) {
        return RetrofitService.getApiService().getAllComics(format, formatType, noVariants,orderBy, limit, ts, hash, apiKey);
    }
}



