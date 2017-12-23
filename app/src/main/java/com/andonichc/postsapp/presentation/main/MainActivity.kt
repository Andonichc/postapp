package com.andonichc.postsapp.presentation.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.andonichc.postsapp.R
import com.andonichc.postsapp.di.component.DaggerMainActivityComponent
import com.andonichc.postsapp.di.module.MainActivityModule
import com.andonichc.postsapp.presentation.base.BaseActivity
import com.andonichc.postsapp.presentation.main.model.PostPresentationModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun setUpView() {
        setContentView(R.layout.activity_main)

        list_main_activity.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
    }

    override fun showPosts(posts: List<PostPresentationModel>) {
        list_main_activity.adapter = object: MainListAdapter(posts) {
            override fun onClickPost(item: PostPresentationModel) {
                mPresenter.onPostSelected(item)
            }
        }
    }

    override fun showPost(post: PostPresentationModel) {
        //TODO: Detail must be shown called to the detailActivity yet to be implemented
    }

    override fun showErrorState() {

    }

    override fun setInjection() {
        DaggerMainActivityComponent.builder()
                .appComponent(getApp().mAppComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)
    }
}
