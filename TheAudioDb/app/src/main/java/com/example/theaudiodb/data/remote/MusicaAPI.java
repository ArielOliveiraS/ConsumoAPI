package com.example.theaudiodb.data.remote;

import com.example.theaudiodb.model.Artista;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicaAPI {

    @GET("searchalbum.php")
    Observable<Artista> getAllAlbumArtist(
            @Query("s") String artista);
}
