package com.andonichc.postsapp.di.component

import com.andonichc.postsapp.di.module.AppModule
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

}