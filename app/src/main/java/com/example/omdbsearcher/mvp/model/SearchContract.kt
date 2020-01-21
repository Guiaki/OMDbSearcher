package com.example.omdbsearcher.mvp.model

import com.example.omdbsearcher.data.model.SearchMovie

interface SearchContract {

    interface View {

        fun showMovieList(movieList: List<SearchMovie>)
        fun onClickItem(imdbID: String)
    }

    interface Presenter {
        fun init()
        fun search(searchTerm: String)
    }
}