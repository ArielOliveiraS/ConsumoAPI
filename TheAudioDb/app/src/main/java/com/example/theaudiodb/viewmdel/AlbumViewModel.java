package com.example.theaudiodb.viewmdel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.theaudiodb.model.Album;
import com.example.theaudiodb.model.Artista;
import com.example.theaudiodb.repository.MusicaRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.theaudiodb.data.remote.RetrofitService.getApiService;

public class AlbumViewModel extends AndroidViewModel {
    private MutableLiveData<List<Album>> albunsLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> albunsLiveDataError = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MusicaRepository repository = new MusicaRepository();


    public AlbumViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Album>> getAlbumLiveData() {
        return albunsLiveData;
    }

    public LiveData<String> getErrorAlbum(){
        return this.albunsLiveDataError;
    }

    public void getAlbuns(String artista) {

        disposable.add(
                getApiService().getAllAlbumArtist(artista)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> isLoading.setValue(true))
                        .doOnTerminate(() -> {
                            isLoading.setValue(false);
                        })
                        .subscribe((Artista artistaResponse) ->
                                {
                                    albunsLiveData.setValue(artistaResponse.getAlbum());
                                }
                                , throwable -> {
                                    albunsLiveDataError.setValue(throwable.getMessage());
                                })


        );


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
