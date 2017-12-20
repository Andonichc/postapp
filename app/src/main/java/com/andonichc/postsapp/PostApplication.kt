package com.andonichc.postsapp

import android.app.Application
import com.andonichc.postsapp.di.component.DaggerAppComponent
import com.andonichc.postsapp.di.component.DaggerNetComponent
import com.andonichc.postsapp.di.module.AppModule
import com.andonichc.postsapp.di.module.NetModule

/**
 * Created by andoni on 19/12/2017.
 */
class PostApplication : Application() {
    val mAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    val mNetComponent = DaggerNetComponent.builder()
            .netModule(NetModule())
            .build()
}
