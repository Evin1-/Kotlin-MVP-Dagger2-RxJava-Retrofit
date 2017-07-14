package com.example.myapplication.data

import com.example.myapplication.data.entities.Repository
import com.example.myapplication.data.remote.RetrofitManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by user on 7/14/17.
 */
class GitHubRepository(val gitHubService: RetrofitManager.GitHubService) {
    fun retrieveRepositories(username: String, observer: Observer<List<Repository>>) {
        gitHubService.getRepositories(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}