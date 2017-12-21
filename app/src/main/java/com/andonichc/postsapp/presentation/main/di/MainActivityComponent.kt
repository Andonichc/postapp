package com.andonichc.postsapp.presentation.main.di

import com.andonichc.postsapp.presentation.base.di.ActivityScope
import com.andonichc.postsapp.presentation.base.di.AppComponent
import com.andonichc.postsapp.presentation.base.di.NetComponent
import com.andonichc.postsapp.presentation.main.MainActivity
import dagger.Component


@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class),
        dependencies = arrayOf(AppComponent::class, NetComponent::class))
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}