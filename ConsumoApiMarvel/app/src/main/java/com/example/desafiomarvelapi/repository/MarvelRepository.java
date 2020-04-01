package com.example.desafiomarvelapi.repository;

import com.example.desafiomarvelapi.data.remote.RetrofitService;
import com.example.desafiomarvelapi.model.characters.Personagens;

import io.reactivex.Observable;

public class MarvelRepository {

    public Observable<Personagens> getPersonagemRepositori(int pagina, String orderBy, String ts,
                                                           String hash, String apiKey) {
        return RetrofitService.getApiService().getALLPersonagens(pagina, orderBy, ts, hash, apiKey);
    }
}



