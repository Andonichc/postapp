package com.andonichc.postsapp.di.component

import com.andonichc.postsapp.di.ActivityScope
import com.andonichc.postsapp.di.module.PostDetailActivityModule
import com.andonichc.postsapp.presentation.postdetail.PostDetailActivity
import dagger.Component


@ActivityScope
@Component(modules = arrayOf(PostDetailActivityModule::class),
        dependencies = arrayOf(AppComponent::class))
interface PostDetailActivityComponent {

    fun inject(activity: PostDetailActivity)
}