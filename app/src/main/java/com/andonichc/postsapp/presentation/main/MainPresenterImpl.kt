package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.domain.usecase.PostsUseCase
import com.andonichc.postsapp.presentation.base.BasePresenterImpl
import com.andonichc.postsapp.presentation.main.model.PostPresentationModel
import io.reactivex.rxkotlin.subscribeBy


class MainPresenterImpl constructor(view: MainView,
                                    private val postsUseCase: PostsUseCase,
                                    private val mapper: PostPresentationMapper)
    : BasePresenterImpl<MainView>(view), MainPresenter {

    override fun onCreate() {
        loadPosts()
    }

    override fun onPostSelected(post: PostPresentationModel) {
        view.showPost(post)
    }

    private fun loadPosts() {
        postsUseCase.execute()
                .map(mapper::map)
                .subscribeBy (
                        onSuccess = { posts ->
                            when{
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