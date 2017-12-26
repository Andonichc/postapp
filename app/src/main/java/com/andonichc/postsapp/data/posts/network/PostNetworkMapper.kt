package com.andonichc.postsapp.data.posts.network

import com.andonichc.postsapp.domain.ListMapper
import com.andonichc.postsapp.domain.model.PostModel
import javax.inject.Inject


class PostNetworkMapper
@Inject constructor() : ListMapper<PostNetworkModel, PostModel>() {
    override fun map(from: PostNetworkModel): PostModel = PostModel(
            id = from.id,
            userId = from.userId,
            title = from.title,
            body = from.body
    )
}