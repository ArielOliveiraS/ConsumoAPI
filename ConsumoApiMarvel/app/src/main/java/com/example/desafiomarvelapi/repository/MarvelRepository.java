package com.example.desafiomarvelapi.repository;

import com.example.desafiomarvelapi.model.characters.Personagens;
import com.example.desafiomarvelapi.model.comicsid.Comics;

import io.reactivex.Observable;

import static com.example.desafiomarvelapi.data.remote.RetrofitService.getApiService;

public class MarvelRepository {

    public Observable<Personagens> getPersonagemRepository(int pagina, String orderBy, String ts, String hash, String apiKey) {
        return getApiService().getALLPersonagens(pagina, orderBy, ts, hash, apiKey);
    }

    public Observable<Comics> getComicsRepository(Long characterid, String ts, String hash, String apiKey) {
        return getApiService().getIdComics(characterid, ts, hash, apiKey);
    }
}



