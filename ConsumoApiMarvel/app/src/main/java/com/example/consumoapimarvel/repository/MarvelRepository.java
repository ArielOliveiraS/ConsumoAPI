package com.example.consumoapimarvel.repository;

import com.example.consumoapimarvel.data.remote.RetrofitService;
import com.example.consumoapimarvel.model.Marvel;

import io.reactivex.Observable;

import static com.example.consumoapimarvel.data.remote.RetrofitService.getApiService;

public class MarvelRepository {

    public Observable<Marvel> getComics(String format, String formatType, boolean noVariants, String orderBy, String limit, String ts, String hash, String apiKey) {
        return RetrofitService.getApiService().getAllComics(format, formatType, noVariants, orderBy, limit, ts, hash, apiKey);
    }
}


