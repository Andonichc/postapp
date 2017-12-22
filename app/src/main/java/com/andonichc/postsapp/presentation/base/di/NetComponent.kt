package com.andonichc.postsapp.presentation.base.di

import com.andonichc.postsapp.data.comments.CommentsNetworkService
import com.andonichc.postsapp.data.posts.PostsNetworkService
import com.andonichc.postsapp.data.users.UsersNetworkService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetModule::class))
interface NetComponent {

    fun providesCommentsNetworkService(): CommentsNetworkService

    fun providesPostsNetworkService(): PostsNetworkService

    fun providesUsersNetworkService(): UsersNetworkService
}