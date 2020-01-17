package com.example.omdbsearcher.Application

import android.app.Activity
import android.app.Application
import com.example.omdbsearcher.Dagger.Component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class BaseApp : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}