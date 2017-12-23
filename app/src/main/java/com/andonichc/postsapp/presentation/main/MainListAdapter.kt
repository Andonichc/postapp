package com.andonichc.postsapp.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.andonichc.postsapp.R
import com.andonichc.postsapp.presentation.main.model.PostPresentationModel
import com.andonichc.postsapp.presentation.utils.ext.inflate
import com.andonichc.postsapp.presentation.utils.ext.setAllMargins
import com.andonichc.postsapp.presentation.utils.ext.toDp
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_post.view.*


abstract class MainListAdapter(private val items: List<PostPresentationModel>) :
        RecyclerView.Adapter<MainListAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view = parent.inflate(R.layout.item_post, false)

        (view.layoutParams as RecyclerView.LayoutParams)
                .setAllMargins(4F.toDp(view.context))

        return PostViewHolder(view)
    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
            holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    abstract fun onClickPost(item: PostPresentationModel)

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: PostPresentationModel) {
            itemView.run {
                title_post_item.text = item.title
                Glide.with(context)
                        .load(item.avatarUrl)
                        .into(avatar_img_post_item)

                setOnClickListener { onClickPost(item) }
            }
        }
    }
}