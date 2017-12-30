package com.andonichc.postsapp

import android.app.Application
import android.support.test.runner.AndroidJUnitRunner


class CustomTestRunner : AndroidJUnitRunner() {

    override fun callApplicationOnCreate(app: Application?) {
        super.callApplicationOnCreate(app)

        (app as PostApplication).mInjector = ActivityTestInjector()
    }
}