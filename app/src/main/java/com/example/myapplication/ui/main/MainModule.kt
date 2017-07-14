package com.example.myapplication.ui.main

import com.example.myapplication.data.GitHubRepository
import com.example.myapplication.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by user on 7/14/17.
 */

@Module
internal class MainModule {
    @ActivityScope
    @Provides
    fun provideMainPresenter(gitHubRepository: GitHubRepository): MainPresenter {
        return MainPresenter(gitHubRepository)
    }
}
