package com.example.myapplication.base

/**
 * Created by user on 7/14/17.
 */
interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}