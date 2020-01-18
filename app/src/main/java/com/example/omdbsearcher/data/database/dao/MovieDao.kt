package com.example.omdbsearcher.data.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.omdbsearcher.data.database.entity.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {

    @Query("select * from movie")
    fun getAllMovies(): Single<List<MovieEntity>>

    @Insert(onConflict = REPLACE)
    fun insertMovie(entry: MovieEntity)

    @Update(onConflict = REPLACE)
    fun updateMovie(entry: MovieEntity)

    @Delete
    fun deleteMovie(entry: MovieEntity)
}