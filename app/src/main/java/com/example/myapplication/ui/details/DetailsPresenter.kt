package com.example.myapplication.ui.details


/**
 * Created by user on 7/14/17.
 */
class DetailsPresenter : DetailsContract.Presenter {
    private var view: DetailsContract.View? = null

    override fun attachView(view: DetailsContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}