package com.example.consumoapimarvel.data.remote;

import com.example.consumoapimarvel.model.Date;
import com.example.consumoapimarvel.model.Image;
import com.example.consumoapimarvel.model.Price;
import com.example.consumoapimarvel.model.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HQAPI {

    @GET("public/comics/{comicId}")
    Observable<Result> getAllHqs(@Query("api_key") String apiKey,
                                 @Query("pageCount") String pageCount,
                                 @Query("dates") List<Date> dates,
                                 @Query("prices") List<Price> prices,
                                 @Query("images") List<Image> images,
                                 @Query("title") String title,
                                 @Query("description") String description
                                 );
}
