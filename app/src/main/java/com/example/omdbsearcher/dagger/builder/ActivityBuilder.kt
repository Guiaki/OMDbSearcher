package com.example.omdbsearcher.dagger.builder

import com.example.omdbsearcher.Modules.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity (): MainActivity
}