package com.andonichc.postsapp.presentation.postdetail

import android.support.test.rule.ActivityTestRule
import com.andonichc.postsapp.R
import com.andonichc.postsapp.presentation.base.BaseActivity
import com.andonichc.postsapp.presentation.base.BaseActivityTest
import com.andonichc.postsapp.presentation.base.BasePresenter
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import com.andonichc.postsapp.presentation.utils.ext.isDisplayed
import com.andonichc.postsapp.presentation.utils.ext.textEquals
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify


class PostDetailActivityTest : BaseActivityTest() {

    @get:Rule
    val postDetailActivityRule = ActivityTestRule(PostDetailActivity::class.java)

    override fun getRule(): ActivityTestRule<out BaseActivity<out BasePresenter>> =
            postDetailActivityRule

    @Test
    fun onCreate_calls_onPostParsed() {
        //Given
        val activity = postDetailActivityRule.activity

        //When created

        //Then
        verify(activity.mPresenter).onPostParsed(null)
    }

    @Test
    fun showPost_shows_post() {
        //Given
        val activity = postDetailActivityRule.activity
        val post = PostPresentationModel(
                id = 1,
                title = "title",
                avatarUrl = "https://api.adorable.io/avatars/285/email@example.com",
                body = "body",
                userName = "userName")

        //When
        activity.runOnUiThread {
            activity.showPost(post)
        }

        //Then
        R.id.title_post_detail.textEquals(post.title)
        R.id.body_post_detail.textEquals(post.body)
        R.id.username_post_detail.textEquals(post.userName)
    }

    @Test
    fun showCommentsCount_shows_the_comment_count() {
        //Given
        val activity = postDetailActivityRule.activity
        val commentsCount = 2

        //When
        activity.runOnUiThread {
            activity.showCommentsCount(commentsCount)
        }

        //Then
        R.id.comments_count_post_detail.textEquals(commentsCount.toString())
        R.id.comments_count_post_detail.isDisplayed()
    }

    @Test
    fun showErrorState_finishesActivity() {
        //Given
        val activity = postDetailActivityRule.activity

        //When
        activity.showErrorState()

        //Then
        assertEquals(true, activity.isFinishing)
    }

    @Test
    fun createIntent_returns_proper_intent() {
        //Given
        val activity = postDetailActivityRule.activity
        val post = PostPresentationModel(
                id = 1,
                title = "title",
                avatarUrl = "https://api.adorable.io/avatars/285/email@example.com",
                body = "body",
                userName = "userName")

        //When
        val intent = PostDetailActivity.createIntent(activity, post)

        //Then
        val postFromIntent: PostPresentationModel =
                intent.getParcelableExtra("PostPresentationModel")

        assertEquals(post, postFromIntent)
        val className = "com.andonichc.postsapp.presentation.postdetail.PostDetailActivity"
        assertEquals(className, intent.component.className)

    }


}