package com.andonichc.postsapp.presentation.postdetail

import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.mockito.Mockito.mock


class PostDetailActivityTest {

    private val postDetailPresenter = mock(PostDetailPresenter::class.java)

    @get:Rule
    val postDetailActivityRule = ActivityTestRule(PostDetailActivity::class.java)

}