package com.example.omdbsearcher.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie")
data class MovieEntity(
                @ColumnInfo(name = "title") var title: String = "",
                @ColumnInfo(name = "duration") var duration: Int = 0,
                @ColumnInfo(name = "description") var description: String = "",
                @ColumnInfo(name = "image_file_name") var imageFileName: String = "",
                @ColumnInfo(name = "year") var year: Int = 0)
{
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
