package com.example.omdbsearcher.Dagger.Component

import com.example.omdbsearcher.Application.BaseApp
import com.example.omdbsearcher.Dagger.Builder.ActivityBuilder
import com.example.omdbsearcher.Dagger.Module.AppModule
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