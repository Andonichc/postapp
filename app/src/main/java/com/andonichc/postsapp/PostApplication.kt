package com.andonichc.postsapp

import android.app.Application
import com.andonichc.postsapp.di.component.AppComponent
import com.andonichc.postsapp.di.component.DaggerAppComponent
import com.andonichc.postsapp.di.module.AppModule

/**
 * Created by andoni on 19/12/2017.
 */
class PostApplication : Application() {
    val mAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
}
