package com.andonichc.postsapp.di.module

import com.andonichc.postsapp.di.ActivityScope
import com.andonichc.postsapp.domain.usecase.GetCommentsForPostUseCase
import com.andonichc.postsapp.presentation.postdetail.CommentsCountMapper
import com.andonichc.postsapp.presentation.postdetail.PostDetailPresenter
import com.andonichc.postsapp.presentation.postdetail.PostDetailPresenterImpl
import com.andonichc.postsapp.presentation.postdetail.PostDetailView
import dagger.Module
import dagger.Provides


@Module
class PostDetailActivityModule(private val postDetailView: PostDetailView) {

    @Provides
    @ActivityScope
    fun provideMainView(): PostDetailView = postDetailView

    @Provides
    @ActivityScope
    fun providePostDetailPresenter(postDetailView: PostDetailView,
                                   getCommentsForPostUseCase: GetCommentsForPostUseCase,
                                   commentsCountMapper: CommentsCountMapper): PostDetailPresenter =
            PostDetailPresenterImpl(postDetailView, getCommentsForPostUseCase, commentsCountMapper)

}