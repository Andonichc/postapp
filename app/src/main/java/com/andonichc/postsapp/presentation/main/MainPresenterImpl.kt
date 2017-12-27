package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.domain.usecase.GetPostsUseCase
import com.andonichc.postsapp.presentation.base.BasePresenterImpl
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import io.reactivex.rxkotlin.subscribeBy


class MainPresenterImpl constructor(view: MainView,
                                    private val getPostsUseCase: GetPostsUseCase,
                                    private val mapper: PostPresentationMapper)
    : BasePresenterImpl<MainView>(view), MainPresenter {

    override fun onCreate() {
        loadPosts()
    }

    override fun onPostSelected(post: PostPresentationModel) {
        view.showPost(post)
    }

    override fun onRefresh() {
        loadPosts()
    }

    private fun loadPosts() {
        getPostsUseCase.execute()
                .doOnSubscribe { view.showLoadingState() }
                .doFinally { view.hideLoadingState() }
                .map(mapper::map)
                .subscribeBy(
                        onSuccess = { posts ->
                            when {
                                posts.isEmpty() -> view.showEmptyState()
                                else -> view.showPosts(posts)
                            }
                        },
                        onError = {
                            view.showErrorState()
                        }
                )
    }
}