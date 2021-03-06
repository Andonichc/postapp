package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.presentation.base.BasePresenter
import com.andonichc.postsapp.presentation.base.BaseView
import com.andonichc.postsapp.presentation.model.PostPresentationModel


interface PostDetailView : BaseView {
    fun showPost(post: PostPresentationModel)
    fun showCommentsCount(count: Int)
}

interface PostDetailPresenter : BasePresenter {
    fun onPostParsed(post: PostPresentationModel?)
}