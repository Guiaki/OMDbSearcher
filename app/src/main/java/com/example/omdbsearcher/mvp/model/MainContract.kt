package com.example.omdbsearcher.Modules.home

import com.example.omdbsearcher.data.database.entity.MovieEntity
import com.example.omdbsearcher.data.model.SearchMovie

interface MainContract {

    interface View {

        fun onClickItem(movie: MovieEntity)
        fun showMovieList(movieList: List<MovieEntity>)
        fun setTopImage(movie: MovieEntity)
    }

    interface Presenter {
        fun init()
    }
}