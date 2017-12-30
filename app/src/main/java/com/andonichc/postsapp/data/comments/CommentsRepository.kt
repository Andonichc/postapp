package com.andonichc.postsapp.data.comments

import com.andonichc.postsapp.domain.model.CommentModel
import io.reactivex.Single


interface CommentsRepository {
    fun getComments(): Single<List<CommentModel>>
}