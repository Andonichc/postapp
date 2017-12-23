package com.andonichc.postsapp.data.posts.network

import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.domain.model.PostModel
import io.reactivex.Single
import javax.inject.Inject


class PostsNetworkDataSource
@Inject constructor(private val postsNetworkService: PostsNetworkService, private val mapper: PostNetworkMapper)
    : PostsRepository {

    override fun getPosts(): Single<List<PostModel>> =
            postsNetworkService.getPosts()
                    .map(mapper::map)
}