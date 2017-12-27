package com.andonichc.postsapp.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide


class GlideImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    fun load(url: String) {
        Glide.with(context)
                .load(url)
                .into(this)
    }
}