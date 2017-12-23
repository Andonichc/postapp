package com.andonichc.postsapp.di.module

import com.andonichc.postsapp.PostApplication
import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.posts.PostsRepositoryImpl
import com.andonichc.postsapp.data.posts.network.PostsNetworkDataSource
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
}