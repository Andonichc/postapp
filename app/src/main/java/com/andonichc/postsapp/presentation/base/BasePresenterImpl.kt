package com.andonichc.postsapp.presentation.base

/**
 * Created by andoni on 19/12/2017.
 */
abstract class BasePresenterImpl<out T>(protected val view: T ) : BasePresenter where T: BaseView {

    override fun onCreate() {

    }

    override fun onResume() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {

    }
}