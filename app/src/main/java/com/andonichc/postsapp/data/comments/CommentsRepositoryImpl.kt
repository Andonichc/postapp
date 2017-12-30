package com.andonichc.postsapp.data.comments

import com.andonichc.postsapp.data.comments.network.CommentsNetworkDataSource
import com.andonichc.postsapp.domain.model.CommentModel
import io.reactivex.Single
import javax.inject.Inject


class CommentsRepositoryImpl
@Inject constructor(private val networkDataSource: CommentsNetworkDataSource) : CommentsRepository {
    override fun getComments(): Single<List<CommentModel>> =
            networkDataSource.getComments()
}