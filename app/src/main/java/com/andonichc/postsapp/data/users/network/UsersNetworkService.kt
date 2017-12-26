package com.andonichc.postsapp.data.users.network

import io.reactivex.Single
import retrofit2.http.GET


interface UsersNetworkService {
    @GET("/users")
    fun getUsers(): Single<List<UserNetWorkModel>>
}