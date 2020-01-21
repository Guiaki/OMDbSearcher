package com.example.omdbsearcher.dagger.builder

import com.example.omdbsearcher.Modules.home.MainActivity
import com.example.omdbsearcher.mvp.view.DetailsActivity
import com.example.omdbsearcher.mvp.view.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity (): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindSearchActivity (): SearchActivity

    @ContributesAndroidInjector
    internal abstract fun bindDetailsActivity (): DetailsActivity
}