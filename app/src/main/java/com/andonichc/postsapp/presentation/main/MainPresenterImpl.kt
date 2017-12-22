package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.presentation.base.BasePresenterImpl
import com.andonichc.postsapp.presentation.main.model.PostPresentationModel


class MainPresenterImpl constructor(view: MainView) :
        BasePresenterImpl<MainView>(view), MainPresenter {

    override fun onCreate() {
        loadPosts()
    }

    override fun onPostSelected(post: PostPresentationModel) {
        view.showPost(post)
    }

    private fun loadPosts() {

    }
}