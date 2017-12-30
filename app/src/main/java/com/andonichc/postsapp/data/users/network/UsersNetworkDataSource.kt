package com.andonichc.postsapp.data.users.network

import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single
import javax.inject.Inject


class UsersNetworkDataSource
@Inject constructor(private val usersNetworkService: UsersNetworkService,
                    private val mapper: UserNetworkMapper)
    : UsersRepository {

    override fun getUsers(): Single<List<UserModel>> =
            usersNetworkService.getUsers()
                    .map(mapper::map)
}