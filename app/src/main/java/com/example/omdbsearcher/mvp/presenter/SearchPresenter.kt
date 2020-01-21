package com.example.omdbsearcher.mvp.presenter

import android.util.Log
import com.example.omdbsearcher.application.BaseApp
import com.example.omdbsearcher.data.model.SearchMovie
import com.example.omdbsearcher.data.repository.MovieRepository
import com.example.omdbsearcher.mvp.model.SearchContract
import com.example.omdbsearcher.mvp.view.SearchActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter
@Inject constructor(private val view: SearchActivity) : SearchContract.Presenter {

    @Inject
    lateinit var mMovieRepository: MovieRepository

    override fun init() {

    }

    override fun search(searchTerm: String){
        BaseApp.API.getMovieList(searchTerm)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toList()
            .subscribe{ movieList ->
                view.showMovieList(movieList)
            }
    }
}