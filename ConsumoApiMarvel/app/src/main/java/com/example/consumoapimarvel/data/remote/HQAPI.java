package com.example.consumoapimarvel.data.remote;

import com.example.consumoapimarvel.model.Marvel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HQAPI {

    @GET("comics")
    Observable<Marvel> getAllComics(@Query("format") String format,
                                    @Query("formatType") String formatType,
                                    @Query("noVariants") boolean noVariants,
                                    @Query("orderBy") String orderBy,
                                    @Query("limit") String limit,
                                    @Query("ts") String ts,
                                    @Query("hash") String hash,
                                    @Query("apikey") String apiKey);
}