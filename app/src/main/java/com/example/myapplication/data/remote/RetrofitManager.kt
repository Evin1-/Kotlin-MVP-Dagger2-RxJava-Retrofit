package com.example.myapplication.data.remote

import com.example.myapplication.data.entities.Repository
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * Created by user on 7/13/17.
 */
object RetrofitManager {
    const val BASE_URL: String = "https://api.github.com/"

    fun create(): GitHubService {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(GitHubService::class.java)
    }
}