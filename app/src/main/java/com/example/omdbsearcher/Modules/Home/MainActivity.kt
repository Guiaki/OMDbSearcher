package com.example.omdbsearcher.Modules.Home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.omdbsearcher.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var app : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        Log.d("OMDbDebug", app.toString())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
