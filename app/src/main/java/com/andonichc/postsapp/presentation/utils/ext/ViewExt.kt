package com.andonichc.postsapp.presentation.utils.ext

import android.content.Context
import android.support.annotation.LayoutRes
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean): View =
        LayoutInflater.from(context).inflate(layout, this, attachToRoot)


fun Float.toDp(context: Context) =
        TypedValue.applyDimension(COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)


fun ViewGroup.MarginLayoutParams.setAllMargins(marginInPx: Int) =
        this.setMargins(marginInPx, marginInPx, marginInPx, marginInPx)

fun ViewGroup.MarginLayoutParams.setAllMargins(marginInPx: Float) =
    this.setAllMargins(marginInPx.toInt())