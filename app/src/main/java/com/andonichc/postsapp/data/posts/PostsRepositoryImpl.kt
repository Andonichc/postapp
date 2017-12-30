package com.andonichc.postsapp.data.posts

import com.andonichc.postsapp.data.posts.network.PostsNetworkDataSource
import com.andonichc.postsapp.domain.model.PostModel
import io.reactivex.Single
import javax.inject.Inject


class PostsRepositoryImpl
@Inject constructor(private val networkDataSource: PostsNetworkDataSource)
    : PostsRepository {

    override fun getPosts(): Single<List<PostModel>> =
            networkDataSource.getPosts()

}