package com.andonichc.postsapp.presentation.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.andonichc.postsapp.R
import com.andonichc.postsapp.presentation.base.BaseActivity
import com.andonichc.postsapp.presentation.base.BaseActivityTest
import com.andonichc.postsapp.presentation.base.BasePresenter
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import com.andonichc.postsapp.presentation.utils.ext.checkVisibility
import com.andonichc.postsapp.presentation.utils.ext.performClickOnRecyclerViewItem
import com.andonichc.postsapp.presentation.utils.ext.textEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify


class MainActivityTest : BaseActivityTest() {

    @get:Rule
    val mainActivityRule = ActivityTestRule(MainActivity::class.java)

    override fun getRule(): ActivityTestRule<out BaseActivity<out BasePresenter>> = mainActivityRule

    @Test
    fun onShowItems_with_items() {
        //Given
        val activity = mainActivityRule.activity

        val presentationPosts = listOf(
                PostPresentationModel(
                        id = 1,
                        title = "title",
                        avatarUrl = "http://url.com/1",
                        body = "body",
                        userName = "userName"),
                PostPresentationModel(
                        id = 2,
                        title = "title2",
                        avatarUrl = "http://url.com/2",
                        body = "body2",
                        userName = "userName2")
        )

        //When
        activity.runOnUiThread {
            activity.showPosts(presentationPosts)
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.VISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.GONE)

        onView(withText("title"))
                .check(ViewAssertions.matches(isDisplayed()))

        onView(withText("title2"))
                .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun onShowItems_with_empty_list() {
        //Given
        val activity = mainActivityRule.activity
        val presentationPosts = emptyList<PostPresentationModel>()

        //When
        activity.runOnUiThread {
            activity.showPosts(presentationPosts)
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.VISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.GONE)
    }

    @Test
    fun onEmptyState_shows_empty_message() {
        //Given
        val activity = mainActivityRule.activity

        //When
        activity.runOnUiThread {
            activity.showEmptyState()
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.INVISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.VISIBLE)
        R.id.message_text_main_activity.textEquals(R.string.list_emtpy)
    }

    @Test
    fun onErrorState_shows_error_message() {
        //Given
        val activity = mainActivityRule.activity

        //When
        activity.runOnUiThread {
            activity.showErrorState()
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.INVISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.VISIBLE)
        R.id.message_text_main_activity.textEquals(R.string.error_message)
    }

    @Test
    fun onClickListItem_onPostSelected_is_called() {
        //Given
        val activity = mainActivityRule.activity

        val presentationPosts = listOf(
                PostPresentationModel(
                        id = 1,
                        title = "title",
                        avatarUrl = "http://url.com/1",
                        body = "body",
                        userName = "userName"),
                PostPresentationModel(
                        id = 2,
                        title = "title2",
                        avatarUrl = "http://url.com/2",
                        body = "body2",
                        userName = "userName2")
        )

        //When
        activity.runOnUiThread {
            activity.showPosts(presentationPosts)
        }

        R.id.list_main_activity.performClickOnRecyclerViewItem(0)
        //Then
        verify(activity.mPresenter).onPostSelected(presentationPosts[0])

    }

}