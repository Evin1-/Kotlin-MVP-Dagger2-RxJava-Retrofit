package com.example.myapplication.data.remote

import com.example.myapplication.data.entities.Repository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by user on 7/14/17.
 */
interface GitHubService {
    @GET("/users/{user}/repos/")
    fun getRepositories(@Query("user") user: String): Observable<List<Repository>>
}