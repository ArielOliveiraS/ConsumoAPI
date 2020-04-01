package com.example.desafiomarvelapi.repository;

import com.example.desafiomarvelapi.model.characters.Personagens;
import com.example.desafiomarvelapi.model.charactersId.Characterid;
import com.example.desafiomarvelapi.model.comics.ComicsResult;

import io.reactivex.Observable;

import static com.example.desafiomarvelapi.data.remote.RetrofitService.getApiService;

public class MarvelRepository {

    public Observable<Personagens> getPersonagemRepositori(int pagina, String orderBy, String ts, String hash, String apiKey) {
        return getApiService().getALLPersonagens(pagina, orderBy, ts, hash, apiKey);
    }

    public Observable<Characterid> getCharacterRepository(String ts, String hash, String apiKey) {
        return getApiService().getIdCharacter(ts, hash, apiKey);
    }

    public Observable<ComicsResult> getComicsRepository(int pagina, String format, String formatType, boolean noVariants, String orderBy, String ts, String hash, String apiKey){
        return getApiService().getAllComics(pagina, format, formatType, noVariants, orderBy, ts, hash, apiKey);
    }
}



