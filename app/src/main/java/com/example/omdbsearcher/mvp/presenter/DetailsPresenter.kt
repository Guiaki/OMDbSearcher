package com.example.omdbsearcher.mvp.presenter

import com.example.omdbsearcher.application.BaseApp
import com.example.omdbsearcher.data.repository.MovieRepository
import com.example.omdbsearcher.mvp.model.DetailsContract
import com.example.omdbsearcher.mvp.view.DetailsActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsPresenter
@Inject constructor(private val view: DetailsActivity) : DetailsContract.Presenter {

    @Inject
    lateinit var mMovieRepository: MovieRepository

    override fun init() {
        BaseApp.API.getMovieList("shadow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toList()
            .subscribe{ movieList ->
            }
    }
}