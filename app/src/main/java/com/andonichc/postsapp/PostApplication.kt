package com.andonichc.postsapp

import android.app.Application
import com.andonichc.postsapp.presentation.base.di.*


class PostApplication : Application() {
    val mAppComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    val mNetComponent: NetComponent = DaggerNetComponent.builder()
            .netModule(NetModule())
            .build()
}
