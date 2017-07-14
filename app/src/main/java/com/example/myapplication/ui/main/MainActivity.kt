package com.example.myapplication.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.data.entities.Repository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG = "MainActivityTAG_"

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependencies()

        a_main_btn.setOnClickListener { mainPresenter.loadResults() }
    }

    override fun injectDependencies() {
        val applicationComponent = (application as App).applicationComponent

        DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(MainModule())
                .build()
                .inject(this)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showResults(results: List<Repository>) {
        for (result in results) {
            Log.d(TAG, result.toString())
        }
    }

    override fun showProgress() {
        a_main_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        a_main_progress.visibility = View.INVISIBLE
    }
}
