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
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        mainPresenter.init()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
