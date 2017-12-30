package com.andonichc.postsapp.di

import com.andonichc.postsapp.presentation.main.MainActivity
import com.andonichc.postsapp.presentation.postdetail.PostDetailActivity


interface ActivityInjector {
    fun inject(activity: MainActivity)
    fun inject(activity: PostDetailActivity)
}