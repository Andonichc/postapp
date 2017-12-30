package com.andonichc.postsapp

import com.andonichc.postsapp.di.ActivityInjector
import com.andonichc.postsapp.presentation.main.MainActivity
import com.andonichc.postsapp.presentation.main.MainPresenter
import com.andonichc.postsapp.presentation.postdetail.PostDetailActivity
import com.andonichc.postsapp.presentation.postdetail.PostDetailPresenter
import org.mockito.Mockito.mock


class ActivityTestInjector : ActivityInjector {
    override fun inject(activity: MainActivity) {
        activity.mPresenter = mock(MainPresenter::class.java)
    }

    override fun inject(activity: PostDetailActivity) {
        activity.mPresenter = mock(PostDetailPresenter::class.java)
    }
}