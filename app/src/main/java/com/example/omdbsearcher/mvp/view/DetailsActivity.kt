package com.example.omdbsearcher.mvp.view

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.database.entity.MovieEntity
import com.example.omdbsearcher.mvp.model.DetailsContract
import com.example.omdbsearcher.mvp.presenter.DetailsPresenter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject


class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var imdbID = ""
        if (intent.hasExtra("imdbID")) {
            imdbID = intent.getStringExtra("imdbID")
        }

        imv_back.setOnClickListener{
            finish()
        }

        detailsPresenter.init(imdbID)
    }

    override fun showDetails(movie: MovieEntity) {
        imv_save.setOnClickListener{
            detailsPresenter.saveMovie(movie)
            finish()
        }
        imv_delete.setOnClickListener{
            detailsPresenter.deleteMovie(movie)
            finish()
        }
        txv_header_title.text = movie.title
        txv_plot.text = movie.plot

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels

        Glide.with(this)
            .load(movie.poster)
            .dontAnimate()
            .placeholder(R.mipmap.ic_not_found)
            .skipMemoryCache(true)
            .override(height/3,height/3)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imv_poster)
    }
}
