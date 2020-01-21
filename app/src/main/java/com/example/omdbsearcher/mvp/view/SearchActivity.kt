package com.example.omdbsearcher.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.model.SearchMovie
import com.example.omdbsearcher.mvp.model.SearchContract
import com.example.omdbsearcher.mvp.presenter.SearchPresenter
import com.example.omdbsearcher.utils.adapters.SearchListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class SearchActivity : AppCompatActivity(), SearchContract.View {

    @Inject
    lateinit var searchPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchPresenter.init()

        startViews()
    }

    override fun onClickItem(imdbID: String){

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
        src_search.hasFocus()
    }
}
