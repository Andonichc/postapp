package com.andonichc.postsapp.data.comments

import io.reactivex.Single
import retrofit2.http.GET


interface CommentsNetworkService {
    @GET("/comments")
    fun getComments(): Single<List<CommentNetworkModel>>
}