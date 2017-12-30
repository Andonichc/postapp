package com.andonichc.postsapp.presentation.utils.ext

import android.support.annotation.StringRes
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import com.andonichc.postsapp.R
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

fun Int.textEquals(@StringRes text: Int) {
    Espresso.onView(ViewMatchers.withId(this))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
}

fun Int.textEquals(text: String) {
    Espresso.onView(ViewMatchers.withId(this))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
}


fun Int.isDisplayed() {
    Espresso.onView(ViewMatchers.withId(this))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}