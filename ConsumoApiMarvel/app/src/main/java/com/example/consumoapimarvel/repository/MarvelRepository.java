package com.example.consumoapimarvel.repository;

import com.example.consumoapimarvel.model.Marvel;

import io.reactivex.Observable;

import static com.example.consumoapimarvel.data.remote.RetrofitService.getApiService;

public class MarvelRepository {

    public Observable<Marvel> getComics(String data, String format, String formatType, String order, String timestamp, String hash, String apiKey, Boolean noVariants, int offset) {
        return getApiService().getAllComics(data, format, formatType, order, timestamp, hash, apiKey, noVariants, offset);
    }
    }


