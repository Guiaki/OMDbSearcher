package com.example.omdbsearcher.mvp.presenter

import com.example.omdbsearcher.application.BaseApp
import com.example.omdbsearcher.data.database.entity.MovieEntity
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

    override fun init(imdbID: String) {
        BaseApp.API.getMovie(imdbID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ view.showDetails(it) }
    }

    override fun deleteMovie(movie: MovieEntity) {
        mMovieRepository.deleteMovieInDb(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }

    override fun saveMovie(newMovie: MovieEntity) {
        mMovieRepository.storeMovieInDb(newMovie)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }
}