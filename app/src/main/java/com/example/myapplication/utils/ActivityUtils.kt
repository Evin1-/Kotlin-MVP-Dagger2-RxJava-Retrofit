package com.example.myapplication.utils

import android.content.Context
import android.content.Intent
import com.example.myapplication.data.entities.Repository
import com.example.myapplication.ui.details.DetailsActivity

/**
 * Created by user on 7/14/17.
 */
object ActivityUtils {
    const val REPOSITORY_KEY = "REPOSITORY_KEY"

    fun startActivityRepository(context: Context, repository: Repository) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(REPOSITORY_KEY, repository)
        context.startActivity(intent)
    }
}