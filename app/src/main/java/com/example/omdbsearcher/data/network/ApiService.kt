package com.example.omdbsearcher.data.network

import com.example.omdbsearcher.data.database.entity.MovieEntity
import com.example.omdbsearcher.data.model.SearchMovie
import com.example.omdbsearcher.data.model.SearchWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("")
    fun getMovie(@Query("i") id: String, @Query("apikey") apikey: String, @Query("plot") plot: String): Observable<MovieEntity>

    @GET("/")
    fun getMoviesList(@Query("s") searchedMovieTitle: String, @Query("apikey") apikey: String): Observable<SearchWrapper>

}