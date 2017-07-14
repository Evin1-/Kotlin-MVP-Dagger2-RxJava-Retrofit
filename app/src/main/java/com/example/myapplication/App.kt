package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.ApplicationComponent
import com.example.myapplication.di.DaggerApplicationComponent
import com.example.myapplication.di.NetworkModule
import com.example.myapplication.di.RepositoryModule

/**
 * Created by user on 7/14/17.
 */

class App : Application() {
    var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .build()
    }
}
