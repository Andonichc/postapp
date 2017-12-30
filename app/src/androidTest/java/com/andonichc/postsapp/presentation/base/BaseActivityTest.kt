package com.andonichc.postsapp.presentation.base

import android.support.test.rule.ActivityTestRule
import com.andonichc.postsapp.presentation.utils.ext.callOnStop
import org.junit.Test
import org.mockito.Mockito.verify


abstract class BaseActivityTest {
    abstract fun getRule(): ActivityTestRule<out BaseActivity<out BasePresenter>>

    @Test
    fun onCreate_calls_presenter_onCreate() {
        //Given
        val activity = getRule().activity

        //When created

        //Then
        verify(activity.mPresenter).onCreate()
        verify(activity.mPresenter).onResume()
    }

    @Test
    fun onStop_calls_presenter_onStop() {
        //Given
        val activity = getRule().activity

        //When
        activity.callOnStop()

        //Then
        verify(activity.mPresenter).onStop()
    }
}