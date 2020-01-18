package com.example.omdbsearcher.data.repository

import android.util.Log
import com.example.omdbsearcher.data.database.dao.MovieDao
import com.example.omdbsearcher.data.database.entity.MovieEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MovieRepository(private val mMovies: MovieDao) {

    fun getAllMovies(): Observable<List<MovieEntity>> {
        return mMovies.getAllMovies()
            .toObservable()
            .doOnNext { Log.d("MovieRepository","Dispatching ${it} from DB...") }
    }

    fun storeMovieInDb(movie: MovieEntity) : Completable {
        return Completable.fromCallable { mMovies.insertMovie(movie) }
    }

    fun updateMovieInDB(movie: MovieEntity) {
        Observable.fromCallable { mMovies.updateMovie(movie) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Log.d("MovieRepository", "Updated movie ${movie.id} successfully...")
            }
    }
}