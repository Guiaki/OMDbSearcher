package com.example.omdbsearcher.Modules.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.database.entity.MovieEntity
import com.example.omdbsearcher.data.repository.MovieRepository
import dagger.android.AndroidInjection
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var app : Context

    @Inject
    lateinit var mMovieRepository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        Log.d("OMDbDebug", app.toString())
        val newMovie: MovieEntity = MovieEntity("Interstellar",
                                    169,
                                    "As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand, Jenkins e Doyle, ele seguirá em busca de um novo lar.",
                                    "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQMHMl9U1z1txXWCBgKbSlwH0tV3wVIsxyd6CQLhR0CkgC8Nagf",
                                    2014)
        mMovieRepository.storeMovieInDb(newMovie)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()

        mMovieRepository.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe{movieList ->
                Log.d("OMDebug", movieList.size.toString())
                for (movie in movieList){
                    Log.d("OMDebug", movie.toString())
                }
            }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
