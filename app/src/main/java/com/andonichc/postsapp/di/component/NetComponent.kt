package com.andonichc.postsapp.di.component

import com.andonichc.postsapp.data.comments.CommentsNetworkService
import com.andonichc.postsapp.data.posts.PostsNetworkService
import com.andonichc.postsapp.data.users.UsersNetworkService
import com.andonichc.postsapp.di.module.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetModule::class))
interface NetComponent {

    fun providesCommentsNetworkService(): CommentsNetworkService

    fun providesPostsNetworkService(): PostsNetworkService

    fun providesUsersNetworkService(): UsersNetworkService
}