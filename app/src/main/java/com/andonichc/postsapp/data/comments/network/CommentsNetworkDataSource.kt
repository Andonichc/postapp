package com.andonichc.postsapp.data.comments.network

import com.andonichc.postsapp.data.comments.CommentsRepository
import com.andonichc.postsapp.domain.model.CommentModel
import io.reactivex.Single
import javax.inject.Inject


class CommentsNetworkDataSource
@Inject constructor(private val commentsNetworkService: CommentsNetworkService,
                    private val mapper: CommentNetworkModelMapper)
    : CommentsRepository {

    override fun getComments(): Single<List<CommentModel>> =
            commentsNetworkService.getComments()
                    .map(mapper::map)
}