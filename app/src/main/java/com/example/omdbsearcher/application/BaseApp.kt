package com.example.omdbsearcher.application

import android.app.Application
import com.example.omdbsearcher.dagger.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun androidInjector(): DispatchingAndroidInjector<Any> = activityInjector
}