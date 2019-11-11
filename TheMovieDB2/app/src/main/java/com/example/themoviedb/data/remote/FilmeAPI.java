package com.example.themoviedb.data.remote;

import com.example.themoviedb.model.Filme;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeAPI {

    @GET("movie/now_playing")
    Observable<Filme> getAllFilmes(@Query("api_key")String apiKey,
                                   @Query("page")int pagina);
}
