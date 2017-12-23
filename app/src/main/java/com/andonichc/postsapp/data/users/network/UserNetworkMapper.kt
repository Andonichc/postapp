package com.andonichc.postsapp.data.users.network

import com.andonichc.postsapp.domain.ListMapper
import com.andonichc.postsapp.domain.model.UserModel
import javax.inject.Inject


class UserNetworkMapper
@Inject constructor() : ListMapper<UserNetWorkModel, UserModel>() {

    override fun map(from: UserNetWorkModel): UserModel = UserModel(
            id = from.id,
            name = from.name,
            userName = from.userName,
            email = from.email
    )
}