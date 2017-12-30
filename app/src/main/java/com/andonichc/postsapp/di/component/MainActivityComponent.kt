package com.andonichc.postsapp.di.component

import com.andonichc.postsapp.di.ActivityScope
import com.andonichc.postsapp.di.module.MainActivityModule
import com.andonichc.postsapp.presentation.main.MainActivity
import dagger.Component


@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class),
        dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}