package com.andonichc.postsapp.presentation.base


interface BaseView {
    fun showErrorState()
    fun showEmptyState()
}

interface BasePresenter {
    fun onCreate()
    fun onResume()
    fun onStop()
    fun onDestroy()
}