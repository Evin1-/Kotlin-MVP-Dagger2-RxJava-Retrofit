package com.example.myapplication.ui.main

import com.example.myapplication.data.GitHubRepository
import com.example.myapplication.data.entities.Repository
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by user on 7/14/17.
 */

class MainPresenter(val gitHubRepository: GitHubRepository) : MainContract.Presenter {

    private val TEST_USER: String = "Evin1-"
    private var view: MainContract.View? = null

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.dispose()
        this.view = null
    }

    override fun loadResults() {
        view?.showProgress()
        gitHubRepository.retrieveRepositories(TEST_USER, object : Observer<List<Repository>> {
            override fun onNext(results: List<Repository>) {
                view?.showResults(results)
            }

            override fun onError(e: Throwable) {
                view?.showError(e.message ?: "There was an error on the request!")
            }

            override fun onComplete() {
                view?.hideProgress()
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)
            }
        })
    }
}
