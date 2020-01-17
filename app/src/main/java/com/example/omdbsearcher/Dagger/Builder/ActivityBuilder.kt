package com.example.omdbsearcher.Dagger.Builder

import com.example.omdbsearcher.Modules.Home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity (): MainActivity
}