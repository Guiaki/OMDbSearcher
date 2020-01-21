package com.example.omdbsearcher.utils.adapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.omdbsearcher.BuildConfig
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.model.SearchMovie
import com.example.omdbsearcher.mvp.view.SearchActivity
import kotlinx.android.synthetic.main.item_movie_search.view.*

class SearchListAdapter(private val context: Context, private val movieList: List<SearchMovie>, private val searchActivity: SearchActivity) :
    RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = SearchViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_movie_search, parent, false)
    )

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        Glide.with(context)
            .load(movieList.get(position).poster)
            .dontAnimate()
            .placeholder(R.mipmap.ic_not_found)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.poster)

        holder.title.text = Html.fromHtml("<b>"+movieList.get(position).title+"</b> ("+movieList.get(position).year+")")

        holder.layout.setOnClickListener{
            searchActivity.onClickItem(movieList.get(position).imdbID!!)
        }
    }
    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var layout: LinearLayout
        var poster: ImageView
        var title: TextView
        init{
            layout = view.lnl_item_container
            poster = view.imv_poster_item
            title = view.txv_title_item
        }
    }
}