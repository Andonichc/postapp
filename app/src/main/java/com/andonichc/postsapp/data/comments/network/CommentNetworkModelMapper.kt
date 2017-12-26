package com.andonichc.postsapp.data.comments.network

import com.andonichc.postsapp.domain.ListMapper
import com.andonichc.postsapp.domain.model.CommentModel
import javax.inject.Inject


class CommentNetworkModelMapper
@Inject constructor() : ListMapper<CommentNetworkModel, CommentModel>() {
    override fun map(from: CommentNetworkModel): CommentModel =
            CommentModel(
                    id = from.id,
                    postId = from.postId,
                    name = from.name,
                    email = from.email,
                    body = from.body
            )
}