package com.example.omdbsearcher.dagger.module

import android.content.Context
import androidx.room.Room
import com.example.omdbsearcher.application.BaseApp
import com.example.omdbsearcher.data.database.TheDatabase
import com.example.omdbsearcher.data.database.dao.MovieDao
import com.example.omdbsearcher.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule()
{
    @Provides
    @Singleton
    fun provideApplication(app : BaseApp): Context = app

    @Provides
    @Singleton
    fun providesTheDatabase(context: Context): TheDatabase =
        Room.databaseBuilder(context, TheDatabase::class.java, "the-database").
            allowMainThreadQueries().addMigrations().build()

    @Provides
    @Singleton
    fun providesMovieDao(database: TheDatabase) = database.movieDao()

    @Provides
    @Singleton
    fun providesMovieRepository(movieDao: MovieDao) = MovieRepository(movieDao)
}