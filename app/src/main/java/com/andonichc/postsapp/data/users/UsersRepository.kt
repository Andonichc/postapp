package com.andonichc.postsapp.data.users

import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single


interface UsersRepository {

    fun getUsers(): Single<List<UserModel>>
}