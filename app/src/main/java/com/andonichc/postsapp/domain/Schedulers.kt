package com.andonichc.postsapp.domain

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers as RxSchedulers


class Schedulers(val main: Scheduler = AndroidSchedulers.mainThread(),
                 val io: Scheduler = RxSchedulers.io(),
                 val computation: Scheduler = RxSchedulers.computation(),
                 val trampoline: Scheduler = RxSchedulers.trampoline())