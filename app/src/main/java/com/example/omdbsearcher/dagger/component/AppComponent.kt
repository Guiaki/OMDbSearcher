package com.example.omdbsearcher.dagger.component

import com.example.omdbsearcher.application.BaseApp
import com.example.omdbsearcher.dagger.builder.ActivityBuilder
import com.example.omdbsearcher.dagger.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=arrayOf(AppModule::class, AndroidInjectionModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: BaseApp): Builder

        fun build(): AppComponent
    }

    fun inject (app: BaseApp)
}