package com.example.myapplication.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.data.entities.Repository
import com.example.myapplication.ui.details.DetailsActivity
import com.example.myapplication.utils.ActivityUtils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG = "MainActivityTAG_"

    @Inject
    lateinit var mainPresenter: MainPresenter

    val repositories: MutableList<Repository> = mutableListOf<Repository>()
    var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependencies()
        initViews()

        mainPresenter.attachView(this)
        a_main_btn.setOnClickListener { mainPresenter.loadResults() }
    }

    override fun onDestroy() {
        super.onDestroy()

        mainPresenter.detachView()
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
        println(results)
        repositories.clear()
        repositories.addAll(results)
        mainAdapter?.notifyDataSetChanged()
    }

    override fun showProgress() {
        a_main_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        a_main_progress.visibility = View.INVISIBLE
    }

    private fun initViews() {
        mainAdapter = MainAdapter(repositories) { ActivityUtils.startActivityRepository(this, it) }
        a_main_recycler.adapter = mainAdapter
        a_main_recycler.layoutManager = LinearLayoutManager(this)
        a_main_recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
