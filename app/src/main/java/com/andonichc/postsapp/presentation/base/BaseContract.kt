package com.andonichc.postsapp.presentation.base


interface BaseView {

}

interface BasePresenter {
    fun onCreate()
    fun onResume()
    fun onStop()
    fun onDestroy()
}