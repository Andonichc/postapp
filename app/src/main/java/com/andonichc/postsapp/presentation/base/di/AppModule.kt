package com.andonichc.postsapp.presentation.base.di

import com.andonichc.postsapp.PostApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val mApp: PostApplication) {
    @Provides
    @Singleton
    fun providesApp(): PostApplication =
            mApp
}