package com.andonichc.postsapp.presentation.postdetail

import android.support.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock


class PostDetailActivityTest {

    private val postDetailPresenter = mock(PostDetailPresenter::class.java)

    @get:Rule
    val postDetailActivityRule = ActivityTestRule(PostDetailActivity::class.java)

    @Before
    fun initTest() {
        postDetailActivityRule.activity.mPresenter = postDetailPresenter
    }
}