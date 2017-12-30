package com.andonichc.postsapp.di.module

import com.andonichc.postsapp.di.ActivityScope
import com.andonichc.postsapp.domain.usecase.GetPostsUseCase
import com.andonichc.postsapp.presentation.main.MainPresenter
import com.andonichc.postsapp.presentation.main.MainPresenterImpl
import com.andonichc.postsapp.presentation.main.MainView
import com.andonichc.postsapp.presentation.main.PostPresentationMapper
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(private val mainView: MainView) {

    @Provides
    @ActivityScope
    fun provideMainView(): MainView = mainView

    @Provides
    @ActivityScope
    fun provideMainPresenter(mainView: MainView,
                             getPostsUseCase: GetPostsUseCase,
                             postsMapper: PostPresentationMapper): MainPresenter =
            MainPresenterImpl(mainView, getPostsUseCase, postsMapper)

}