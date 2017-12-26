package com.andonichc.postsapp.presentation.utils.ext

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import com.andonichc.postsapp.presentation.main.MainListAdapter


fun Int.checkVisibility(visibility: ViewMatchers.Visibility) {
    Espresso.onView(ViewMatchers.withId(this))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility)))
}

fun Int.performClickOnRecyclerViewItem(position: Int) {
    Espresso.onView(ViewMatchers.withId(this))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MainListAdapter.PostViewHolder>
            (position, ViewActions.click()))
}