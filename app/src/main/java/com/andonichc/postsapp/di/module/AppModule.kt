package com.andonichc.postsapp.di.module

import com.andonichc.postsapp.PostApplication
import com.andonichc.postsapp.data.comments.CommentsRepository
import com.andonichc.postsapp.data.comments.CommentsRepositoryImpl
import com.andonichc.postsapp.data.comments.network.CommentsNetworkDataSource
import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.posts.PostsRepositoryImpl
import com.andonichc.postsapp.data.posts.network.PostsNetworkDataSource
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.data.users.UsersRepositoryImpl
import com.andonichc.postsapp.data.users.network.UsersNetworkDataSource
import com.andonichc.postsapp.domain.Schedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val mApp: PostApplication) {
    @Provides
    @Singleton
    fun providesApp(): PostApplication =
            mApp

    @Provides
    @Singleton
    fun providesSchedulers(): Schedulers =
            Schedulers()

    @Provides
    @Singleton
    fun providesPostsRepository(networkDataSource: PostsNetworkDataSource): PostsRepository =
            PostsRepositoryImpl(networkDataSource)

    @Provides
    @Singleton
    fun providesUsersRepository(networkDataSource: UsersNetworkDataSource): UsersRepository =
            UsersRepositoryImpl(networkDataSource)

    @Provides
    @Singleton
    fun providesCommentsRepository(networkDataSource: CommentsNetworkDataSource): CommentsRepository =
            CommentsRepositoryImpl(networkDataSource)
}