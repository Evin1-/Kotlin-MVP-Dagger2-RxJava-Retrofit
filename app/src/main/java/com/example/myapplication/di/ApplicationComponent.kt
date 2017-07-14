package com.example.myapplication.di

import com.example.myapplication.data.GitHubRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by user on 7/14/17.
 */
@Singleton
@Component(modules = arrayOf(NetworkModule::class, RepositoryModule::class))
interface ApplicationComponent {
    fun githubRepository(): GitHubRepository
}