package com.andonichc.postsapp.presentation.main.di

import com.andonichc.postsapp.presentation.base.di.ActivityScope
import com.andonichc.postsapp.presentation.main.MainPresenter
import com.andonichc.postsapp.presentation.main.MainPresenterImpl
import com.andonichc.postsapp.presentation.main.MainView
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(private val mainView: MainView) {

    @Provides
    @ActivityScope
    fun provideMainView(): MainView = mainView

    @Provides
    @ActivityScope
    fun provideMainPresenter(mainView: MainView): MainPresenter = MainPresenterImpl(mainView)

}