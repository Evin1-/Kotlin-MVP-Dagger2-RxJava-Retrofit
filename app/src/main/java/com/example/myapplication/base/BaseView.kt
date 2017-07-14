package com.example.myapplication.base

/**
 * Created by user on 7/14/17.
 */
interface BaseView {
    fun showError(error: String)
    fun injectDependencies()
}