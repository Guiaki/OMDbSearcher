package com.example.omdbsearcher.Modules.home

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.database.entity.MovieEntity
import com.example.omdbsearcher.mvp.view.DetailsActivity
import com.example.omdbsearcher.mvp.view.SearchActivity
import com.example.omdbsearcher.utils.adapters.MainListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var mainPresenter: MainPresenter

    lateinit var listAdapter: MainListAdapter

    var lastSelectedItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.init()

        startViews()
    }

    override fun onClickItem(movie: MovieEntity){
        listAdapter.removeLastClick()
        if(lastSelectedItem == movie.imdbid){
            val intent = Intent(this, DetailsActivity::class.java)
                .putExtra("imdbID", movie.imdbid)
            startActivityForResult(intent, 0)
        }else{
            setTopImage(movie)
        }
        lastSelectedItem = movie.imdbid
    }

    override fun setTopImage(movie: MovieEntity){
        lastSelectedItem = movie.imdbid
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels

        ctl_main.post(Runnable {
            Glide.with(this)
                .load(movie.poster)
                .dontAnimate()
                .placeholder(R.mipmap.ic_not_found)
                .skipMemoryCache(true)
                .override(height / 3, height / 3)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imv_poster_top)
        })

        imv_poster_top.setOnClickListener{
            onClickItem(movie)
        }
    }

    fun showEmptyView(){
        ctl_main.post(Runnable {
            imv_poster_top.visibility = View.GONE
            lst_movie_list.visibility = View.GONE
            txv_big_text.visibility = View.VISIBLE
        })
    }

    override fun showMovieList(movieList: List<MovieEntity>){
        lst_movie_list.post(Runnable {
            imv_poster_top.visibility = View.VISIBLE
            lst_movie_list.visibility = View.VISIBLE
            txv_big_text.visibility = View.GONE

            lst_movie_list.setHasFixedSize(true)
            lst_movie_list.layoutManager = LinearLayoutManager(this)
            listAdapter = MainListAdapter(this, movieList, this, lastSelectedItem)
            lst_movie_list.adapter = listAdapter

            val dividerDecoration = DividerItemDecoration(lst_movie_list.context, DividerItemDecoration.VERTICAL)
            dividerDecoration.setDrawable(resources.getDrawable(R.drawable.ic_line_divider))
            lst_movie_list.addItemDecoration(dividerDecoration)
        })
    }

    fun startViews(){
        ctl_header.setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mainPresenter.getAllMovieFromDB()
    }
}
