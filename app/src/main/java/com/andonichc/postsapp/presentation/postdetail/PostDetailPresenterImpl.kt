package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.domain.usecase.GetCommentsForPostUseCase
import com.andonichc.postsapp.presentation.base.BasePresenterImpl
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import io.reactivex.rxkotlin.subscribeBy


class PostDetailPresenterImpl
constructor(view: PostDetailView,
            private val getCommentsForPostUseCase: GetCommentsForPostUseCase,
            private val mapper: CommentsCountMapper)
    : BasePresenterImpl<PostDetailView>(view), PostDetailPresenter {

    private lateinit var mPost: PostPresentationModel

    override fun onPostParsed(post: PostPresentationModel?) {
        if (post != null) {
            mPost = post

            view.showPost(mPost)
            loadCommentsCount()
        } else {
            view.showErrorState()
        }
    }

    private fun loadCommentsCount() {
        getCommentsForPostUseCase.execute(mPost.id)
                .doOnSubscribe { view.showLoadingState() }
                .doFinally { view.hideLoadingState() }
                .map(mapper::map)
                .subscribeBy {

                }
    }
}