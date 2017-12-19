package com.andonichc.postsapp.presentation.base

/**
 * Created by andoni on 19/12/2017.
 */
interface BaseView {

}

interface BasePresenter {
    fun onCreate()
    fun onResume()
    fun onStop()
    fun onDestroy()
}