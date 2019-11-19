package com.example.consumoapimarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.consumoapimarvel.model.Result;
import com.example.consumoapimarvel.repository.MarvelRepository;
import com.example.consumoapimarvel.util.AppUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.consumoapimarvel.util.AppUtils.md5;

public class MarvelViewModel extends AndroidViewModel {
    private MutableLiveData<List<Result>> listaResult = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MarvelRepository repository = new MarvelRepository();

    private static final String PUBLIC_API_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    private static final String PRIVATE_API_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";
    String ts = Long.toString(System.currentTimeMillis() / 1000);
    String hash = AppUtils.md5(ts + PRIVATE_API_KEY + PUBLIC_API_KEY);

    public MarvelViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaResult() {
        return this.listaResult;
    }
    public LiveData<Boolean> getLoading() {
        return this.loading;
    }


    public void getComics() {
        disposable.add(
                repository.getComics("magazine", "comic", true, "focDate", "42", ts, hash, PUBLIC_API_KEY)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(comicsResult -> {
                            listaResult.setValue(comicsResult.getData().getResults());
                        }, throwable -> {
                            Log.i("Log", "Error: " + throwable.getMessage());
                        })
        );


    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}

