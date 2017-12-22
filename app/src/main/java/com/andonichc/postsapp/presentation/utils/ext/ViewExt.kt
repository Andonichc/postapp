package com.andonichc.postsapp.presentation.utils.ext

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(@LayoutRes layout: Int): View =
        LayoutInflater.from(context).inflate(layout, this)