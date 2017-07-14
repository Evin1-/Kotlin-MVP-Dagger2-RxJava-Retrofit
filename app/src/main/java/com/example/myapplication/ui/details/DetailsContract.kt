package com.example.myapplication.ui.details

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.base.BaseView

/**
 * Created by user on 7/14/17.
 */
interface DetailsContract {
    interface View : BaseView
    interface Presenter : BasePresenter<View>
}