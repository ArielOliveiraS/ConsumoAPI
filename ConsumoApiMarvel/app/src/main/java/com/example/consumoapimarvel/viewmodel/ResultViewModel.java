package com.example.consumoapimarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.consumoapimarvel.model.Date;
import com.example.consumoapimarvel.model.Image;
import com.example.consumoapimarvel.model.Price;
import com.example.consumoapimarvel.model.Result;
import com.example.consumoapimarvel.repository.HQRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ResultViewModel extends AndroidViewModel {
    private MutableLiveData<List<Result>> listaResult = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private HQRepository repository = new HQRepository();


    public ResultViewModel(@NonNull Application application) {
        super(application);
    }


        public LiveData<List<Result>> getListaResult() {
            return this.listaResult;
        }

        public LiveData<Boolean> getLoading() {
            return this.loading;
        }

    public void getAllResults(String apiKey, String pageCount, List<Date> dates,
                              List<Price> prices, List<Image> images, String title,
                              String description) {
        disposable.add(
                repository.getHq(apiKey, pageCount, dates, prices, images , title, description)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable1) throws Exception {
                                loading.setValue(true);
                            }
                        })
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(hqResult -> listaResult.setValue(hqResult.getResults()),
                                throwable -> {
                                    Log.i("LOG", "erro" + throwable.getMessage());
                                })
        );


    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}
