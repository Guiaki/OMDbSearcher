package com.example.omdbsearcher.mvp.model

import com.example.omdbsearcher.data.database.entity.MovieEntity

interface DetailsContract {

    interface View {
        fun showDetails(movie: MovieEntity)
    }

    interface Presenter {
        fun init(imdbID: String)
        fun saveMovie(newMovie: MovieEntity)
        fun deleteMovie(movie: MovieEntity)
    }
}