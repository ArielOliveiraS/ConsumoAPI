package com.example.consumoapimarvel.repository;

import com.example.consumoapimarvel.model.Date;
import com.example.consumoapimarvel.model.Image;
import com.example.consumoapimarvel.model.Price;
import com.example.consumoapimarvel.model.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Query;

import static com.example.consumoapimarvel.data.remote.RetrofitService.getApiService;

public class HQRepository {

    public Observable<Result> getHq(String apiKey, String pageCount, List<Date> dates,
                                    List<Price> prices, List<Image> images, String title,
                                    String description ){


        return getApiService().getAllHqs(apiKey, pageCount, dates, prices, images , title, description);
    }

//
//

}
