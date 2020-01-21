package com.example.omdbsearcher.mvp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.model.SearchMovie
import com.example.omdbsearcher.mvp.model.SearchContract
import com.example.omdbsearcher.mvp.presenter.SearchPresenter
import com.example.omdbsearcher.utils.adapters.SearchListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.timerTask


class SearchActivity : AppCompatActivity(), SearchContract.View {

    @Inject
    lateinit var searchPresenter: SearchPresenter

    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchPresenter.init()
        timer = Timer()
        startViews()
    }

    override fun onClickItem(imdbID: String){
        val intent = Intent(this, DetailsActivity::class.java)
            .putExtra("imdbID", imdbID)
        startActivityForResult(intent, 1)
    }

    override fun showMovieList(movieList: List<SearchMovie>) {
        rcv_movie_list.post(Runnable {
            rcv_movie_list.setHasFixedSize(true)
            rcv_movie_list.layoutManager = LinearLayoutManager(this)
            val adapter = SearchListAdapter(this, movieList, this)
            rcv_movie_list.adapter = adapter

            val dividerDecoration = DividerItemDecoration(rcv_movie_list.context, DividerItemDecoration.VERTICAL)
            dividerDecoration.setDrawable(resources.getDrawable(R.drawable.ic_line_divider))
            rcv_movie_list.addItemDecoration(dividerDecoration)
        })
    }

    fun startViews(){
        src_search.setFocusable(true);
        src_search.setIconified(false);
        src_search.requestFocusFromTouch();

        src_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                timer.cancel()
                timer = Timer()
                timer.schedule(timerTask{
                    searchPresenter.search(newText)
                },3000)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                timer.cancel()
                searchPresenter.search(query)
                return false
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        finish()
    }
}
