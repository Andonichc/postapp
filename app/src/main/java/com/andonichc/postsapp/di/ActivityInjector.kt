package com.andonichc.postsapp.di

import com.andonichc.postsapp.di.component.DaggerMainActivityComponent
import com.andonichc.postsapp.di.component.DaggerPostDetailActivityComponent
import com.andonichc.postsapp.di.module.MainActivityModule
import com.andonichc.postsapp.di.module.PostDetailActivityModule
import com.andonichc.postsapp.presentation.main.MainActivity
import com.andonichc.postsapp.presentation.postdetail.PostDetailActivity


class ActivityInjector {
    fun inject(activity: MainActivity) {
        DaggerMainActivityComponent.builder()
                .appComponent(activity.getApp().mAppComponent)
                .mainActivityModule(MainActivityModule(activity))
                .build()
                .inject(activity)
    }

    fun inject(activity: PostDetailActivity) {
        DaggerPostDetailActivityComponent.builder()
                .appComponent(activity.getApp().mAppComponent)
                .postDetailActivityModule(PostDetailActivityModule(activity))
                .build()
                .inject(activity)
    }
}