package com.andonichc.postsapp

import android.app.Application
import com.andonichc.postsapp.di.component.DaggerAppComponent
import com.andonichc.postsapp.di.component.DaggerNetComponent
import com.andonichc.postsapp.presentation.base.di.AppModule
import com.andonichc.postsapp.presentation.base.di.NetModule


class PostApplication : Application() {
    val mAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    val mNetComponent = DaggerNetComponent.builder()
            .netModule(NetModule())
            .build()
}
