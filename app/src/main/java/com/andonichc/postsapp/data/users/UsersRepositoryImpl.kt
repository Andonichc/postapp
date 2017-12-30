package com.andonichc.postsapp.data.users

import com.andonichc.postsapp.data.users.network.UsersNetworkDataSource
import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single
import javax.inject.Inject


class UsersRepositoryImpl
@Inject constructor(private val networkDataSource: UsersNetworkDataSource)
    : UsersRepository {
    override fun getUsers(): Single<List<UserModel>> =
            networkDataSource.getUsers()
}