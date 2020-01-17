package com.example.omdbsearcher.Application

import android.app.Activity
import dagger.android.AndroidInjector

interface HasActivityInjector {

    fun activityInjector(): AndroidInjector<Activity>
}
