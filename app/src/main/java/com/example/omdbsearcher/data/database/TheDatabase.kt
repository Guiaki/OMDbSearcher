package com.example.omdbsearcher.data.database

import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.omdbsearcher.data.database.dao.MovieDao
import com.example.omdbsearcher.data.database.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class TheDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}