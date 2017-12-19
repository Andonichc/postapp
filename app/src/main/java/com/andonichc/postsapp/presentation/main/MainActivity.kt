package com.andonichc.postsapp.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.andonichc.postsapp.R
import com.andonichc.postsapp.presentation.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setInjection() {

    }
}
