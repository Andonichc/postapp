package com.andonichc.postsapp.di.module

import com.andonichc.postsapp.BuildConfig
import com.andonichc.postsapp.data.comments.CommentsNetworkService
import com.andonichc.postsapp.data.posts.PostsNetworkService
import com.andonichc.postsapp.data.users.UsersNetworkService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class NetModule {


    @Provides
    fun providesOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .build()

    @Provides
    @Singleton
    fun providesRetrofit(httpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(httpClient)
                    .build()


    @Provides
    @Singleton
    fun providesCommentsNetworkService(retrofit: Retrofit): CommentsNetworkService =
            retrofit.create(CommentsNetworkService::class.java)

    @Provides
    @Singleton
    fun providesPostsNetworkService(retrofit: Retrofit): PostsNetworkService =
            retrofit.create(PostsNetworkService::class.java)

    @Provides
    @Singleton
    fun providesUsersNetworkService(retrofit: Retrofit): UsersNetworkService =
            retrofit.create(UsersNetworkService::class.java)
}