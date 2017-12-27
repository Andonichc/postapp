package com.andonichc.postsapp.presentation.postdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.andonichc.postsapp.R
import com.andonichc.postsapp.di.component.DaggerPostDetailActivityComponent
import com.andonichc.postsapp.di.module.PostDetailActivityModule
import com.andonichc.postsapp.presentation.base.BaseActivity
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import kotlinx.android.synthetic.main.activity_post_detail.*


class PostDetailActivity : BaseActivity<PostDetailPresenter>(), PostDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        parsePostFromIntent(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    private fun parsePostFromIntent(bundle: Bundle?) {
        val post: PostPresentationModel? = bundle?.getParcelable(POST)
        mPresenter.onPostParsed(post)
    }

    override fun setUpView() {
        setContentView(R.layout.activity_post_detail)
    }

    override fun showPost(post: PostPresentationModel) {
        avatar_img_post_detail.load(post.avatarUrl)
        title_post_detail.text = post.title
        body_post_detail.text = post.body
        username_post_detail.text = post.userName
    }

    override fun showCommentsCount(count: Int) {
        comments_count_post_detail.text = count.toString()
    }

    override fun setInjection() {
        DaggerPostDetailActivityComponent.builder()
                .appComponent(getApp().mAppComponent)
                .postDetailActivityModule(PostDetailActivityModule(this))
                .build()
                .inject(this)
    }

    override fun showErrorState() {
        finish()
    }
}

private const val POST = "PostPresentationModel"

fun createIntent(context: Context, postPresentationModel: PostPresentationModel): Intent {
    val intent = Intent(context, PostDetailActivity::class.java)

    intent.putExtra(POST, postPresentationModel)

    return intent
}
