package com.example.consumoapimarvel.data.remote;

import com.example.consumoapimarvel.model.Marvel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HQAPI {

    @GET("comics")
    Observable<Marvel> getAllComics(@Query("dateDescriptor") String data,
                                            @Query("format") String format,
                                            @Query("formatType") String formatType,
                                            @Query("orderBy") String order,
                                            @Query("ts") String timestamp,
                                            @Query("hash") String hash,
                                            @Query("apikey") String apiKey,
                                            @Query("noVariants") Boolean noVariants,
                                            @Query("offset") int offset);
}