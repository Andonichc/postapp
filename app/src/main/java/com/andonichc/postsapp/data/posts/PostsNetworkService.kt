package com.andonichc.postsapp.data.posts

import io.reactivex.Single
import retrofit2.http.GET


interface PostsNetworkService {
    @GET("/posts")
    fun getPosts(): Single<List<PostNetworkModel>>
}