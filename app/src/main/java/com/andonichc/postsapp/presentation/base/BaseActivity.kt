package com.andonichc.postsapp.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.andonichc.postsapp.PostApplication
import javax.inject.Inject


abstract class BaseActivity<T> : AppCompatActivity(), BaseView where T : BasePresenter {

    @Inject
    protected lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInjection()

        setUpView()

        mPresenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    protected open fun setUpView() {

    }

    fun getApp(): PostApplication = application as PostApplication

    abstract fun setInjection()
}