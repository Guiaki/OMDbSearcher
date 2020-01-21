package com.example.omdbsearcher.Modules.home

import android.util.Log
import com.example.omdbsearcher.application.BaseApp
import com.example.omdbsearcher.data.database.entity.MovieEntity
import com.example.omdbsearcher.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter
@Inject constructor(private val view: MainActivity) : MainContract.Presenter {

    @Inject
    lateinit var mMovieRepository: MovieRepository

    override fun init() {
        getAllMovieFromDB()
    }

    fun getAllMovieFromDB(){
        mMovieRepository.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe{movieList ->
                if(movieList.size >= 1){
                    view.setTopImage(movieList.first())
                    view.showMovieList(movieList)
                }else{
                    view.showEmptyView()
                }
            }
    }
}