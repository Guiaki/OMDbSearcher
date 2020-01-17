package com.example.omdbsearcher.Dagger.Module

import android.content.Context
import com.example.omdbsearcher.Application.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule()
{
    @Provides
    @Singleton
    fun provideApplication(app : BaseApp): Context = app
}