package com.andonichc.postsapp.presentation.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.andonichc.postsapp.R
import com.andonichc.postsapp.presentation.main.di.MainActivityModule
import com.andonichc.postsapp.presentation.base.BaseActivity
import com.andonichc.postsapp.presentation.main.di.DaggerMainActivityComponent
import com.andonichc.postsapp.presentation.main.model.PostPresentationModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setUpView() {
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

    override fun setInjection() {
        DaggerMainActivityComponent.builder()
                .appComponent(getApp().mAppComponent)
                .netComponent(getApp().mNetComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)
    }
}
