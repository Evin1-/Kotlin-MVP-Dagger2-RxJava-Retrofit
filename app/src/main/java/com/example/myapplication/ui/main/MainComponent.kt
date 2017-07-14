package com.example.myapplication.ui.main

import com.example.myapplication.di.ApplicationComponent
import com.example.myapplication.di.scopes.ActivityScope
import dagger.Component

/**
 * Created by user on 7/14/17.
 */

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MainModule::class))
internal interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
