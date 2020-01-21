package com.example.omdbsearcher.utils.adapters

import android.content.Context
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbsearcher.Modules.home.MainActivity
import com.example.omdbsearcher.R
import com.example.omdbsearcher.data.database.entity.MovieEntity
import kotlinx.android.synthetic.main.item_main_list.view.*

class MainListAdapter(private val context: Context, private val movieList: List<MovieEntity>, private val mainActivity: MainActivity, val mainItem: String) :
    RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    var lastViewHolder: MainListViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = MainListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false)
    )

    fun removeLastClick(){
        if(lastViewHolder != null){
            lastViewHolder!!.layout.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        if(mainItem == movieList.get(position).imdbid){
            lastViewHolder = holder
            holder.layout.setBackgroundColor(Color.parseColor("#CCCCCC"))
        }
        holder.title.text = movieList.get(position).title+" ("+movieList.get(position).year+")"

        holder.layout.setOnClickListener{
            mainActivity.onClickItem(movieList.get(position))
            holder.layout.setBackgroundColor(Color.parseColor("#CCCCCC"))
            lastViewHolder = holder
        }
    }
    class MainListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var layout: LinearLayout
        var title: TextView
        init{
            layout = view.lnl_item_container
            title = view.txv_title_item
        }
    }
}