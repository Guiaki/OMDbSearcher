package com.example.omdbsearcher.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "movie")
data class MovieEntity(                     //ColumInfo for ROOM and SerializedName for GSON
                @ColumnInfo(name = "title")
                @SerializedName("Title")
                var title: String = "",
                @ColumnInfo(name = "runtime")
                @SerializedName("Runtime")
                var runtime: Int = 0,
                @ColumnInfo(name = "plot")
                @SerializedName("Plot")
                var plot: String = "",
                @ColumnInfo(name = "poster")
                @SerializedName("Poster")
                var poster: String = "",
                @ColumnInfo(name = "year")
                @SerializedName("Year")
                var year: Int = 0)
{
    @ColumnInfo(name = "imdbid")
    @SerializedName("imdbID")
    @PrimaryKey var imdbid: String = ""
}
