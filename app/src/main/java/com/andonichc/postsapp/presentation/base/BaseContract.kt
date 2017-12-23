package com.andonichc.postsapp.presentation.base


interface BaseView {
    fun showErrorState()
    fun showEmptyState()
    fun showLoadingState()
    fun hideLoadingState()
}

interface BasePresenter {
    fun onCreate()
    fun onResume()
    fun onStop()
    fun onDestroy()
}