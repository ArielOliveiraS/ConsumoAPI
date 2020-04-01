package com.example.desafiomarvelapi.data.remote;

import com.example.desafiomarvelapi.model.characters.Personagens;
import com.example.desafiomarvelapi.model.charactersId.Characterid;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelAPI {

    @GET ("characters?")
    Observable<Personagens> getALLPersonagens(
            @Query("offset")int pagina,
            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );

    @GET("characters/{charactersId}")
    Observable<Characterid> getIdCharacter(
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey
    );
}
