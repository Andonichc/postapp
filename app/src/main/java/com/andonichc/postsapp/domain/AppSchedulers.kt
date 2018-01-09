package com.andonichc.postsapp.domain

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class AppSchedulers(val main: Scheduler = AndroidSchedulers.mainThread(),
                    val io: Scheduler = Schedulers.io(),
                    val computation: Scheduler = Schedulers.computation(),
                    val trampoline: Scheduler = Schedulers.trampoline())