package com.andonichc.postsapp.di.component

import com.andonichc.postsapp.data.comments.CommentsRepository
import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.di.module.AppModule
import com.andonichc.postsapp.di.module.NetModule
import com.andonichc.postsapp.domain.AppSchedulers
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    fun providesSchedulers(): AppSchedulers

    fun providesPostsRepository(): PostsRepository

    fun providesUsersRepository(): UsersRepository

    fun providesCommentsRepository(): CommentsRepository
}