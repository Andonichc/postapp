package com.andonichc.postsapp.presentation.utils.ext

import android.app.Activity
import android.support.test.InstrumentationRegistry


fun Activity.runOnUiThreadSync(task: () -> Unit) {
    runOnUiThread(task)
    InstrumentationRegistry.getInstrumentation().waitForIdleSync()
}

fun Activity.callOnStop() = runOnUiThreadSync {
    InstrumentationRegistry.getInstrumentation().callActivityOnStop(this)
}



