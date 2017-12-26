package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.presentation.base.BasePresenter
import com.andonichc.postsapp.presentation.base.BaseView
import com.andonichc.postsapp.presentation.model.PostPresentationModel


interface MainView: BaseView {
    fun showPosts(posts: List<PostPresentationModel>)

    fun showPost(post: PostPresentationModel)
}

interface MainPresenter: BasePresenter {
    fun onPostSelected(post: PostPresentationModel)
    fun onRefresh()
}