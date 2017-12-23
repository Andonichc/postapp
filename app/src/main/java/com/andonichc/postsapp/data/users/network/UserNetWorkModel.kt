package com.andonichc.postsapp.data.users.network

import com.google.gson.annotations.SerializedName


data class UserNetWorkModel(val id: Int,
                            val name: String,
                            @SerializedName("username")
                            val userName: String,
                            val email: String)


//Other values of the User like the address or the company have been ignored
//due to be irrelevant to business and presentation layers.