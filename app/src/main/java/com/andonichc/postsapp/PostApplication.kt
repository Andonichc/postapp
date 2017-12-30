package com.andonichc.postsapp

import android.app.Application
import android.content.Context
import android.support.annotation.VisibleForTesting
import com.andonichc.postsapp.di.ActivityInjector
import com.andonichc.postsapp.di.ActivityInjectorImpl
import com.andonichc.postsapp.di.component.AppComponent
import com.andonichc.postsapp.di.component.DaggerAppComponent
import com.andonichc.postsapp.di.module.AppModule


class PostApplication : Application() {
    val mAppComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    var mInjector: ActivityInjector = ActivityInjectorImpl()
        @VisibleForTesting(otherwise = Context.MODE_PRIVATE)
        set
}
