package com.andonichc.postsapp

import android.app.Application
import com.andonichc.postsapp.di.component.AppComponent
import com.andonichc.postsapp.di.component.DaggerAppComponent
import com.andonichc.postsapp.di.module.AppModule


class PostApplication : Application() {
    val mAppComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
}
