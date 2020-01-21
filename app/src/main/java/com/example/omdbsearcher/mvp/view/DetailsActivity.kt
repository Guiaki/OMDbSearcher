package com.example.omdbsearcher.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.omdbsearcher.R
import com.example.omdbsearcher.mvp.presenter.DetailsPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detailsPresenter.init()
    }
}
