package com.andonichc.postsapp.di.module

import com.andonichc.postsapp.PostApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by andoni on 19/12/2017.
 */
@Module
class AppModule(private val mApp: PostApplication) {
    @Provides
    @Singleton
    fun providesApp(): PostApplication =
            mApp
}