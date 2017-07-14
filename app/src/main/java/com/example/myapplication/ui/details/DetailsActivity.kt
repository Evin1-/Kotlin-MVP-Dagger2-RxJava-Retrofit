package com.example.myapplication.ui.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.App

import com.example.myapplication.R
import com.example.myapplication.data.entities.Repository
import com.example.myapplication.di.ApplicationComponent
import com.example.myapplication.utils.ActivityUtils
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        injectDependencies()
        initViews()

        detailsPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        detailsPresenter.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun injectDependencies() {
        val applicationComponent: ApplicationComponent? = (application as App).applicationComponent
        DaggerDetailsComponent.builder()
                .applicationComponent(applicationComponent)
                .detailsModule(DetailsModule())
                .build()
                .inject(this)
    }

    private fun initViews() {
        val repository = intent.getParcelableExtra<Repository>(ActivityUtils.REPOSITORY_KEY)

        a_details_txt.text = repository.url
        supportActionBar?.title = repository.name
    }
}
