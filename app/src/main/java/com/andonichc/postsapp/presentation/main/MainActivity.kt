package com.andonichc.postsapp.presentation.main

import android.os.Bundle
import com.andonichc.postsapp.R
import com.andonichc.postsapp.di.component.DaggerMainActivityComponent
import com.andonichc.postsapp.di.module.MainActivityModule
import com.andonichc.postsapp.presentation.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setInjection() {
        DaggerMainActivityComponent.builder()
                .appComponent(getApp().mAppComponent)
                .netComponent(getApp().mNetComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)
    }
}
