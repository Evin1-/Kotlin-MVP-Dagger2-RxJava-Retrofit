package com.example.myapplication.data.remote

import com.example.myapplication.data.entities.Repository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by user on 7/13/17.
 */
object RetrofitManager {
    const val GITHUB_BASE_URL: String = "https://api.github.com/"

    interface GitHubService {
        @GET("/users/{user}/repos")
        fun getRepositories(@Path("user") user: String): Observable<List<Repository>>
    }
}