package com.example.myapplication.ui.details

import com.example.myapplication.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by user on 7/14/17.
 */
@Module
class DetailsModule {
    @ActivityScope
    @Provides
    fun provideDetailsPresenter(): DetailsPresenter {
        return DetailsPresenter()
    }
}