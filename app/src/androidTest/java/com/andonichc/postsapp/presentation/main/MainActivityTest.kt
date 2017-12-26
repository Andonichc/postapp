package com.andonichc.postsapp.presentation.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.andonichc.postsapp.R
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import com.andonichc.postsapp.presentation.utils.ext.checkVisibility
import com.andonichc.postsapp.presentation.utils.ext.performClickOnRecyclerViewItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class MainActivityTest {

    private val mainPresenter = mock(MainPresenter::class.java)

    @get:Rule
    val mainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initTest() {
        mainActivityRule.activity.mPresenter = mainPresenter
    }

    @Test
    fun onShowItems_with_items() {
        //Given
        val presentationPosts = listOf(
                PostPresentationModel(id = 1, title = "title", avatarUrl = "http://url.com/1"),
                PostPresentationModel(id = 2, title = "title2", avatarUrl = "http://url.com/2")
        )

        //When
        mainActivityRule.activity.runOnUiThread {
            mainActivityRule.activity.showPosts(presentationPosts)
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
        val presentationPosts = emptyList<PostPresentationModel>()

        //When
        mainActivityRule.activity.runOnUiThread {
            mainActivityRule.activity.showPosts(presentationPosts)
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.VISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.GONE)
    }

    @Test
    fun onEmptyState_shows_empty_message() {
        //When
        mainActivityRule.activity.runOnUiThread {
            mainActivityRule.activity.showEmptyState()
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.INVISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.VISIBLE)
        onView(withId(R.id.message_text_main_activity))
                .check(ViewAssertions.matches(withText(R.string.list_emtpy)))
    }

    @Test
    fun onErrorState_shows_error_message() {
        //When
        mainActivityRule.activity.runOnUiThread {
            mainActivityRule.activity.showErrorState()
        }

        //Then
        R.id.list_main_activity.checkVisibility(Visibility.INVISIBLE)
        R.id.message_text_main_activity.checkVisibility(Visibility.VISIBLE)
        onView(withId(R.id.message_text_main_activity))
                .check(ViewAssertions.matches(withText(R.string.error_message)))
    }

    @Test
    fun onClickListItem_onPostSelected_is_called() {
        //Given
        val presentationPosts = listOf(
                PostPresentationModel(id = 1, title = "title", avatarUrl = "http://url.com/1"),
                PostPresentationModel(id = 2, title = "title2", avatarUrl = "http://url.com/2")
        )

        //When
        mainActivityRule.activity.runOnUiThread {
            mainActivityRule.activity.showPosts(presentationPosts)
        }

        R.id.list_main_activity.performClickOnRecyclerViewItem(0)
        //Then
        verify(mainPresenter).onPostSelected(presentationPosts[0])

    }
}