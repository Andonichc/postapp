package com.andonichc.postsapp.presentation.main

import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import com.andonichc.postsapp.R
import com.andonichc.postsapp.di.component.DaggerMainActivityComponent
import com.andonichc.postsapp.di.module.MainActivityModule
import com.andonichc.postsapp.presentation.base.BaseActivity
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import com.andonichc.postsapp.presentation.utils.ext.gone
import com.andonichc.postsapp.presentation.utils.ext.invisible
import com.andonichc.postsapp.presentation.utils.ext.visible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun setUpView() {
        setContentView(R.layout.activity_main)

        refresh_main_activity.setOnRefreshListener {
            mPresenter.onRefresh()
        }

        list_main_activity.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
    }

    override fun showPosts(posts: List<PostPresentationModel>) {
        list_main_activity.visible()
        message_text_main_activity.gone()

        list_main_activity.adapter = object : MainListAdapter(posts) {
            override fun onClickPost(item: PostPresentationModel) {
                mPresenter.onPostSelected(item)
            }
        }
    }

    override fun showPost(post: PostPresentationModel) {
        //TODO: Detail must be shown called to the detailActivity yet to be implemented
    }

    override fun showErrorState() {
        list_main_activity.invisible()
        showMessage(R.string.error_message)
    }

    override fun showEmptyState() {
        list_main_activity.invisible()
        showMessage(R.string.list_emtpy)
    }

    override fun showLoadingState() {
        refresh_main_activity.isRefreshing = true
    }

    override fun hideLoadingState() {
        refresh_main_activity.isRefreshing = false
    }

    override fun setInjection() =
            DaggerMainActivityComponent.builder()
                    .appComponent(getApp().mAppComponent)
                    .mainActivityModule(MainActivityModule(this))
                    .build()
                    .inject(this)

    private fun showMessage(@StringRes message: Int) =
            message_text_main_activity.run {
                visible()
                setText(message)
            }
}
