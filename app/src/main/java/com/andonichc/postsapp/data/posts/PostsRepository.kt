package com.andonichc.postsapp.data.posts

import com.andonichc.postsapp.domain.model.PostModel
import io.reactivex.Single


interface PostsRepository {
    fun getPosts(): Single<List<PostModel>>
}