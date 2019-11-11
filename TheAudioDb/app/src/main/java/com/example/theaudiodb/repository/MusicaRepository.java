package com.example.theaudiodb.repository;

import com.example.theaudiodb.model.Artista;

import io.reactivex.Observable;

import static com.example.theaudiodb.data.remote.RetrofitService.getApiService;

public class MusicaRepository {

    public Observable<Artista> getAlbums(String artista){
       return getApiService().getAllAlbumArtist(artista);
    }
}
