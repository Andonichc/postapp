package com.andonichc.postsapp.di.component

import com.andonichc.postsapp.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

}