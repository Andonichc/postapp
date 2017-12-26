package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.presentation.base.BasePresenter
import com.andonichc.postsapp.presentation.base.BaseView


interface PostDetailView: BaseView {
    fun showPost()
}

interface PostDetailPresenter: BasePresenter {
}