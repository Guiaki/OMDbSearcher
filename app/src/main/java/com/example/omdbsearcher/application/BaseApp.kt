package com.example.omdbsearcher.application

import android.app.Application
import com.example.omdbsearcher.dagger.component.DaggerAppComponent
import com.example.omdbsearcher.data.network.ApiWrapper
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import kotlin.properties.Delegates

class BaseApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Any>

    companion object {
        @JvmStatic
        val API = ApiWrapper()
        private val TAG = BaseApp::class.java.simpleName
        var instance: BaseApp by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun androidInjector(): DispatchingAndroidInjector<Any> = activityInjector
}